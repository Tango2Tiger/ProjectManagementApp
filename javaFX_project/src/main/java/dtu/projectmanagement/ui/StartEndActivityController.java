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
import java.util.ArrayList;
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
    private Activity activity;
    private ArrayList<Integer> yearList = new ArrayList<>();
    private ArrayList<Integer> weekList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillWeekArray();
        fillYearArray();
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        projectChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String string1, String string2) {
                showActivities();
            }
        });

        activityChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String string1, String string2) {
                showDates();
            }
        });
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

        startYearDrop.getItems().addAll(yearList);
        startWeekDrop.getItems().addAll(weekList);
        endYearDrop.getItems().addAll(yearList);
        endWeekDrop.getItems().addAll(weekList);
    }

    public void setDate(ActionEvent actionEvent) throws NumberFormatException{
        if (!(startYearDrop.getValue() == null) && !(startWeekDrop.getValue() == null) && !(endYearDrop.getValue() == null) && !(endYearDrop.getValue() == null)){
            String projectName = projectChoiceBox.getValue();
            String activityName = activityChoiceBox.getValue();
            activity = App.getProjectManagementApp().getProjectWithName(projectName).getActivityWithName(activityName);

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
                showDates();
            } catch (OperationNotAllowedException e) {
                setDateScreenLabel.setText(e.getMessage());
            }
        } else{
            setDateScreenLabel.setText("Select all the fields.");
        }
    }

    public void fillYearArray(){
        for(int i=0; i<10; i++){
            this.yearList.add(i + 2023);
        }
    }

    public void fillWeekArray(){
        for(int i=0; i<52; i++){
            this.weekList.add(i+1);
        }
    }

}
