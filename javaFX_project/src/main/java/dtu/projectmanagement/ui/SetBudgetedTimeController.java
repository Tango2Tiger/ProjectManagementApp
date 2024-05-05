package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.Activity;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class SetBudgetedTimeController implements Initializable {
    @FXML
    public ChoiceBox<String> activityChoiceBox;
    @FXML
    public Label activityScreenLabel;
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private Button chooseActivityButton;
    @FXML
    private Button setBudgetedTimeButton;
    @FXML
    private TextField setBudgetedTimeText;
    private Project project;
    private Activity activity;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        activityChoiceBox.setVisible(false);
        chooseActivityButton.setVisible(false);
        setBudgetedTimeText.setVisible(false);
        setBudgetedTimeButton.setVisible(false);
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        if (!isNull(projectChoiceBox.getValue())) {
            activityChoiceBox.setVisible(true);
            chooseActivityButton.setVisible(true);
            project = App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue());
            activityChoiceBox.getItems().clear();
            activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getActivityListFromProject(project));
            activityScreenLabel.setText("Please choose an activity");
        }

    }

    public void chooseActivity(ActionEvent actionEvent) {
        if(!isNull(activityChoiceBox.getValue())) {
            setBudgetedTimeText.setVisible(true);
            setBudgetedTimeButton.setVisible(true);
            activity = project.getActivityWithName(activityChoiceBox.getValue());
            activityScreenLabel.setText("Activity "+ activity.getName() + " has budgeted time " + activity.getBudgetedTime() + " hours. Enter budgeted time");
        }
    }
    public void setBudgetedTime() {
        try {
            int num = Integer.parseInt(setBudgetedTimeText.getText());
            try {
                activity.setBudgetedTime(num);
                activityScreenLabel.setText("Activity "+ activity.getName() + " has budgeted time " + activity.getBudgetedTime() + " hours");
            } catch (OperationNotAllowedException e) {
                activityScreenLabel.setText(e.getMessage());
            }
        } catch (NumberFormatException e) {
            activityScreenLabel.setText("Please enter an integer");
        }
    }

    public void returnToViewActivities(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewActivities");
    }
}
