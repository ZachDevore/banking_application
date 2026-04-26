/**
 * The HelloController class controls the main dashboard (hello-viewer.fxml),
 * where the primary banking business logic resides.
 * * Key Responsibilities:
 * - Binds UI elements (Labels, ListViews, Buttons) from the BorderPane layout
 * to the backend logic.
 * - Manages account operations including deposits, withdrawals,
 * and real-time balance updates.
 * - Implements account-switching logic to toggle between different banking
 * products (Checking, Savings, Money Market).
 * - Records and displays a chronological history of user actions in the
 * transaction list, providing transparency of account activity.
 */

package com.oop_group.banking_application;

import com.oop_group.banking_application.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloController {

    @FXML private Label headerLabel, accNumLabel, balanceLabel, typeLabel, statusLabel;
    @FXML private TextField amountInput;

    // This links to the ListView in your FXML center area
    @FXML private ListView<String> transactionListView;

    private Customer currentCustomer;
    private double checkingBal = 500.00;
    private double savingsBal = 1200.50;
    private double moneyMarketBal = 5000.00;
    private String activeAccount = "Checking";

    /** Sets up initial dashboard view */
    public void initUserData(Customer customer) {
        this.currentCustomer = customer;
        if (customer != null) {
            if (accNumLabel != null) accNumLabel.setText(customer.getCustomerId());
            addTransactionRecord("Account opened with $500.00 initial balance.");
            updateUI();
        }
    }

    /** Updates labels and refreshes the balance display */
    private void updateUI() {
        double currentAmt = switch (activeAccount) {
            case "Savings" -> savingsBal;
            case "Money Market" -> moneyMarketBal;
            default -> checkingBal;
        };

        if (balanceLabel != null) balanceLabel.setText(String.format("$%.2f", currentAmt));
        if (typeLabel != null) typeLabel.setText(activeAccount + " Overview");
    }

    /** * Adds a new entry to the transaction history list with a timestamp.
     * College Level: We use a simple String list to populate the UI component.
     */
    private void addTransactionRecord(String message) {
        if (transactionListView != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String timestamp = dtf.format(LocalDateTime.now());
            transactionListView.getItems().add(0, "[" + timestamp + "] " + message);
        }
    }

    @FXML
    private void handleDeposit() {
        try {
            double amt = Double.parseDouble(amountInput.getText());
            if (amt <= 0) throw new Exception();

            if (activeAccount.equals("Checking")) checkingBal += amt;
            else if (activeAccount.equals("Savings")) savingsBal += amt;
            else moneyMarketBal += amt;

            statusLabel.setText("Deposited $" + String.format("%.2f", amt));
            addTransactionRecord("DEPOSIT: +$" + String.format("%.2f", amt) + " to " + activeAccount);
            updateUI();
            amountInput.clear();
        } catch (Exception e) { statusLabel.setText("Error: Enter positive number."); }
    }

    @FXML
    private void handleWithdraw() {
        try {
            double amt = Double.parseDouble(amountInput.getText());
            double current = (activeAccount.equals("Checking")) ? checkingBal :
                    (activeAccount.equals("Savings")) ? savingsBal : moneyMarketBal;

            if (amt > 0 && amt <= current) {
                if (activeAccount.equals("Checking")) checkingBal -= amt;
                else if (activeAccount.equals("Savings")) savingsBal -= amt;
                else moneyMarketBal -= amt;

                statusLabel.setText("Withdrew $" + String.format("%.2f", amt));
                addTransactionRecord("WITHDRAWAL: -$" + String.format("%.2f", amt) + " from " + activeAccount);
                updateUI();
                amountInput.clear();
            } else { statusLabel.setText("Insufficient funds."); }
        } catch (Exception e) { statusLabel.setText("Error: Enter positive number."); }
    }

    // Account Switching Logic - Now logs the switch in history
    @FXML private void handleCheckingBtn() {
        activeAccount = "Checking";
        //addTransactionRecord("Switched view to Checking.");test line for debugging
        updateUI();
    }
    @FXML private void handleSavingsBtn() {
        activeAccount = "Savings";
        //addTransactionRecord("Switched view to Savings.");
        updateUI();
    }
    @FXML private void handleMoneyMarketBtn() {
        activeAccount = "Money Market";
        //addTransactionRecord("Switched view to Money Market.");
        updateUI();
    }

    @FXML
    private void handleLogout() {
        try {
            Stage stage = (Stage) headerLabel.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root, 400, 550));
            stage.centerOnScreen();
        } catch (IOException e) { e.printStackTrace(); }
    }
}