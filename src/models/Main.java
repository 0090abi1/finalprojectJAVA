package models;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("Coffee Ordering System");
            System.out.println("1. Add Coffee");
            System.out.println("2. View Order");
            System.out.println("3. Remove Coffee");
            System.out.println("4. Clear Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCoffee(scanner, order);
                    break;
                case 2:
                    viewOrder(order);
                    break;
                case 3:
                    removeCoffee(scanner, order);
                    break;
                case 4:
                    clearOrder(order);
                    break;
                case 5:
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using the Coffee Ordering System!");
    }

    private static void addCoffee(Scanner scanner, Order order) {

        Coffee coffee = new Coffee(1, "Espresso", 2.5);
        System.out.println(coffee.getName() + " added to your order.");
    }


    private static void viewOrder(Order order) {
        System.out.println("Your Order:");
        int i = 1;
        for (Coffee coffee : order.getCoffees()) {
            System.out.println(i++ + ". " + coffee.getName() + " - $" + coffee.getPrice());
        }
        if (order.getCoffees().isEmpty()) {
            System.out.println("Your order is empty.");
        }
    }

    private static void removeCoffee(Scanner scanner, Order order) {
        viewOrder(order);
        if (!order.getCoffees().isEmpty()) {
            System.out.print("Enter the index of the coffee to remove: ");
            int index = scanner.nextInt();
            if (index >= 1 && index <= order.getCoffees().size()) {
                Coffee removedCoffee = order.getCoffees().remove(index - 1);
                System.out.println(removedCoffee.getName() + " removed from your order.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    private static void clearOrder(Order order) {
        order.removeAllCoffees();
        System.out.println("Your order has been cleared.");
    }
}
