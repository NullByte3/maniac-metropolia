package club.nullbyte3.interduction;

import java.util.ArrayList;
import java.util.List;

public class CustomerGenerator {

    public static List<Customer> getCustomers(int n) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Customer customer = new Customer();
            customer.setStartTime(System.currentTimeMillis());
            customers.add(customer);
        }
        return customers;
    }

    public static void main(String[] args) {
        int totalCustomers = 10;
        List<Customer> customers = getCustomers(totalCustomers);
        ServicePoint servicePoint = new ServicePoint("Service Point 1");
        servicePoint.addAll(customers);
        servicePoint.serve();
    }

}
