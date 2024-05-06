package example.cucumber;

import dtu.projectmanagement.businesslogic.Employee;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;
import io.cucumber.java.en.And;
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
        assertEquals(employeeHolder.getEmployee().getInitials(), projectManagementApp.getLoggedIn().getInitials());
    }

    @Then("the error message {string} is received")
    public void the_error_message_is_received(String string) {
        assertEquals(string, errorMessageHolder.getErrorMessage());
    }


    @When("the employee logs out")
    public void theEmployeeLogsOut() {
        projectManagementApp.logout();
    }

    @Then("no employee is logged in")
    public void noEmployeeIsLoggedIn() {
        assertEquals(null, projectManagementApp.getLoggedIn());
    }

    @And("there is an employee with initials {string}")
    public void thereIsAnEmployeeWithInitials(String arg0) {
        employee = new Employee("Hubert","Baumeister");
        employee.setInitials();
        employeeHolder.setEmployee(employee);
    }
}
