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

    @When("the employee sets a start year {int}, start week {int}, end year {int} and end week {int}")
    public void the_employee_sets_a_start_date_with_year_and_week(int start_year, int start_week, int end_year, int end_week) {
        projectManagementApp.setStartEndActivity(start_year, start_week, end_year, end_week, projectHolder.getProject().getName(), activityHolder.getActivity().getName());

    }

    @Then("the activity has a start date with year {int} and week {int}")
    public void the_activity_has_a_start_date_with_year_and_week( int start_year, int start_week) {
        assertEquals(activityHolder.getActivity().getStartDate().getYear(), start_year);
        assertEquals(activityHolder.getActivity().getStartDate().getWeek(), start_week);
    }

    @Then("the activity has an end date with year {int} and week {int}")
    public void the_activity_has_an_end_date_with_year_and_week( int end_year, int end_week) {
        assertEquals(activityHolder.getActivity().getEndDate().getYear(), end_year);
        assertEquals(activityHolder.getActivity().getEndDate().getWeek(), end_week);
    }

}