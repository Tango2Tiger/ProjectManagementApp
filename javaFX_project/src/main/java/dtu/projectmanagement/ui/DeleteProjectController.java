package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

/**
 @author s230607
 */
public class DeleteProjectController implements Initializable {
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    public Label deleteProjectLabel;
    @FXML
    private AnchorPane pane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }

    public void deleteProject() throws OperationNotAllowedException {
        if(isNull(projectChoiceBox.getValue())){
            deleteProjectLabel.setText("Please choose a project.");
            return;
        }
        App.getProjectManagementApp().deleteProject(projectChoiceBox.getValue());
        deleteProjectLabel.setText("The project \'" + projectChoiceBox.getValue() + "\' has been deleted.");
        projectChoiceBox.getItems().clear();
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());
    }
}
