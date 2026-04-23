package com.oop_group.banking_application.transaction.service;

import com.oop_group.banking_application.transaction.model.Transaction;
import com.oop_group.banking_application.transaction.repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    /** "Database" for our transactions*/
    private TransactionRepository transactionRepository;

    /**
     * Constructor
     */
    public TransactionService() {
        transactionRepository = new TransactionRepository();
    }

    /**
     * Create a new transaction
     * @param transaction to be created
     * @throws IllegalArgumentException if the transaction already exist
     */
    public void createTransaction(Transaction transaction) throws IllegalArgumentException {
        if (transactionRepository.transactionExist(transaction.getTransactionId())) {
            throw new IllegalArgumentException("Transaction already exist");
        }
        transactionRepository.saveTransaction(transaction);
    }

    /**
     * Retrieve a transaction by it's id
     * @param transactionId to be retrieved
     * @throws IllegalArgumentException if the transaction could not be found
     */
    public void getTransactionById(String transactionId) throws IllegalArgumentException {
        if (!transactionRepository.transactionExist(transactionId)) {
            throw new IllegalArgumentException("Transaction could not be found");
        }
        transactionRepository.findTransactionById(transactionId);
    }

    /**
     * Retrieve all of the transactions
     * @return a List of all the transactions
     * @throws IllegalStateException if there are no transactions to be retrieved
     */
    public List<Transaction> getAllTransactions() throws IllegalStateException {
        if (transactionRepository.getAllTransactions().isEmpty()) {
            throw new IllegalStateException("There are no transactions");
        }
        return transactionRepository.getAllTransactions();
    }

    /**
     * Delete a transaction
     * @param transactionId of the transaction to be deleted
     * @throws IllegalArgumentException if the transaction could not be found
     */
    public void deleteTransaction(String transactionId) throws IllegalArgumentException {
        if (!transactionRepository.transactionExist(transactionId)) {
            throw new IllegalArgumentException("Transaction could not be found");
        }
        transactionRepository.deleteTransaction(transactionId);
    }

    /**
     * Update an existing transaction
     * @param transaction to be updated
     * @throws IllegalArgumentException if the transaction cannot be found
     */
    public void updateTransaction(Transaction transaction) throws IllegalArgumentException {
        if (!transactionRepository.transactionExist(transaction.getTransactionId())) {
            throw new IllegalArgumentException("Transaction could not be found");
        }
        transactionRepository.deleteTransaction(transaction.getTransactionId());
    }

}
