package example.cucumber;

import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    public LoginSteps(ProjectManagementApp projectManagementApp) {
        this.projectManagementApp = projectManagementApp;
    }
    @Given("that no employee is logged in")
    public void that_no_employee_is_logged_in() {
        assertFalse(ProjectManagementApp.isEmployeeLoggedIn());
    }
    @Given("there is a employee with initials {string}")
    public void there_is_a_employee_with_initials(String string) {
        Employee employee = new Employee("Hubert", "Baumeister");
        assertEquals(employee.getInitials(), string);
    }
    @When("the employee logs in")
    public void the_employee_logs_in() {
        ProjectManagementApp.login(employee.getInitials());
    }

}
