package dtu.projectmanagement.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 @author s235221
 */
public class ViewEmployeesController {
    public Label textLabel;

    public void registerEmployee(ActionEvent actionEvent) throws IOException {
        App.setRoot("registerEmployee");
    }

    public void registerTimeScreen(ActionEvent actionEvent) throws IOException{
        App.setRoot("registerTime");
    }

    public void registerAbsence(ActionEvent actionEvent) throws IOException{
        App.setRoot("registerAbsence");
    }

    public void deleteEmployee(ActionEvent actionEvent) throws IOException{
        App.setRoot("deleteEmployee");
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException{
        App.setRoot("loggedIn");
    }

    public void deleteAbsence(ActionEvent actionEvent) throws IOException {
        App.setRoot("deleteAbsenceRegistration");
    }
}
