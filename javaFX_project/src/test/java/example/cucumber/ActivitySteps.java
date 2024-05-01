package example.cucumber;


import dtu.projectmanagement.app.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ActivitySteps {
    private ProjectHolder projectHolder;
    private Employee employee;
    private Project project;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessageHolder;
    public ActivitySteps(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessageHolder, ProjectHolder projectHolder) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessageHolder = errorMessageHolder;
        this.projectHolder = projectHolder;
    }

    @When("the employee creates an activity with the name {string} under the project {string}")
    public void the_employee_creates_an_activity_with_the_name(String name, String p1) {
        //project = new Project(p1);
        //projectHolder.setProject(project);
        try {
            projectManagementApp.createActivity(projectHolder.getProject(), name);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }


    @Then("there is an activity with the name {string} under the project {string}")
    public void thereIsAnActivityWithTheName(String a1, String p1) {
        assertTrue(projectHolder.getProject().hasActivityWithName(a1));
    }
}
