import java.util.ArrayList;
import java.util.List;

class Store {
 
    public static class Product {
        private float weight;
        private float price;
        private String name;

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            if (weight < 0) {
                System.out.println("Вес в минус");
                return; 
            }
            this.weight = weight;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            if (weight < 0) {
                System.out.println("Цена в минус");
                return; 
            }
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Product(String name, float price, float weight){
            this.name = name;
            this.price = price;
            this.weight = weight;
        }
    }

    private int cashierCount;
    private int sellerCount;
    private List<Product> products;

    public Store() {
        this.cashierCount = 1;
        this.sellerCount = 1;
        this.products = new ArrayList<>();
    }

    public Store(int cashierCount, int sellerCount, List<Product> products) {
        this.cashierCount = cashierCount;
        this.sellerCount = sellerCount;
        this.products = products != null ? products : new ArrayList<>();
    }

    public int getCashierCount() {
        return cashierCount;
    }

    public void setCashierCount(int cashierCount) {
        this.cashierCount = cashierCount;
    }

    public int getSellerCount() {
        return sellerCount;
    }

    public void setSellerCount(int sellerCount) {
        this.sellerCount = sellerCount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public float averageProductWeight() {
        if (products.isEmpty()) {
            return 0;
        }
        
        float totalWeight = 0;
        int productCount = products.size();
        
        for (int i = 0; i < productCount; i++) {
            Product product = products.get(i);
            totalWeight += product.getWeight();
        }
        
        return totalWeight / productCount;
    }

    public float cashierEfficiency() {
        if (cashierCount == 0) return 0;
        return (float) sellerCount / cashierCount;
    }

    public float efficiency() {
        return averageProductWeight() * cashierEfficiency();
    }
}

class Supermarket extends Store {
    private float area;
    private List<String> categories;

    public Supermarket() {
        super();
        this.area = 100;
        this.categories = new ArrayList<>();
    }

    public Supermarket(int cashierCount, int sellerCount, float area, List<String> categories, List<Product> products) {
        super(cashierCount, sellerCount, products);
        this.area = area;
        this.categories = categories != null ? categories : new ArrayList<>();
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }

    public float efficiency() {
        if (categories.isEmpty()) {
            return 0;
        }
        
        float areaEfficiency = area / categories.size();
        return areaEfficiency * cashierEfficiency();
    }

}
