package dtu.example.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.util.Objects.isNull;

public class CreateActivityController implements Initializable {
    @FXML
    public Label createActivityLabel;
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private Button createActivityButton;

    @FXML
    private TextField activityName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
        createActivityButton.setVisible(false);
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }
    public void chooseProject(ActionEvent actionEvent) throws IOException {
        if(!isNull(projectChoiceBox.getValue())){
            createActivityButton.setVisible(true);
        } else{
            createActivityLabel.setText("Please choose a project.");
        }
    }

    public void createActivity(ActionEvent actionEvent) throws IOException {
        if(activityName.getText().isEmpty()){
            createActivityLabel.setText("Please give the activity a name.");
            return;
        }
        try{
            App.getProjectManagementApp().createActivity(App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()), activityName.getText());
            createActivityLabel.setText("The activity \'" + activityName.getText() + "\' has been created under the project \'" + projectChoiceBox.getValue() + "\'.");
        } catch (OperationNotAllowedException e){
            createActivityLabel.setText(e.getMessage());
        }

    }

}
