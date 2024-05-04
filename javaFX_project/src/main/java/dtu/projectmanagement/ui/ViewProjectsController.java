package dtu.projectmanagement.ui;

import javafx.event.ActionEvent;

import java.io.IOException;

public class ViewProjectsController {

    public void createProject(ActionEvent actionEvent) throws IOException {
        App.setRoot("createProject");
    }

    public void assignProjectLeader(ActionEvent actionEvent) throws IOException {
        App.setRoot("assignProjectLeader");
    }

    public void assignEmployee(ActionEvent actionEvent) throws IOException{
        App.setRoot("AssignEmployeeToProject");
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }
    public void activityScreen (ActionEvent actionEvent) throws IOException {
        App.setRoot("setBudgetedTime");
    }

    public void switchToDeleteProject(ActionEvent actionEvent)throws IOException{
        App.setRoot("deleteProject");
    }

    public void switchToStatusReport() throws IOException{
        App.setRoot("getStatusReport");
    }
}
