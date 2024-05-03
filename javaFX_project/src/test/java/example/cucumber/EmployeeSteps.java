package example.cucumber;
import dtu.projectmanagement.app.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Optional;

import static org.junit.Assert.*;


public class EmployeeSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    private EmployeeHolder employeeHolder;
    private ErrorMessageHolder errorMessageHolder;
    private Activity activity;
    private ActivityHolder activityHolder;
    public EmployeeSteps(ProjectManagementApp projectManagementApp, EmployeeHolder employeeHolder, ActivityHolder activityHolder, ErrorMessageHolder errorMessageHolder) {
        this.projectManagementApp = projectManagementApp;
        this.employeeHolder = employeeHolder;
        this.errorMessageHolder = errorMessageHolder;
        this.activityHolder = activityHolder;

    }

    @Given("there is an employee with initials {string}")
    public void there_is_an_employee_with_initials(String string) {
        employee = new Employee("Hubert", "Baumeister");
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

    @Then("the employee now has {int} half hours sickness registered")
    public void the_employee_now_has_half_hours_sickness_registered(Integer halfhours) {
        assertEquals(employeeHolder.getEmployee().getRegisteredSickness(), (int) halfhours);
    }


}
