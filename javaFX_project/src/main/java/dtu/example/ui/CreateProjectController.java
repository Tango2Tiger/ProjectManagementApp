package dtu.example.ui;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class CreateProjectController {
    public TextField projectname;
    public Label namelabel;
    public Label projectAlreadyExistsFail;

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }

    public void createProject(ActionEvent actionEvent) throws IOException {
        try {
            App.getProjectManagementApp().createProject(projectname.getText());
            projectAlreadyExistsFail.setText("Project " + projectname.getText() + " has been added to the system!");
        } catch (OperationNotAllowedException e) {
            projectAlreadyExistsFail.setText(e.getMessage());
        }
    }

    @FXML
    private void keyListenerCreateProject(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                App.getProjectManagementApp().createProject(projectname.getText());
                projectAlreadyExistsFail.setText("Project " + projectname.getText() + " has been added to the system!");
            } catch (OperationNotAllowedException e) {
                projectAlreadyExistsFail.setText(e.getMessage());
            }
        }
    }

}