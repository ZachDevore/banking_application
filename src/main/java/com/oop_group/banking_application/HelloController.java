package com.oop_group.banking_application;

import com.oop_group.banking_application.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML private Label headerLabel, accNumLabel, balanceLabel, typeLabel, statusLabel;
    @FXML private TextField amountInput;

    // State Variables: Tracking separate balances for different accounts
    private double checkingBal = 500.00;
    private double savingsBal = 1200.50;
    private double moneyMarketBal = 5000.00;
    private String activeAccount = "Checking";

    /** Sets up initial dashboard view */
    public void initUserData(Customer customer) {
        if (customer != null) {
            if (accNumLabel != null) accNumLabel.setText(customer.getCustomerId());
            updateUI();
        }
    }

    /** Updates labels based on the current active account and its balance */
    private void updateUI() {
        double currentAmt = switch (activeAccount) {
            case "Savings" -> savingsBal;
            case "Money Market" -> moneyMarketBal;
            default -> checkingBal;
        };

        if (balanceLabel != null) balanceLabel.setText(String.format("$%.2f", currentAmt));
        if (typeLabel != null) typeLabel.setText(activeAccount + " Overview");
    }

    @FXML
    private void handleDeposit() {
        try {
            double amt = Double.parseDouble(amountInput.getText());
            if (amt <= 0) throw new Exception();

            // Logic to add to the specific active balance
            if (activeAccount.equals("Checking")) checkingBal += amt;
            else if (activeAccount.equals("Savings")) savingsBal += amt;
            else moneyMarketBal += amt;

            statusLabel.setText("Deposited $" + String.format("%.2f", amt));
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
                updateUI();
                amountInput.clear();
            } else { statusLabel.setText("Insufficient funds or invalid amount."); }
        } catch (Exception e) { statusLabel.setText("Error: Enter positive number."); }
    }

    // Account Switching Logic
    @FXML private void handleCheckingBtn() { activeAccount = "Checking"; updateUI(); }
    @FXML private void handleSavingsBtn() { activeAccount = "Savings"; updateUI(); }
    @FXML private void handleMoneyMarketBtn() { activeAccount = "Money Market"; updateUI(); }

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