module com.example.rosterapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rosterapp to javafx.fxml;
    exports com.example.rosterapp;
}