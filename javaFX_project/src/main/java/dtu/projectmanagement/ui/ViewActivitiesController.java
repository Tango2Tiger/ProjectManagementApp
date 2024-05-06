package dtu.projectmanagement.ui;

import javafx.event.ActionEvent;

import java.io.IOException;

/**
 @author s235233
 */
public class ViewActivitiesController {
    public void setDateScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("startEndActivity");
    }

    public void createActivity(ActionEvent actionEvent) throws IOException{
        App.setRoot("createActivityScene");
    }

    public void activityScreen (ActionEvent actionEvent) throws IOException {
        App.setRoot("setBudgetedTime");
    }

    public void returnToLoggedIn(ActionEvent actionEvent) throws IOException {
        App.setRoot("loggedIn");
    }

    public void switchToDeleteActivity(ActionEvent actionEvent) throws IOException{
        App.setRoot("deleteActivity");
    }

    public void assignToActivityScreen(ActionEvent actionEvent) throws IOException{
        App.setRoot("assignEmployeeToActivity");
    }
}
