package dtu.projectmanagement.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public class GetStatusReportController implements Initializable {
    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    AnchorPane pane;
    @FXML
    private Label statusReportLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());

    }

    public void downloadProjectReport() {
        if(!isNull(projectChoiceBox.getValue())){
            App.getProjectManagementApp().downloadProjectReport(projectChoiceBox.getValue(), pane);
        } else{
            statusReportLabel.setText("Please select a project.");
        }
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }

}


