import java.util.*;
import java.util.stream.*;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

// ---------------- Employee Class ----------------
class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

// ---------------- Student Class ----------------
class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " | Marks: " + marks;
    }
}

// ---------------- Product Class ----------------
class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Category: " + category;
    }
}

// ---------------- Main Nimbus Assignment ----------------
public class NimbusLambdaStreams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Nimbus Java Assignment: Lambda & Streams ===");
            System.out.println("1. Sort Employees (Lambda Expressions)");
            System.out.println("2. Filter & Sort Students (Streams)");
            System.out.println("3. Product Dataset Analysis (Streams)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> partA_SortEmployees();
                case 2 -> partB_FilterSortStudents();
                case 3 -> partC_ProductDataset();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ---------------- Part A: Sorting Employee Objects ----------------
    private static void partA_SortEmployees() {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Alice", 30, 55000),
                new Employee("Bob", 25, 40000),
                new Employee("Charlie", 35, 70000),
                new Employee("David", 28, 50000)
        ));

        System.out.println("\n--- Employees Original List ---");
        employees.forEach(System.out::println);

        // Sort by name
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);

        // Sort by age
        employees.sort(Comparator.comparingInt(e -> e.age));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        // Sort by salary (descending)
        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        System.out.println("\nSorted by Salary (Descending):");
        employees.forEach(System.out::println);
    }

    // ---------------- Part B: Filtering & Sorting Students ----------------
    private static void partB_FilterSortStudents() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Aman", 60),
                new Student("Bina", 85),
                new Student("Chetan", 92),
                new Student("Deepa", 74),
                new Student("Esha", 88)
        ));

        System.out.println("\n--- All Students ---");
        students.forEach(System.out::println);

        System.out.println("\nStudents scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted(Comparator.comparingDouble(s -> s.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }

    // ---------------- Part C: Stream Operations on Products ----------------
    private static void partC_ProductDataset() {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("Laptop", 75000, "Electronics"),
                new Product("Phone", 60000, "Electronics"),
                new Product("TV", 55000, "Electronics"),
                new Product("Shirt", 2000, "Clothing"),
                new Product("Jeans", 3000, "Clothing"),
                new Product("Blender", 4000, "Home Appliances"),
                new Product("Microwave", 8000, "Home Appliances")
        ));

        System.out.println("\n--- All Products ---");
        products.forEach(System.out::println);

        // Group by category
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("\nProducts Grouped by Category:");
        grouped.forEach((cat, list) -> {
            System.out.println(cat + " => " + list);
        });

        // Most expensive product in each category
        Map<String, Optional<Product>> mostExpensive = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensive.forEach((cat, prod) -> {
            System.out.println(cat + " => " + prod.get());
        });

        // Average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
