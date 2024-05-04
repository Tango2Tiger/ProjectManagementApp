package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class StartEndActivityController implements Initializable {
    @FXML
    public Label setDateScreenLabel;
    @FXML
    public ChoiceBox<String> projectChoiceBox;
    @FXML
    public ChoiceBox<String> activityChoiceBox;
    @FXML
    public ChoiceBox<Integer> startYearDrop;
    @FXML
    public ChoiceBox<Integer> startWeekDrop;
    @FXML
    public ChoiceBox<Integer> endYearDrop;
    @FXML
    public ChoiceBox<Integer> endWeekDrop;
    @FXML
    public TextField setStartYear;
    @FXML
    public TextField setStartWeek;
    @FXML
    public TextField setEndYear;
    @FXML
    public TextField setEndWeek;

    @FXML
    private Button chooseActivityButton;
    @FXML
    private Button setStartDateButton;
    @FXML
    private Project project;
    private Activity activity;
    private ProjectManagementApp projectManagementApp;
    private Integer[] yearArray = new Integer[100];
    private Integer[] weekArray = new Integer[52];
    ObservableList<Integer> yearList;
    ObservableList<Integer> weekList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillWeekArray();
        fillYearArray();
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        projectChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showActivities();
            }
        });

        activityChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showDates();
            }
        });


        yearList = FXCollections.observableArrayList(Arrays.asList(yearArray));
        weekList = FXCollections.observableArrayList(Arrays.asList(weekArray));

    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewActivities");
    }

    public void showActivities() {
        activityChoiceBox.getItems().clear();
        activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()).getActivityNameList());
    }

    public void showDates(){
        startYearDrop.getItems().clear();
        startWeekDrop.getItems().clear();
        endYearDrop.getItems().clear();
        endWeekDrop.getItems().clear();

        startYearDrop.setItems(yearList);
        startWeekDrop.setItems(weekList);
        endYearDrop.setItems(yearList);
        endWeekDrop.setItems(weekList);
    }

    public void setDate(ActionEvent actionEvent) throws NumberFormatException{
        if (!(startYearDrop.getValue() == null) && !(startWeekDrop.getValue() == null) && !(endYearDrop.getValue() == null) && !(endYearDrop.getValue() == null)){
            String projectName = projectChoiceBox.getValue();
            String activityName = activityChoiceBox.getValue();
            Activity activity = App.getProjectManagementApp().getProjectWithName(projectName).getActivityWithName(activityName);

            int startYear = startYearDrop.getValue();
            int startWeek = startWeekDrop.getValue();
            int endYear = endYearDrop.getValue();
            int endWeek = endWeekDrop.getValue();

            try {
                activity.setStartDate(new ActivityDate(startYear, startWeek));
                activity.setEndDate(new ActivityDate(endYear, endWeek));
                setDateScreenLabel.setText("Activity \'"+ activity.getName() + "\' has start week "
                        + activity.getStartDate().getYear() + "-" +activity.getStartDate().getWeek()
                        +" and end week " + activity.getEndDate().getYear() + "-" + activity.getEndDate().getWeek());
                App.getProjectManagementApp().setStartEndActivity(startYear, startWeek, endYear, endWeek, projectName, activityName);
            } catch (OperationNotAllowedException e) {
                setDateScreenLabel.setText(e.getMessage());
            }
        } else{
            setDateScreenLabel.setText("Select all the fields.");
        }
    }

    public void fillYearArray(){
        for(int i=0; i<50; i++){
            this.yearArray[i] = i + 2023;
        }
    }

    public void fillWeekArray(){
        for(int i=0; i<52; i++){
            this.weekArray[i] = i+1;
        }
    }

}
