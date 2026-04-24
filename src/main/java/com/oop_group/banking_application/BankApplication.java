package com.oop_group.banking_application;

import com.oop_group.banking_application.account.service.AccountService;
import com.oop_group.banking_application.customer.service.CustomerService;
import com.oop_group.banking_application.transaction.service.TransactionService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BankApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the Login page first instead of the dashboard
        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("login-view.fxml"));

        // Set a professional starting size (Width, Height)
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);

        // Attach your professional stylesheet
        // Use Objects.requireNonNull to catch "File Not Found" errors early
        String css = Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);

        stage.setTitle("Global Bank - Secure Access");

        //Prevent the window from being resized too small
        stage.setMinWidth(400);
        stage.setMinHeight(500);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        AccountService accounts = new AccountService();
        CustomerService customers = new CustomerService();
        TransactionService transactions = new TransactionService();
    }

    public static void main(String[] args) {
        launch();
    }
}
