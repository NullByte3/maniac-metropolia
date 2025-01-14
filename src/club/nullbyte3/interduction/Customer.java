package club.nullbyte3.interduction;

import java.util.LinkedList;

public class Customer {
    private static int idCount = 1;
    private int id;
    private long startTime, endTime;

    public Customer() {
        id = idCount;
        idCount++;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setStartTime(123);
        customer.setEndTime(644);

        Customer customer2 = new Customer();
        customer2.setStartTime(125);
        customer2.setEndTime(990);

        LinkedList<Customer> queue = new LinkedList<>();
        queue.addFirst(customer);
        queue.addFirst(customer2);

        for (int i = 0; i < queue.size(); i++) {
            Customer c = queue.removeLast();
            System.out.println("Asiakkaalla (" + c.getId() + ") meni " + c.calculateTime());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long calculateTime() {
        return endTime - startTime;
    }
}