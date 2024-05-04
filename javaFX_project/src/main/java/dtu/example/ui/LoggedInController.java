package dtu.example.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoggedInController {
   public Label textLabel;

    public void registerEmployee(ActionEvent actionEvent) throws IOException {
        App.setRoot("registerEmployee");
    }

    public void viewProjects(ActionEvent actionEvent) throws IOException{
        App.setRoot("viewProjects");
    }
    public void registerTimeScreen(ActionEvent actionEvent) throws IOException{
        App.setRoot("registerTime");
    }

    public void deleteEmployee(ActionEvent actionEvent) throws IOException{
        App.setRoot("deleteEmployee");
    }

    public void logOut(ActionEvent actionEvent) throws IOException{
        App.setRoot("login");
    }

    public void viewActivities(ActionEvent actionEvent) throws IOException{
        App.setRoot("viewActivities");
    }
}
