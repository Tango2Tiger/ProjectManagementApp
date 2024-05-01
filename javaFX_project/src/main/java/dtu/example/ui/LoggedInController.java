package dtu.example.ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoggedInController {
   public Label textLabel;

    public void registerEmployee(ActionEvent actionEvent) throws IOException {
        App.setRoot("registerEmployee");
    }

    public void createProject(ActionEvent actionEvent) throws IOException{
        App.setRoot("createProject");
    }
}
