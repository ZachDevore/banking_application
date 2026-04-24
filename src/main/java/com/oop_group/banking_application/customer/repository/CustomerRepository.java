package com.oop_group.banking_application.customer.repository;

import com.oop_group.banking_application.customer.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerRepository {

    /** Map of the different customers */
    private Map<String, Customer> customers;

    /**
     * Constructor for the customer repository
     */
    public CustomerRepository() {
        customers = new HashMap<>();
    }

    /**
     * Checks to see if a customer exist
     * @param customerId to be checked
     * @return true of the customer exist, false if not
     */
    public boolean customerExist(String customerId) {
        return customers.containsKey(customerId);
    }

    /**
     * Save a new customer
     * @param customer new customer to be saved
     */
    public void saveCustomer(Customer customer) {customers.put(customer.getCustomerId(), customer);}

    /**
     * Find a customer
     * @param customerId of the customer to be found
     * @return the customer
     */
    public Customer findByCustomerNumber(String customerId) {return customers.get(customerId);}

    /**
     * Retrieve all of the customers
     * @return A list of the customers
     */
    public List<Customer> getAllCustomers() {return new ArrayList<Customer>(customers.values());}

    /**
     * Update an existing customer
     * @param customer to be updated
     */
    public void updateCustomerInfo(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    /**
     * Delete a customer
     * @param customerId of the customer to be deleted
     */
    public void deleteCustomer(String customerId) {
        customers.remove(customerId);
    }
}
