import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

enum ProductName {
    APPLE, BANANA, ORANGE, GRAPE, WATERMELON, PINEAPPLE, MANGO
}

class Product {
    private String name;
    private double price;
    private double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", weight=" + weight + "}";
    }
}
class ShoppingCart {
    private List<Product> cart = new ArrayList<>();
    private static final Random random = new Random();
    private static final String FAVORITE_PRODUCT_NAME = "MANGO"; // Ваш любимый продукт

    public void addProduct(Product product) {
        for (Product p : cart) {
            if (p.getName().equals(product.getName())) {
                System.out.println("Продукт " + product.getName() + " уже в корзине.");
                return;
            }
        }
        cart.add(product);
    }

    public void removeHeavyAndExpensiveProducts() {
        cart.removeIf(product -> product.getWeight() > 5 || product.getPrice() > 10000);
    }

    public void prioritizeFavoriteProduct() {
        for (Product product : cart) {
            if (product.getName().equals(FAVORITE_PRODUCT_NAME)) {
                cart.remove(product);
                cart.add(0, product);
                break;
            }
        }
    }

    public void printProductsUnder10AndOver2() {
        for (Product product : cart) {
            if (product.getPrice() < 10 && product.getWeight() > 2) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<ProductName> productNames = new ArrayList<>(EnumSet.allOf(ProductName.class));


        for (int i = 0; i < 20; i++) {
            String name = productNames.get(random.nextInt(productNames.size())).name();
            double price = random.nextDouble() * 20000; // Случайная цена от 0 до 20000
            double weight = random.nextDouble() * 10; // Случайный вес от 0 до 10 кг
            shoppingCart.addProduct(new Product(name, price, weight));
        }


        shoppingCart.removeHeavyAndExpensiveProducts();


        shoppingCart.prioritizeFavoriteProduct();


        System.out.println("Продукты с ценой < 10 и весом > 2:");
        shoppingCart.printProductsUnder10AndOver2();
    }
}