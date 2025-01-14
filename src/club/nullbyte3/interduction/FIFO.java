package club.nullbyte3.interduction;

import java.util.LinkedList;
import java.util.Scanner;

public class FIFO {

    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        loop:
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add a customer");
            System.out.println("2. Get a customer");
            System.out.println("3. Exit the program.");
            String option = new Scanner(System.in).nextLine();
            switch (option) {
                case "1":
                    Customer customer = new Customer();
                    customer.setStartTime(System.currentTimeMillis());
                    queue.addFirst(customer);
                    System.out.println("Customer (" + customer.getId() + ") added.\n");
                    break;
                case "2":
                    if (queue.isEmpty()) {
                        System.out.println("No customers in the queue.");
                        continue;
                    }
                    Customer c = queue.removeLast();
                    c.setEndTime(System.currentTimeMillis());
                    System.out.println("Customer (" + c.getId() + ") spent " + c.calculateTime() + "ms");
                case "3":
                    System.out.println("Exiting...");
                    break loop;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

}
