package com.oop_group.banking_application.transaction.repository;

import com.oop_group.banking_application.transaction.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {

    /** Map containing all of the transactions*/
    private Map<String, Transaction> transactions;

    /**
     * Constructor
     */
    public TransactionRepository() {
        this.transactions = new HashMap<>();
    }

    /**
     * Check to see if a transaction exist
     * @param transactionId to be checked
     * @return true if it exist, false if not
     */
    public boolean transactionExist(String transactionId) {
        return transactions.containsKey(transactionId);
    }

    /**
     * Save a new transaction
     * @param transaction to be saved
     */
    public void saveTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionId(), transaction);
    }

    /**
     * Find a transaction by the id
     * @param transactionId of the transaction to be found
     * @return the transaction
     */
    public Transaction findTransactionById(String transactionId) {
        return transactions.get(transactionId);
    }

    /**
     * Retrieve all of the transactions
     * @return A list of type transaction with all of the transactions
     */
    public List<Transaction> getAllTransactions() {
        return new ArrayList<Transaction>(transactions.values());
    }

    /**
     * Update an existing transaction
     * @param transaction to be updated
     */
    public void updateTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionId(), transaction);
    }

    /**
     * Delete a transaction
     * @param transactionId of the transaction to be deleted
     */
    public void deleteTransaction(String transactionId) {
        transactions.remove(transactionId);
    }
}
