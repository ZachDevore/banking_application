package com.oop_group.banking_application;

import com.oop_group.banking_application.customer.repository.CustomerRepository;
import com.oop_group.banking_application.customer.model.Customer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankApplication extends Application {

    // Static repository to keep user data alive during the session
    private static final CustomerRepository repository = new CustomerRepository();

    public static CustomerRepository getRepo() { return repository; }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        // Standard login window size
        Scene scene = new Scene(loader.load(), 400, 550);

        if (getClass().getResource("style.css") != null) {
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        }

        stage.setTitle("Bank of The Future - Secure Login");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() {
        // Pre-loaded user for testing (User: admin | Pass: password123)
        Customer admin = new Customer("Wesley", "Thomas", "admin", "password123");
        repository.saveCustomer(admin);
    }

    public static void main(String[] args) { launch(); }
}