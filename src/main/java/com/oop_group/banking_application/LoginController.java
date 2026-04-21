package com.oop_group.banking_application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void handleLogin() throws IOException {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        // Simple hardcoded check for now
        if (user.equals("admin") && pass.equals("password123")) {
            switchToDashboard();
        } else {
            errorLabel.setText("Invalid username or password.");
        }
    }

    private void switchToDashboard() throws IOException {
        // This is the "Magic" that swaps the screens
        Stage stage = (Stage) usernameField.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("hello-viewer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
    }
}
