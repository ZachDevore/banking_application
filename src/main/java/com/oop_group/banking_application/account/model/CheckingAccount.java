package com.oop_group.banking_application.account.model;

public class CheckingAccount extends Account {

    /**The interest rate for a checking account */
    private double interestRate;

    /**How much you are allowed to overdraft your account */
    private double overDraftLimit;

    /**How much the fee for overdrafting is */
    private double overDraftFee;

    /**
     * Constructor for checking account
     * @param balance starting balance of the account
     * @param customerId unique identifier for the customer
     */
    public CheckingAccount(double balance, String customerId) {
        super(balance, customerId);
        this.overDraftLimit = 100; // allowed to overdraft an account by $100
        this.overDraftFee = 15; // $15 penalty for overdrafting an account
        this.interestRate = 0.01; // 1% APY interest for checking accounts
    }

    /**@return the interest rate for a checking account */
    public double getInterestRate() {return this.interestRate;}

    /**@return the fee for overdrafting an account */
    public double getOverDraftFee() {return this.overDraftFee;}

    /**@return the limit an account can be overdrafted */
    public double getOverDraftLimit() {return this.overDraftLimit;}

    /**
     * Setter for the interest rate of a checking account
     * @param interestRate new rate
     */
    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    /**
     * Setter for the overdraft limit
     * @param overDraftLimit new limit
     */
    public void setOverDraftLimit(double overDraftLimit) {this.overDraftLimit = overDraftLimit;}

    /**
     * Setter for the overdraft fee
     * @param overDraftFee mew fee
     */
    public void setOverDraftFee(double overDraftFee) {this.overDraftFee = overDraftFee;}

    /**
     * Check to see if money can be withdrawn from the account
     * @param amount to be withdrawn
     * @return true if money can be taken out false if not
     */
    @Override
    protected boolean canWithdraw(double amount) {
        return getBalance() + overDraftLimit >= amount;
    }

    /**@return the type of account */
    @Override
    public String getAccountType() {return "Checking";}
}
