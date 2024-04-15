package dtu.example.ui;

import dtu.projectmanagement.app.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateProjectController {

    public TextField projectname;
    public Label namelabel;
    public Label projectAlreadyExistsFail;

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }

    public void createProject(ActionEvent actionEvent) throws IOException {
        try{
            App.getProjectManagementApp().createProject(projectname.getText());
        }
        catch(OperationNotAllowedException e){
            projectAlreadyExistsFail.setText(e.getMessage());
        }


        App.setRoot("loggedIn");
    }

}
