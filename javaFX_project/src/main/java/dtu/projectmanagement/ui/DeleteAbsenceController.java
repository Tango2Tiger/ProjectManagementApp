package dtu.projectmanagement.ui;

import dtu.projectmanagement.businesslogic.AbsenceRegistration;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
/**
 @author s235223
 */

public class DeleteAbsenceController implements Initializable {

    public ChoiceBox<String> absenceChoiceBox;
    public Label deleteAbsenceLabel;
    public Button deleteAbsenceButton;
    public Button returnButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillAbsenceChoiceBox();
    }

    public void deleteAbsence(ActionEvent actionEvent) {
        String[] s = absenceChoiceBox.getValue().split(" to ");
        String[] start = s[0].split("-");
        String[] end = s[1].split("-");
        try {
            App.getProjectManagementApp().deleteAbsence(Integer.parseInt(start[0]), Integer.parseInt(start[1]) - 1, Integer.parseInt(start[2]),
                                                        Integer.parseInt(end[0]), Integer.parseInt(end[1]) - 1, Integer.parseInt(end[2]));
            deleteAbsenceLabel.setText("Successfully deleted absence");
        } catch (OperationNotAllowedException e) {
            deleteAbsenceLabel.setText(e.getMessage());
        }
    }

    public void returnToViewEmployees(ActionEvent actionEvent) throws IOException {
        App.setRoot("viewEmployees");
    }
    public void fillAbsenceChoiceBox() {
        for (AbsenceRegistration absenceRegistration : App.getProjectManagementApp().getAbsencesForLoggedIn()) {
            String ymd = Integer.toString(absenceRegistration.getStartYear()) + "-" + Integer.toString(absenceRegistration.getStartMonth() + 1)
                    + "-" + Integer.toString(absenceRegistration.getStartDay()) + " to " + Integer.toString(absenceRegistration.getEndYear()) +
                    "-" + Integer.toString(absenceRegistration.getEndMonth() + 1)
                    + "-" + Integer.toString(absenceRegistration.getEndDay());
            absenceChoiceBox.getItems().addAll(ymd);
        }

    }

}
