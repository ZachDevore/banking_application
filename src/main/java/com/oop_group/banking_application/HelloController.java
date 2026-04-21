package com.oop_group.banking_application;

import com.oop_group.banking_application.account.model.Account;
import com.oop_group.banking_application.account.model.CheckingAccount;
import com.oop_group.banking_application.account.model.MoneyMarketAccount;
import com.oop_group.banking_application.account.model.SavingsAccount;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {

    @FXML private Label headerLabel;
    @FXML private Label typeLabel;
    @FXML private Label accNumLabel;
    @FXML private Label balanceLabel;
    @FXML private Label statusLabel;
    @FXML private TextField amountInput;
    @FXML private ListView<String> transactionListView;

    private Account currentAccount;

    @FXML
    public void initialize() {
        // Start with a default account
        currentAccount = new SavingsAccount(1000.00, "CUST-123");
        updateUI("Welcome to Bank of The Future");
    }

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

    @FXML
    protected void handleDeposit() {
        try {
            double amount = Double.parseDouble(amountInput.getText());
            currentAccount.deposit(amount);
            updateUI("Deposit successful!");
            statusLabel.setStyle("-fx-text-fill: #059669;"); // Professional Green
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
            statusLabel.setStyle("-fx-text-fill: #059669;");
        } catch (NumberFormatException e) {
            showError("Please enter a valid numeric amount.");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void handleLogout() throws IOException {
        // 1. Get the current stage using the headerLabel we just defined
        Stage stage = (Stage) headerLabel.getScene().getWindow();

        //Load the login FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);

        //Apply the CSS (Check if your file is 'style.css' or 'styles.css')
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //Set the new scene and center
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    private void updateUI(String message) {
        if (currentAccount != null) {
            typeLabel.setText(currentAccount.getAccountType());
            accNumLabel.setText(currentAccount.getAccountNumber());
            balanceLabel.setText(String.format("$%.2f", currentAccount.getBalance()));
            statusLabel.setText(message);
            amountInput.clear();

            if (transactionListView != null) {
                transactionListView.getItems().clear();
                transactionListView.getItems().addAll(currentAccount.getTransactionHistory());
            }
        }
    }

    private void showError(String message) {
        statusLabel.setText(message);
        statusLabel.setStyle("-fx-text-fill: #DC2626;"); // Professional Red
    }
}