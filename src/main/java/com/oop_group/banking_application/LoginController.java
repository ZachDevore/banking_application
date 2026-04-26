/**
 * The LoginController class manages the user interface for the login and
 * registration screens. It serves as the gateway to the main application.
 * * Key Responsibilities:
 * - Handles event-driven actions from 'login-view.fxml' such as button clicks.
 * - Communicates with the CustomerRepository to verify user credentials
 * during the login process.
 * - Manages the transition between the Login view and the Dashboard view,
 * ensuring the specific Customer object is passed to the next scene
 * to maintain user session context.
 */

package com.oop_group.banking_application;

import com.oop_group.banking_application.customer.model.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField usernameField, firstNameField, lastNameField, signUpUsernameField;
    @FXML private PasswordField passwordField, signUpPasswordField;
    @FXML private Label errorLabel;
    @FXML private VBox loginBox, signUpBox;

    @FXML
    private void handleLogin() {
        String user = usernameField.getText().trim();
        String pass = passwordField.getText();

        Customer found = null;
        for (Customer c : BankApplication.getRepo().getAllCustomers()) {
            if (c.getUsername().equalsIgnoreCase(user) && c.getPassword().equals(pass)) {
                found = c;
                break;
            }
        }

        if (found != null) {
            try {
                switchToDashboard(found);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("Invalid credentials.");
        }
    }

    @FXML
    private void handleRegister() {
        Customer nc = new Customer(lastNameField.getText(), firstNameField.getText(),
                signUpUsernameField.getText(), signUpPasswordField.getText());
        BankApplication.getRepo().saveCustomer(nc);
        handleShowLogin();
        errorLabel.setText("Registration Successful!");
    }

    private void switchToDashboard(Customer customer) throws Exception {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-viewer.fxml"));
        Parent root = loader.load();

        HelloController controller = loader.getController();
        if (controller != null) {
            controller.initUserData(customer);
        }

        stage.setScene(new Scene(root, 800, 600));
        stage.centerOnScreen();
    }

    @FXML private void handleShowSignUp() { loginBox.setVisible(false); loginBox.setManaged(false); signUpBox.setVisible(true); signUpBox.setManaged(true); }
    @FXML private void handleShowLogin() { signUpBox.setVisible(false); signUpBox.setManaged(false); loginBox.setVisible(true); loginBox.setManaged(true); }
}