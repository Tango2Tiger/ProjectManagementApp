package example.cucumber;
import dtu.projectmanagement.businesslogic.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;


public class EmployeeSteps {
    private Employee employee;
    private Calendar startDate;
    private Calendar endDate;
    private ProjectManagementApp projectManagementApp;
    private EmployeeHolder employeeHolder;
    private Activity activity;
    private ActivityHolder activityHolder;
    private ProjectHolder projectHolder;
    private ErrorMessageHolder errorMessageHolder;
    public EmployeeSteps(ProjectManagementApp projectManagementApp, EmployeeHolder employeeHolder, ErrorMessageHolder errorMessageHolder, ActivityHolder activityHolder, ProjectHolder projectHolder) {
        this.projectManagementApp = projectManagementApp;
        this.employeeHolder = employeeHolder;
        this.errorMessageHolder = errorMessageHolder;
        this.activityHolder = activityHolder;
        this.projectHolder = projectHolder;

    }

    @Given("there is an employee with initials {string}")
    public void there_is_an_employee_with_initials(String string) {
        employee = new Employee("Hubert","Baumeister");
        employee.setInitials();
        employeeHolder.setEmployee(employee);
        assertEquals(employeeHolder.getEmployee().getInitials(), string);
    }



    @Given("there is no employee with initials {string}")
    public void there_is_no_employee_with_initials(String string) {
        assertFalse(projectManagementApp.hasEmployeeWithInitials(string));
    }
    @Given("the employee is registered in the system")
    public void the_employee_is_registered_in_the_system() {
        projectManagementApp.addEmployeeToEmployeeList(employee);
    }

    @Given("there is no employee with initials {string} in the system")
    public void there_is_no_employee_with_initials_in_the_system(String string) {
        assertFalse(projectManagementApp.hasEmployeeWithInitials(string));
    }
    @Given("there is an employee with initials {string} registered")
    public void there_is_an_employee_with_initials_registered(String string) throws OperationNotAllowedException {
        employee = new Employee("Hubert", "Baumeister");
        employee.setInitials();
        projectManagementApp.registerEmployee(employee.getFirstName(), employee.getLastName());
        employeeHolder.setEmployee(employee);
        assertTrue(projectManagementApp.hasEmployeeWithInitials(string));
    }
    @Given("there is an employee with first name {string} and last name {string}")
    public void there_is_an_employee_with_first_name_and_last_name(String firstName, String lastName) {
        employee = new Employee(firstName, lastName);
        employeeHolder.setEmployee(employee);
    }

    @When("the employee with first name {string} and last name {string} is registered")
    public void theEmployeeWithFirstNameAndLastNameIsRegistered(String firstName, String lastName) {
        try {
            projectManagementApp.registerEmployee(firstName, lastName);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employee with first name {string} and last name {string} is in the system")
    public void the_employee_with_first_name_and_last_name_is_in_the_system(String firstName, String lastName) {
        assertTrue(projectManagementApp.hasEmployeeWithName(firstName, lastName));
    }

    @When("the employee with first name {string} and last name {string} is registered again")
    public void the_employee_with_first_name_and_last_name_is_registered_again(String firstName, String lastName) {
        try {
            projectManagementApp.registerEmployee(firstName, lastName);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
    @Given("an employee is logged in")
    public void an_employee_is_logged_in() throws OperationNotAllowedException {
        employee = new Employee("Hubert", "Baumeister");
        employee.setInitials();
        employeeHolder.setEmployee(employee);
        projectManagementApp.addEmployeeToEmployeeList(employee);
        projectManagementApp.login("huba");
    }
    @Given("the employee has {int} half hours registered")
    public void the_employee_has_half_hours_registered(Integer halfhours) {
        assertTrue(employeeHolder.getEmployee().getRegisteredTime() == halfhours);
    }
    @Then("the employee now has {int} half hours registered")
    public void the_employee_now_has_half_hours_registered(Integer int1) {
        assertTrue((employeeHolder.getEmployee().getRegisteredTime()) == int1);
    }
    @Given("the employee has {int} sickness half hours registered")
    public void the_employee_has_sickness_half_hours_registered(Integer halfhours) {
        activity = new Activity("a1");
        activityHolder.setActivity(activity);
        assertEquals(employeeHolder.getEmployee().getRegisteredSickness(), (int) halfhours);
    }

    @Then("the employee now has {int} days sickness registered")
    public void the_employee_now_has_half_hours_sickness_registered(Integer days) {
        assertEquals(employeeHolder.getEmployee().getRegisteredSickness(), (int) days);
    }

    @When("the employee gets assigned to the activity {string}")
    public void the_employee_gets_assigned_to_the_activity(String name) throws OperationNotAllowedException {
        projectManagementApp.assignEmployeeToActivity(employeeHolder.getEmployee(),activityHolder.getActivity());

    }

    @Then("the employee is assigned to the activity {string}")
    public void the_employee_is_assigned_to_the_activity(String string) {
        assertTrue(projectManagementApp.employeeHasActivity(employeeHolder.getEmployee(),activityHolder.getActivity()));
    }

    @When("employee deletes the employee with name {string}")
    public void employee_deletes_the_employee_with_name(String string) {
        projectManagementApp.deleteEmployee(employeeHolder.getEmployee());
    }

    @Then("the employee is not on the employeeList")
    public void the_employee_is_not_on_the_employee_list() {
        assertFalse(projectManagementApp.hasEmployeeWithInitials(employeeHolder.getEmployee().getInitials()));
    }

    @Then("the employee is not on the projects employeeList")
    public void the_employee_is_not_on_the_projects_employee_list() {
        assertFalse(projectManagementApp.projectHasEmployee(projectHolder.getProject(), employeeHolder.getEmployee()));
    }


    @When("the employee registers absence from year {int} month {int} day {int} to year {int} month {int} day {int}")
    public void theEmployeeRegistersAbsenceFromYearMonthDayToYearMonthDay(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        startDate = new GregorianCalendar(startYear, startMonth, startDay);
        endDate = new GregorianCalendar(endYear, endMonth, endDay);
        projectManagementApp.registerAbsence(startYear, startMonth, startDay, endYear, endMonth, endDay);
    }

    @Then("the app has an absence registration with the same start and end date for that employee")
    public void theAppHasAnAbsenceRegistrationWithTheSameStartAndEndDateForThatEmployee() {
        int startYear = startDate.get(Calendar.YEAR);
        int startMonth = startDate.get(Calendar.MONTH);
        int startDay = startDate.get(Calendar.DAY_OF_MONTH);
        int endYear = endDate.get(Calendar.YEAR);
        int endMonth = endDate.get(Calendar.MONTH);
        int endDay = endDate.get(Calendar.DAY_OF_MONTH);
        assertTrue(projectManagementApp.hasAbsence(startYear, startMonth, startDay, endYear, endMonth, endDay, employeeHolder.getEmployee()));
    }
}
