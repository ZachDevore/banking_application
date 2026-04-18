package com.oop_group.banking_application.account.model;

public class SavingsAccount extends Account {

    /**The interest rate of a savings account */
    private double interestRate;

    /**
     * Constructor for Savings Account
     * @param balance of the account
     * @param customerId unique identifier of the customer
     * @param interestRate of the account
     */
    public SavingsAccount(double balance, String customerId, double interestRate) {
        super(balance, customerId);
        this.interestRate = interestRate;
    }

    /**@return the interest rate */
    public double getInterestRate() {return this.interestRate;}

    /**
     * Set a new interest rate
     * @param interestRate of the account
     */
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    /**Apply the interest to the account */
    public void applyInterest() {
        deposit(getBalance() * interestRate); // current balance * interestRate
    }

    /**@return the type of account */
    @Override
    public String getAccountType() {return "Savings";}
}
