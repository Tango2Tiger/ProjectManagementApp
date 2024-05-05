package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AbsenceRegistrationController implements Initializable {
    @FXML
    public ChoiceBox startYearChoiceBox;
    @FXML
    public ChoiceBox startMonthChoiceBox;
    @FXML
    public ChoiceBox startDayChoiceBox;
    @FXML
    public ChoiceBox endYearChoiceBox;
    @FXML
    public ChoiceBox endMonthChoiceBox;
    @FXML
    public ChoiceBox endDayChoiceBox;
    @FXML
    public Label startYearLabel;
    @FXML
    public Label startMonthLabel;
    @FXML
    public Label startDayLabel;
    @FXML
    public Label endYearLabel;
    @FXML
    public Label endMonthLabel;
    @FXML
    public Label endDayLabel;
    @FXML
    public Label endDateBeforeStart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        endDateBeforeStart.setVisible(false);
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewEmployees");
    }

    private void setStartYearChoiceBox() {
        ArrayList<String> yearList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            yearList.add(Integer.toString(i + 2023));
        }
        startYearChoiceBox.getItems().addAll(yearList);

    }

    private void setStartMonthChoiceBox() {
        ArrayList<String> monthList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            monthList.add(Integer.toString(i));
        }
        startMonthChoiceBox.getItems().addAll(monthList);
    }

    private void setStartDayChoiceBox() {
        ArrayList<String> dayList = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            dayList.add(Integer.toString(i));
        }
        startDayChoiceBox.getItems().addAll(dayList);
    }

    private void setEndYearChoiceBox() {
        ArrayList<String> yearList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            yearList.add(Integer.toString(i + 2023));
        }
        endYearChoiceBox.getItems().addAll(yearList);

    }

    private void setEndMonthChoiceBox() {
        ArrayList<String> monthList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            monthList.add(Integer.toString(i));
        }
        endMonthChoiceBox.getItems().addAll(monthList);
    }

    private void setEndDayChoiceBox() {
        ArrayList<String> dayList = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            dayList.add(Integer.toString(i));
        }
        endDayChoiceBox.getItems().addAll(dayList);
    }

    public void registerAbsence(ActionEvent actionEvent) throws IOException {
        try {
            int startYear = Integer.parseInt((String) startYearChoiceBox.getValue());
            int startDay = Integer.parseInt((String) startDayChoiceBox.getValue());
            int startMonth = Integer.parseInt((String) startMonthChoiceBox.getValue()) - 1; // minus one since calendar object works with months 0-11
            int endYear = Integer.parseInt((String) endYearChoiceBox.getValue());
            int endDay = Integer.parseInt((String) endDayChoiceBox.getValue());
            int endMonth = Integer.parseInt((String) endMonthChoiceBox.getValue()) - 1; // minus one since calendar object works with months 0-11
            App.getProjectManagementApp().registerAbsence(startYear, startMonth, startDay, endYear, endMonth, endDay);
        } catch (OperationNotAllowedException e) {
            endDateBeforeStart.setVisible(true);
            endDateBeforeStart.setText(e.getMessage());
        }
    }
}
