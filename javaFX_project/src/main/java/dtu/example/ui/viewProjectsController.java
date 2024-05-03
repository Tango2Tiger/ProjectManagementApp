package dtu.example.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class viewProjectsController {
    public void setDateScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("startEndActivity");
    }

    public void createProject(ActionEvent actionEvent) throws IOException {
        App.setRoot("createProject");
    }

    public void assignProjectLeader(ActionEvent actionEvent) throws IOException {
        App.setRoot("assignProjectLeader");
    }

    public void assignEmployee(ActionEvent actionEvent) throws IOException{
        App.setRoot("AssignEmployeeToProject");
    }

    public void createActivity(ActionEvent actionEvent) throws IOException{
        App.setRoot("createActivityScene");
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }
    public void activityScreen (ActionEvent actionEvent) throws IOException {
        App.setRoot("activityScreen");
    }

    public void switchToDeleteProject(ActionEvent actionEvent)throws IOException{
        App.setRoot("deleteProject");
    }

    public void switchToDeleteActivity(ActionEvent actionEvent) throws IOException{
        App.setRoot("deleteActivity");
    }
}
