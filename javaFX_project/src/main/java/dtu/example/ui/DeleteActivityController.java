package dtu.example.ui;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class DeleteActivityController implements Initializable {
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private ChoiceBox<String> activityChoiceBox;
    @FXML
    public Label deleteActivityLabel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        projectChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showActivities();
            }
        });
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewActivities");
    }

    public void showActivities(){
        activityChoiceBox.getItems().clear();
        activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()).getActivityNameList());
    }

    public void deleteActivity() throws IOException, OperationNotAllowedException {
        if(isNull(projectChoiceBox.getValue()) || isNull(activityChoiceBox.getValue())){
            deleteActivityLabel.setText("Please choose a project and an activity.");
            return;
        }
        App.getProjectManagementApp().deleteActivity(projectChoiceBox.getValue(), activityChoiceBox.getValue());
        deleteActivityLabel.setText("The activity \'" + activityChoiceBox.getValue() + "\' has been deleted from the project \'" + projectChoiceBox.getValue() + "\'.");
        activityChoiceBox.getItems().clear();
        activityChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()).getActivityNameList());
    }
}
