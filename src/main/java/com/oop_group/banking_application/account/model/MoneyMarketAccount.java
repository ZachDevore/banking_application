package com.oop_group.banking_application.account.model;

public class MoneyMarketAccount extends Account {

    /** Interest rate for a money market account */
    private double interestRate;

    /** Minimum amount required to open an account*/
    private double minimumOpeningDeposit;

    /** Withdrawals allowed per month */
    private int maxWithdrawalPerMonth;

    /** Counter for the number of withdrawals done this month */
    private int withdrawalsThisMonth;

    /**
     * Constructor for a money market account
     * @param balance starting balance
     * @param customerId unique identifier for the customer
     */
    public MoneyMarketAccount(double balance, String customerId) {
        super(balance, customerId);
        this.interestRate = .2; // 2% interest
        this.minimumOpeningDeposit = 250; // $250 required to open the account
        this.maxWithdrawalPerMonth = 1; // can only withdrawal once per month
        this.withdrawalsThisMonth = 0;
    }

    /**@return the interest rate for a money market account */
    public double getInterestRate() {return this.interestRate;}

    /**@return the minimum amount required to open the account */
    public double getMinimumOpeningDeposit() {return this.minimumOpeningDeposit;}

    /**@return the maximum number of withdrawals per month */
    public int getMaxWithdrawalPerMonth() {return this.maxWithdrawalPerMonth;}

    /**
     * Setter for interest rate of a money market account
     * @param interestRate new rate
     */
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    /**
     * Setter for the minimum amount required to open an account
     * @param minimumOpeningDeposit new minimum opening deposit amount
     */
    public void setMinimumOpeningDeposit(double minimumOpeningDeposit) {this.minimumOpeningDeposit = minimumOpeningDeposit;}

    /**
     * Setter for the number of withdrawals allowed per month
     * @param maxWithdrawalPerMonth new amount of withdrawals per month allowed
     */
    public void setMaxWithdrawalPerMonth(int maxWithdrawalPerMonth) {this.maxWithdrawalPerMonth = maxWithdrawalPerMonth;}

    /**
     * withdrawal money from the account
     * @param amount to be withdrawn
     * @throws IllegalArgumentException if the monthly limit is reached
     */
    @Override
    public void withdraw(double amount) throws IllegalArgumentException{
        if (withdrawalsThisMonth >= maxWithdrawalPerMonth) {
            throw new IllegalArgumentException("Monthly withdrawal limit reached.");
        }
        super.withdraw(amount);
        withdrawalsThisMonth++;
    }

    /**@return the type of account */
    @Override
    public String getAccountType() {return "Money Market";}
}
