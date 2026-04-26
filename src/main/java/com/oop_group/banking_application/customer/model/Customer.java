package com.oop_group.banking_application.customer.model;

import java.util.UUID;

public class Customer {
    private String customerId;
    private String customerLastName, customerFirstName, username, password;

    public Customer(String last, String first, String user, String pass) {
        // Generates an 8-character unique alphanumeric ID
        this.customerId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.customerLastName = last;
        this.customerFirstName = first;
        this.username = user;
        this.password = pass;
    }

    public String getCustomerId() { return customerId; }
    public String getCustomerFirstName() { return customerFirstName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}