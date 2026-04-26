package com.oop_group.banking_application.customer.model;

import java.util.UUID;

/**
 * The Customer class represents
 * a single user within the banking system.
 * * Key Responsibilities:
 * - Encapsulates user identity data including name, username, and password.
 * - Handles automatic unique identifier (UID) generation for account numbers
 * using the java.util.UUID utility to ensure data integrity.
 * - Provides getter methods to allow Controllers to safely retrieve user data
 * without modifying the original object state (Encapsulation).
 */
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
    /**getter for customer ID*/
    /**@return cusomterId */
    public String getCustomerId() { return customerId; }

    /**getter for customer*/
    public String getCustomerFirstName() { return customerFirstName; }

    /**getter for customers username*/
    public String getUsername() { return username; }

    /**getter for uesrs password*/
    public String getPassword() { return password; }
}