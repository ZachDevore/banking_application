package com.oop_group.banking_application.account.repository;


import com.oop_group.banking_application.account.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {

    /** Map of all of the different accounts */
    private Map<String, Account> accounts;

    /**Constructor */
    public AccountRepository() {
        this.accounts = new HashMap<>();
    }

    /**
     * Save a new account
     * @param account the new account to be saved
     */
    public void saveAccount(Account account) {accounts.put(account.getAccountNumber(), account);}

    /**
     * Check to see if an account exist
     * @param accountNumber to be checked
     * @return true if the account exist false if not
     */
    public boolean accountExist(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    /**
     * Find an account
     * @param accountNumber to be found
     * @return the account
     * @throws IllegalArgumentException if the account is not found
     */
    public Account findByAccountNumber(String accountNumber) throws IllegalArgumentException {
        if (!accountExist(accountNumber)) {
            throw new IllegalArgumentException("The account is not found");
        }
        return accounts.get(accountNumber);
    }

    /**
     * Find all of the accounts
     * @return a list of accounts
     */
    public List<Account> findAllAccounts() {return new ArrayList<>(accounts.values());}

    /**
     * update an existing account
     * @param account the account to be updated
     * @throws IllegalArgumentException if the account cannot be found
     */
    public void updateAccount(Account account) throws IllegalArgumentException {
        if (!accountExist(account.getAccountNumber())) {
            throw new IllegalArgumentException("Account not found");
        }
        accounts.put(account.getAccountNumber(), account);
    }

    /**
     * Delete an account
     * @param accountNumber of the account to be deleted
     * @throws IllegalArgumentException if the account cannot be found
     */
    public void deleteAccount(String accountNumber) throws IllegalArgumentException {
        if (!accountExist(accountNumber)) {
            throw new IllegalArgumentException("Account not found");
        }
        accounts.remove(accountNumber);
    }






}
