package com.oop_group.banking_application.customer.service;

import com.oop_group.banking_application.customer.model.Customer;
import com.oop_group.banking_application.customer.repository.CustomerRepository;

import java.util.List;

public class CustomerService {

    /** "Databse" that will hold our customers */
    private CustomerRepository customerRepository;

    /**
     * Constructor
     */
    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    /**
     * Create a new customer
     * @param customer to be added
     * @throws IllegalArgumentException if the customer already exist
     */
    public void createCustomer(Customer customer) throws IllegalArgumentException{
        if (customerRepository.customerExist(customer.getCustomerId())) {
            throw new IllegalArgumentException("The customer already exist");
        }
        customerRepository.saveCustomer(customer);
    }

    /**
     * Retrieves the customer by checking the id
     * @param customerId of the customer to be retrieved
     * @return the customer
     * @throws IllegalArgumentException if the customer could not be found
     */
    public Customer getCustomerById(String customerId) throws IllegalArgumentException {
        if (!customerRepository.customerExist(customerId)) {
            throw new IllegalArgumentException("Customer could not be found");
        }
        return customerRepository.findByCustomerNumber(customerId);
    }

    /**
     * Retrieves a list of all of the customers
     * @return a list of the customers
     * @throws IllegalStateException if the list is empty
     */
    public List<Customer> getAllCustomers() throws IllegalStateException{
        if (customerRepository.getAllCustomers().isEmpty()) {
            throw new IllegalStateException("There are no customers");
        }
        return customerRepository.getAllCustomers();
    }

    /**
     * Delete a customer
     * @param customerId of the customer to be deleted
     * @throws IllegalArgumentException if the customer cannot be found
     */
    public void deleteCustomer(String customerId) throws IllegalArgumentException {
        if (!customerRepository.customerExist(customerId)) {
            throw new IllegalArgumentException("Customer could not be found");
        }
        customerRepository.deleteCustomer(customerId);
    }

    /**
     * Update an existing customer
     * @param customer to be updated
     * @throws IllegalArgumentException if the customer cannot be found
     */
    public void updateCustomer(Customer customer) throws IllegalArgumentException {
        if (!customerRepository.customerExist(customer.getCustomerId())) {
            throw new IllegalArgumentException("Customer could not be found");
        }
        customerRepository.updateCustomerInfo(customer);
    }
}
