package com.oop_group.banking_application;

import com.oop_group.banking_application.account.model.Account;
import com.oop_group.banking_application.account.model.CheckingAccount;
import com.oop_group.banking_application.account.model.MoneyMarketAccount;
import com.oop_group.banking_application.account.model.SavingsAccount;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    // These fx:ids must match Scene Builder EXACTLY
    @FXML private Label typeLabel;      // The header "Account Overview"
    @FXML private Label accNumLabel;    // Label next to Account Number
    @FXML private Label balanceLabel;   // Label next to Available Balance
    @FXML private Label statusLabel;    // Empty label in the bottom HBox
    @FXML private TextField amountInput; // TextField in the bottom HBox

    // The active account being viewed
    private Account currentAccount;

    /**
     * Runs automatically when the FXML is loaded.
     * Sets the default view to a Savings Account.
     */
    @FXML
    public void initialize() {
        // Initial mock data for testing
        currentAccount = new SavingsAccount(1000.00, "CUST-123");
        updateUI("Welcome to Bank of The Future");
    }

    // --- Sidebar Navigation Methods ---

    @FXML
    protected void handleCheckingBtn() {
        currentAccount = new CheckingAccount(500.00, "CUST-123");
        updateUI("Switched to Checking");
    }

    @FXML
    protected void handleSavingsBtn() {
        currentAccount = new SavingsAccount(1000.00, "CUST-123");
        updateUI("Switched to Savings");
    }

    @FXML
    protected void handleMoneyMarketBtn() {
        currentAccount = new MoneyMarketAccount(5000.00, "CUST-123");
        updateUI("Switched to Money Market");
    }

    // --- Transaction Methods ---

    @FXML
    protected void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountInput.getText());
            currentAccount.deposit(amount);
            updateUI("Deposit successful!");
            statusLabel.setStyle("-fx-text-fill: green;");
        } catch (NumberFormatException e) {
            showError("Please enter a valid numeric amount.");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    protected void handleWithdraw() {
        try {
            double amount = Double.parseDouble(amountInput.getText());
            currentAccount.withdraw(amount);
            updateUI("Withdrawal successful!");
            statusLabel.setStyle("-fx-text-fill: green;");
        } catch (NumberFormatException e) {
            showError("Please enter a valid numeric amount.");
        } catch (IllegalArgumentException e) {
            // This catches your "Insufficient Funds" or "Negative Amount" errors
            showError(e.getMessage());
        }
    }

    // --- UI Helper Methods ---

    private void updateUI(String message) {
        if (currentAccount != null) {
            typeLabel.setText(currentAccount.getAccountType());
            accNumLabel.setText(currentAccount.getAccountNumber());
            balanceLabel.setText(String.format("$%.2f", currentAccount.getBalance()));
            statusLabel.setText(message);
            amountInput.clear();
        }
    }

    private void showError(String message) {
        statusLabel.setText(message);
        statusLabel.setStyle("-fx-text-fill: red;");
    }
}