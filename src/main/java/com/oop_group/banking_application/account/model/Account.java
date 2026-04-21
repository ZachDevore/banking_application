package com.oop_group.banking_application.account.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {

    /**The unique account number */
    private String accountNumber;

    /**The balance of the account*/
    private double balance;

    /**The id of the customer */
    private String customerId;

    /**Adds the transaction history for the account*/
    protected List<String> transactionHistory = new ArrayList<>();


    /**
     * Constructor for Account
     * @param balance of the account
     * @param customerId unique identifier of the customer
     */
    public Account(double balance, String customerId) {
        this.accountNumber = UUID.randomUUID().toString(); // generate a random id
        this.balance = balance;
        this.customerId = customerId;
    }

    /**@return the account number */
    public String getAccountNumber() {return this.accountNumber;}

    /**@return the balance */
    public double getBalance() {return this.balance;}

    /**@return the customerId */
    public String customerId() {return this.customerId;}

    /**@return the list of transaction strings*/
    public List<String> getTransactionHistory() {
        return this.transactionHistory;
    }

    /**
     * deposit money into the account
     * @param amount to be deposited
     * @throws IllegalArgumentException if the amount to be deposited is less than 0
     */
    public void deposit(double amount) throws IllegalArgumentException {
        balance += amount;
        //adds to the transaction history when a deposit is made
        String record = String.format("Deposit: +$%.2f",amount);
        transactionHistory.add(record);
    }

    /**
     * withdraw money from the account
     * @param amount to be withdrawn
     * @throws IllegalArgumentException if not enough money in the account
     */
    public void withdraw(double amount) throws IllegalArgumentException {
        balance -= amount;
        //adds to the transaction history when a withdrawal is made
        String record = String.format("Withdrawal: -$%.2f", amount);
        transactionHistory.add(record);
    }

    /**
     * check to see if the customer has enough money in their account
     * @param amount to be withdrawn
     * @return true of they have enough money false if not
     */
    protected boolean canWithdraw(double amount) {
        return balance >= amount; // if there is enough money in the account return true
    }

    /**@return a String representation of the account type */
    public abstract String getAccountType();

    /**@return the interest earned through the account */
    public abstract double calculateInterest();

}
