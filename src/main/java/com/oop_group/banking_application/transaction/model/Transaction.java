package com.oop_group.banking_application.transaction.model;


import java.time.LocalDateTime;

public class Transaction {

    /** Date and time of the transaction */
    private LocalDateTime dateTime;

    /** Customer ID of the customer who did the transaction*/
    private String customerId;

    /** The Account ID of the account that did the transaction*/
    private String accountId;

    /** The amount of the transaction*/
    private double amount;

    /**
     * Constructor
     * @param customerId of the customer
     * @param accountId of the account
     * @param amount of the transaction
     */
    public Transaction(String customerId, String accountId, double amount) {
        this.dateTime = LocalDateTime.now();
        this.customerId = customerId;
        this.accountId = accountId;
        this.amount = amount;
    }

    /**
     * Getter for the date and time of the transaction
     * @return the date and time of the transaction
     */
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    /**
     * Getter for the Customer ID
     * @return the customerId
     */
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Getter for the Account ID
     * @return the accountId
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     * Getter for the amount
     * @return the amount of the transaction
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Set a new date and time
     * @param dateTime new date and time to be set
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Set a new Customer ID
     * @param customerId to be set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Set a new Account ID
     * @param accountId to be set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * Set a new amount
     * @param amount to be set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
