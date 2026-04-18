package com.oop_group.banking_application.account.model;

public class CheckingAccount extends Account {

    /**The interest rate for a checking account */
    private double interestRate;

    /**
     * Constructor for checking account
     * @param balance starting balance of the account
     * @param customerId unique identifier for the customer
     * @param interestRate of the checking account
     */
    public CheckingAccount(double balance, String customerId, double interestRate) {
        super(balance, customerId);
        this.interestRate = interestRate;
    }

    /**@return the interest rate for a checking account */
    public double getInterestRate() {return this.interestRate;}

    /**
     * Setter for the interest rate of a checking account
     * @param interestRate new rate
     */
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    /**@return the type of account */
    @Override
    public String getAccountType() {return "Checking";}
}
