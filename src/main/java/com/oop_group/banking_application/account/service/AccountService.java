package com.oop_group.banking_application.account.service;

import com.oop_group.banking_application.account.model.Account;
import com.oop_group.banking_application.account.repository.AccountRepository;

import java.util.List;

public class AccountService {

    /** "Database" that our accounts will be stored in */
    private AccountRepository accountRepository;

    /** Constructor */
    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    /**
     * Create a new account
     * @param account new account to be created
     * @throws IllegalArgumentException thrown if the account already exist
     */
    public void createAccount(Account account) throws IllegalArgumentException {
        if (accountRepository.accountExist(account.getAccountNumber())) {
            throw new IllegalArgumentException("Account already exists");
        }
        accountRepository.saveAccount(account);
    }

    /**
     * Retrieves an account by the account number
     * @param accountNumber to be checked
     * @return the account
     * @throws IllegalArgumentException if no account matching the number is found
     */
    public Account getAccountByNumber(String accountNumber) throws IllegalArgumentException {
        if (!accountExist(accountNumber)) {
            throw new IllegalArgumentException("The account is not found");
        }
        return accountRepository.findByAccountNumber(accountNumber);
    }

    /**
     * Retrieves all of the accounts
     * @return a list of type Account with all of the accounts
     */
    public List<Account> getAllAccounts() throws IllegalStateException{
        if (accountRepository.findAllAccounts().isEmpty()) {
            throw new IllegalStateException("There are no accounts");
        }
        return accountRepository.findAllAccounts();}

    /**
     * Deposit money into the account
     * @param accountNumber of the account
     * @param amount to be deposited
     * @throws IllegalArgumentException if the deposit is less than $0 or if the account could not be found
     */
    public void deposit(String accountNumber, double amount) throws IllegalArgumentException{
        if (amount <= 0) { // deposit amount less than $0
            throw new IllegalArgumentException("Deposit must be greater that $0");
        }
        if (!accountExist(accountNumber)) {
            throw new IllegalArgumentException("Account not found");
        }
        Account account = accountRepository.findByAccountNumber(accountNumber); // find the account to deposit money into
        account.deposit(amount);
        accountRepository.updateAccount(account);
    }

    /**
     * Withdraw money from the account
     * @param accountNumber of the account
     * @param amount to be withdrawn
     * @throws IllegalArgumentException if the amount is less than $0, the account does not have sufficient balance, or if the account cannot be found
     */
    public void withdraw(String accountNumber, double amount) throws IllegalArgumentException{
        Account account = accountRepository.findByAccountNumber(accountNumber); // find the account to withdraw from
        if (amount <= 0) { // amount to be withdrawn needs to be greater than 0
            throw new IllegalArgumentException("Withdrawal amount must be greater than $0");
        }
        if (account.getBalance() < amount) { // not enough money in the account
            throw new IllegalArgumentException("Insufficient funds");
        }
        if (accountExist(accountNumber)) {
            throw new IllegalArgumentException("Account could not be found");
        }
        account.withdraw(amount);
        accountRepository.updateAccount(account);
    }

    /**
     * Deletes an account
     * @param accountNumber of the account
     * @throws IllegalArgumentException if the account cannot be found
     */
    public void deleteAccount(String accountNumber) throws IllegalArgumentException{
        if (!accountExist(accountNumber)) {
            throw new IllegalArgumentException("Account not found");
        }
        accountRepository.deleteAccount(accountNumber);
    }

    /**
     * Updates an account
     * @param account to be updated
     * @throws IllegalArgumentException if the account could not be found
     */
    public void updateAccount(Account account) throws IllegalArgumentException{
        if (!accountExist(account.getAccountNumber())) {
            throw new IllegalArgumentException("Account not found");
        }
        accountRepository.updateAccount(account);
    }

    /**
     * Checks and to see if an account exist
     * @param accountNumber of the account
     * @return true if the account exist, false if it doesn't
     */
    public boolean accountExist(String accountNumber) {
        return accountRepository.accountExist(accountNumber);
    }

}
