package club.nullbyte3.interduction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServicePoint {

    private static final int idCount = 0;
    private final String name;
    private final int id;
    private final LinkedList<Customer> queue = new LinkedList<>();

    public ServicePoint(String name) {
        this.name = name;
        this.id = idCount;
    }

    public void addCustomer(Customer customer) {
        queue.addLast(customer);
    }

    public void addAll(List<Customer> customers) {
        queue.addAll(customers);
    }

    // made with the help of ChatGPT -Vivsam.
    /* (Old code without the help of chatgpt)
    while (!customers.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Impossible to happen unless another thread or a process like the OS stops us. -Vivsam.
                e.printStackTrace();
            }
            Customer c = servicePoint.serve();
            if (c != null) {
                times.add(c.calculateTime());
                System.out.println("Customer (" + c.getId() + ") served in " + c.calculateTime() + "ms");
            }
        }
        AtomicLong totalTime = new AtomicLong();
        times.stream().forEach(time -> totalTime.addAndGet(time));
        System.out.println("Average time: " + totalTime.get() / totalCustomers + "ms");
     */
    public void serve() {
        List<Long> serviceTimes = new ArrayList<>();
        while (!queue.isEmpty()) {
            Customer customer = queue.removeFirst();
            long waitingTime = System.currentTimeMillis() - customer.getStartTime();

            long serviceTime = (long) (Math.random() * 3000) + 1000;
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                // Impossible to happen unless another thread or a process like the OS stops us. -Vivsam.
                e.printStackTrace();
            }

            customer.setEndTime(System.currentTimeMillis());
            long responseTime = waitingTime + serviceTime;

            serviceTimes.add(serviceTime);
            System.out.println("Customer (" + customer.getId() + ") served in " + responseTime + "ms");
        }

        long totalServiceTime = serviceTimes.stream().mapToLong(Long::longValue).sum();
        System.out.println("Average service time: " + (totalServiceTime / serviceTimes.size()) + "ms");
    }

}
