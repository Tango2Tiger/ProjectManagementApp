package example.cucumber;

import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.EmployeeHolder;
import dtu.projectmanagement.app.OperationNotAllowedException;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    private EmployeeHolder employeeHolder;
    private ErrorMessageHolder errorMessageHolder;
    public LoginSteps(ProjectManagementApp projectManagementApp, EmployeeHolder employeeHolder, ErrorMessageHolder errorMessageHolder) {
        this.projectManagementApp = projectManagementApp;
        this.employeeHolder = employeeHolder;
        this.errorMessageHolder = errorMessageHolder;
    }
    @Given("that no employee is logged in")
    public void that_no_employee_is_logged_in() {
        assertFalse(projectManagementApp.isEmployeeLoggedIn());
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        employee = new Employee("Hubert", "Baumeister");
        projectManagementApp.getEmployeeList().add(employeeHolder.getEmployee());
        try {
            projectManagementApp.login(employeeHolder.getEmployee().getInitials());
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
        assertTrue(projectManagementApp.isEmployeeLoggedIn());
    }


    @When("the employee logs in")
    public void the_employee_logs_in() {
        try {
            projectManagementApp.login(employeeHolder.getEmployee().getInitials());
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employee is logged in")
    public void the_employee_is_logged_in() {
        assertEquals(employeeHolder.getEmployee(), projectManagementApp.getLoggedIn());
    }

    @Then("the error message {string} is received")
    public void the_error_message_is_received(String string) {
        assertEquals(string, errorMessageHolder.getErrorMessage());
    }


}
