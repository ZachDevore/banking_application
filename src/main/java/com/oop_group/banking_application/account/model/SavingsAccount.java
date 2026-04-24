package com.oop_group.banking_application.account.model;

public class SavingsAccount extends Account {

    /** The interest rate of a savings account */
    private double interestRate;

    /** The minimum balance that must be kept in the account */
    private double minimumBalanceRequired;

    /**
     * Constructor for Savings Account
     * @param balance of the account
     * @param customerId unique identifier of the customer
     */
    public SavingsAccount(double balance, String customerId) {
        super(balance, customerId);
        this.interestRate = .025;
        this.minimumBalanceRequired = 25; // must have at least $25 in a savings account
        transactionHistory.add("Deposit: $250.00            04-22-26                 ");
        transactionHistory.add("Deposit: $250.00            03-22-26                 ");
        transactionHistory.add("Deposit: $250.00            02-22-26                 ");
        transactionHistory.add("Deposit: $250.00            01-22-26                 ");
    }

    /**@return the interest rate */
    public double getInterestRate() {return this.interestRate;}

    /**@return the minimum balance required to keep the account open */
    public double getMinimumBalanceRequired() {return this.minimumBalanceRequired;}

    /**
     * Set a new interest rate
     * @param interestRate of the account
     */
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    /**
     * Setter for the minimum balance required
     * @param minimumBalanceRequired the new minium balance required to keep an account open
     */
    public void setMinimumBalanceRequired(double minimumBalanceRequired) {this.minimumBalanceRequired = minimumBalanceRequired;}

    /**
     * calculate the interest to the account
     *
     * @return the interest rate calulated
     */
    @Override
    public double calculateInterest() {return this.getBalance() * interestRate;}


    /**@return the type of account */
    @Override
    public String getAccountType() {return "Savings";}
}
