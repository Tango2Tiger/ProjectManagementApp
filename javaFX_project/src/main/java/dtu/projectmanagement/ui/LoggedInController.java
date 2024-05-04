package dtu.projectmanagement.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoggedInController {
   public Label textLabel;

    public void viewProjects(ActionEvent actionEvent) throws IOException{
        App.setRoot("viewProjects");
    }

    public void logOut(ActionEvent actionEvent) throws IOException{
        App.getProjectManagementApp().logout();
        App.setRoot("login");
    }

    public void viewActivities(ActionEvent actionEvent) throws IOException{
        App.setRoot("viewActivities");
    }

    public void viewEmployees(ActionEvent actionEvent) throws IOException{
        App.setRoot("viewEmployees");
    }
}
