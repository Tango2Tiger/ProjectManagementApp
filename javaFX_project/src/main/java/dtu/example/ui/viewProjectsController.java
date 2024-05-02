package dtu.example.ui;

import javafx.event.ActionEvent;

import java.io.IOException;

public class viewProjectsController {
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
}
