package example.cucumber;


import dtu.projectmanagement.app.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ActivitySteps {
    private ProjectHolder projectHolder;
    private ActivityHolder activityHolder;
    private Employee employee;
    private Project project;
    private Activity activity;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessageHolder;
    public ActivitySteps(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessageHolder, ProjectHolder projectHolder, ActivityHolder activityHolder) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessageHolder = errorMessageHolder;
        this.projectHolder = projectHolder;
        this.activityHolder = activityHolder;
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
    @When("The employee sets the budgetet time for the activity belonging to the project to {int} hours")
    public void the_employee_sets_the_budgetet_time_for_the_activity_belonging_to_the_project_to_hours(Integer int1) {
        try {
            projectManagementApp.getActivityFromProject(projectHolder.getProject().getName(), activityHolder.getActivity().getName()).setBudgetedTime(int1);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
    @Then("The activity has the budgetet time {int} hours")
    public void the_activity_has_the_budgetet_time_hours(Integer int1) {
        int bt = projectManagementApp.getActivityFromProject(projectHolder.getProject().getName(), activityHolder.getActivity().getName()).getBudgetedTime();
        assertTrue(int1 == bt);
    }

}
