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

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }
}
