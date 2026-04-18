package com.oop_group.banking_application.account.model;

public class MoneyMarketAccount extends Account {

    /**Interest rate for a money market account */
    private double interestRate;

    /**
     * Constructor for a money market account
     * @param balance starting balance
     * @param customerId unique identifier for the customer
     * @param interestRate for the money market account
     */
    public MoneyMarketAccount(double balance, String customerId, double interestRate) {
        super(balance, customerId);
        this.interestRate = interestRate;
    }

    /**@return the interest rate for a money market account */
    public double getInterestRate() {return this.interestRate;}

    /**
     * Setter for interest rate of a money market account
     * @param interestRate new rate
     */
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    /**@return the type of account */
    @Override
    public String getAccountType() {return "Money Market";}
}
