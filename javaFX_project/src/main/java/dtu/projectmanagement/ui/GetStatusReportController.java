package dtu.projectmanagement.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        projectChoiceBox.getItems().addAll(App.getProjectManagementApp().getProjectNameList());

    }

    public void downloadProjectReport() {
        if(!isNull(projectChoiceBox.getValue())){
            Window stage = pane.getScene().getWindow();
            FileChooser fc = new FileChooser();

            fc.setInitialFileName("status_report_" + projectChoiceBox.getValue() + ".txt");
            fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Downloads"));

            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
            fc.getExtensionFilters().add(filter);

            File file = fc.showSaveDialog(stage);
            App.getProjectManagementApp().getProjectWithName(projectChoiceBox.getValue()).writeReport(file);
        }
    }

    public void returnToViewProjects(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewProjects");
    }

}


