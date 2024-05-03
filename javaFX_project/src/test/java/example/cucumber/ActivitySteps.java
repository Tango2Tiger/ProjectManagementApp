package example.cucumber;


import dtu.projectmanagement.app.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ActivitySteps {
    private ProjectHolder projectHolder;
    private ActivityHolder activityHolder;
    private EmployeeHolder employeeHolder;
    private Employee employee;
    private Project project;
    private Activity activity;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessageHolder;
    public ActivitySteps(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessageHolder, EmployeeHolder employeeHolder, ProjectHolder projectHolder, ActivityHolder activityHolder) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessageHolder = errorMessageHolder;
        this.projectHolder = projectHolder;
        this.activityHolder = activityHolder;
        this.employeeHolder = employeeHolder;
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
        try {
            projectManagementApp.setStartEndActivity(start_year, start_week, end_year, end_week, projectHolder.getProject().getName(), activityHolder.getActivity().getName());
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
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

    @Given("the activity has {int} half hours registered")
    public void the_activity_has_half_hours_registered(Integer int1) {
        assertEquals(activityHolder.getActivity().getRegisteredTime(), (int) int1);
    }


    @When("the employee registers {int} half hours on sickness")
    public void the_employee_registers_half_hours_on_sickness(Integer halfhours) {
        projectManagementApp.registerSickness(employeeHolder.getEmployee(),halfhours);
    }

    @Then("the activity now has {int} half hours registered")
    public void the_activity_now_has_half_hours_registered(Integer int1) {
        assertEquals(activityHolder.getActivity().getRegisteredTime(), (int) int1);
    }

    @When("the employee registers {int} half hours for the year {int}, month {int}, and day {int}")
    public void theEmployeeRegistersHalfHoursForTheYearMonthAndDay(int arg0, int arg1, int arg2, int arg3) {
        try {
            projectManagementApp.registerTime(employeeHolder.getEmployee(), activityHolder.getActivity(), arg0, arg1, arg2, arg3);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
    @When("the employee registers {int} days of sickness")
    public void the_employee_registers_days_of_sickness(Integer days) {
        projectManagementApp.registerSickness(employeeHolder.getEmployee(),days);
    }

    @And("the activity now has {int} half hours registered from the employee on the date {int}, {int}, {int}")
    public void theActivityNowHasHalfHoursRegisteredFromTheEmployeeOnTheDate(int arg0, int arg1, int arg2, int arg3) {
        activity = activityHolder.getActivity();
        String employeeName = employeeHolder.getEmployee().getFullName();
        TimeRegistration timeRegistration = activity.getSpecificTimeRegistration(employeeName, new GregorianCalendar(arg1, arg2, arg3));
        assertTrue(activity.getRegisteredTime() == arg0);
        assertTrue(timeRegistration.getHalfHours() == arg0);
    }
}

