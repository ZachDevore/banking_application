package com.oop_group.banking_application.customer.model;

import java.util.UUID;

public class Customer {

    /** ID of the customer */
    private String customerId;

    /** Last name of the customer*/
    private String customerLastName;

    /** First name of the customer*/
    private String customerFirstName;


    /** Username for the customer*/
    private String username;


    /**password for the customers account*/
    private String password;

    /**
     * Constructor
     * @param customerLastName last name of the customer
     * @param customerFirstName first name of the customer
     */
    public Customer(String customerLastName, String customerFirstName, String username, String password) {
        this.customerId = UUID.randomUUID().toString(); // generate a random id
        this.customerLastName = customerLastName;
        this.customerFirstName = customerFirstName;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for customerId
     * @return the id of the customer
     */
    public String getCustomerId() {return this.customerId;}

    /**
     * Getter for customerLastName
     * @return the last name of the customer
     */
    public String getCustomerLastName() {return this.customerLastName;}

    /**
     * Getter for the customerFirstName
     * @return the first name of the customer
     */
    public String getCustomerFirstName() {return this.customerFirstName;}


    /**
     * Getter for customers username
     * @return the username for the customer
     */

    public String getUsername() {
        return username;
    }

    /**
     * Getter for the customers password
     * @return the password for the customer
     */

    public String getPassword() {
        return password;
    }

    /**
     * Setter for customerId
     * @param customerId the new id for the customer
     */
    public void setCustomerId(String customerId) {this.customerId = customerId;}

    /**
     * Setter for the last name
     * @param customerLastName the new last name of the customer
     */
    public void setCustomerLastName(String customerLastName) {this.customerLastName = customerLastName;}

    /**
     * Setter for the first name
     * @param customerFirstName new first name of the customer
     */
    public void setCustomerFirstName(String customerFirstName) {this.customerFirstName = customerFirstName;}


    /**
     * Setter for the customers username
     * @param username new for username of the customer
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Setter for the pasowrd
     * @param password new for the password of the customer
     */

    public void setPassword(String password) {
        this.password = password;
    }
}
