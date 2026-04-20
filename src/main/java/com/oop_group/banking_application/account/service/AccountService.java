package com.oop_group.banking_application.account.service;

import com.oop_group.banking_application.account.model.Account;
import com.oop_group.banking_application.account.repository.AccountRepository;

import java.util.List;

public class AccountService {

    public AccountRepository accountRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
    }

    public void createAccount(Account account) throws IllegalArgumentException {
        if (accountRepository.accountExist(account.getAccountNumber())) {
            throw new IllegalArgumentException("Account already exists");
        }
        accountRepository.saveAccount(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public List<Account> getAllAccounts() {return accountRepository.findAllAccounts();}

    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber); // find the account to deposit money into
        account.deposit(amount);
        accountRepository.updateAccount(account);
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber); // find the account to withdraw from
        account.withdraw(amount);
        accountRepository.updateAccount(account);
    }

    public void deleteAccount(String accountNumber) {
        accountRepository.deleteAccount(accountNumber);
    }

    public boolean accountExist(String accountNumber) {
        return accountRepository.accountExist(accountNumber);
    }

}
