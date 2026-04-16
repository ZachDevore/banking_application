module com.oop_group.banking_application {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop_group.banking_application to javafx.fxml;
    exports com.oop_group.banking_application;
}