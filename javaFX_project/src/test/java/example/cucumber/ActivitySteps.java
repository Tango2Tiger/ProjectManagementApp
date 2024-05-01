package example.cucumber;

import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.ProjectManagementApp;

public class ActivitySteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessageHolder;
    public ActivitySteps(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessageHolder) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessageHolder = errorMessageHolder;
    }

}
