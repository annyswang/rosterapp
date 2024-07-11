package com.example.rosterapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private ChoiceBox<String> squadSelection;

    private static final String[] squads = {"alpha", "bravo", "charlie", "delta", "echo"};

    @FXML
    private DatePicker datePicker;

    private static LocalDate pickedDate;

    private static String pickedSquad;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        datePicker.setTooltip(new Tooltip("If you typed a date with the keyboard, remember to press Enter!"));
        squadSelection.getItems().addAll(squads);
        squadSelection.setOnAction(this::getSelectedSquad);
        datePicker.setOnAction(this::getPickedDate);
//        pickedDate = this::getPickedDate;
    }

    protected String getSelectedSquad(ActionEvent event) {
        String selectedSquad = squadSelection.getValue();
        pickedSquad = selectedSquad;
        return selectedSquad;
    }

    protected LocalDate getPickedDate(ActionEvent event) {
        pickedDate = datePicker.getValue();
        return datePicker.getValue();
    }

    @FXML
    protected void onHelloButtonClick() {
//        LocalDate inputDate = LocalDate.of(2025, 3, 13);
//        LocalDate inputDate = ;
        // TODO: handle invalid cases with help text: invalid date, unselected squad (perhaps make alpha as preselected option?)
        welcomeText.setText("On " + pickedDate + " you have: " + Roster.whatRoster(pickedDate, pickedSquad));
    }

}