package com.oop_group.banking_application.account.model;

import java.util.UUID;

public abstract class Account {

    /**The unique account number */
    private String accountNumber;

    /**The balance of the account*/
    private double balance;

    /**The id of the customer */
    private String customerId;


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

    /**
     * deposit money into the account
     * @param amount to be deposited
     * @throws IllegalArgumentException if the amount to be deposited is less than 0
     */
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) { // deposit amount less than $0
            throw new IllegalArgumentException("Deposit must be greater that $0");
        }
        balance += amount;
    }

    /**
     * withdraw money from the account
     * @param amount to be withdrawn
     * @throws IllegalArgumentException if not enough money in the account
     */
    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than $0");
        }
        if (!canWithdraw(amount)) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
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
