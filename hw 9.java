import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NotCorrectAgeException extends Exception {
    public NotCorrectAgeException(String message) {
        super(message);
    }
}

class Student {
    private int age;
    private String firstName, lastName, middleName;
    private int course;
    private double averageScore;

    public Student(int age, String firstName, String lastName, String middleName, int course, double averageScore) throws NotCorrectAgeException {
        setAge(age);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.course = course;
        this.averageScore = averageScore;
    }

    public void setAge(int age) throws NotCorrectAgeException {
        if (age < 16 || age > 60) throw new NotCorrectAgeException("Возраст должен быть от 16 до 60 лет.");
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, Возраст: %d, Курс: %d, Средний балл: %.2f", firstName, lastName, age, course, averageScore);
    }
}

class Group {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) throws Exception {
        if (students.size() >= 15) throw new Exception("Группа переполнена.");
        students.add(student);
    }

    public void removeStudent(int index) throws Exception {
        if (students.size() <= 3) throw new Exception("Нельзя удалить студента, останется менее 3.");
        students.remove(index);
    }

    public void showStudents() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);

        try {
            // Добавление студентов
            for (int i = 0; i < 2; i++) { // Добавим 2 студента для примера
                System.out.print("Введите возраст: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите имя: ");
                String firstName = scanner.nextLine();
                System.out.print("Введите фамилию: ");
                String lastName = scanner.nextLine();
                System.out.print("Введите отчество: ");
                String middleName = scanner.nextLine();
                System.out.print("Введите курс: ");
                int course = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите средний балл: ");
                double averageScore = Double.parseDouble(scanner.nextLine());

                group.addStudent(new Student(age, firstName, lastName, middleName, course, averageScore));
            }

            group.showStudents();
            group.removeStudent(0); // Удаляем первого студента
            group.showStudents();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
