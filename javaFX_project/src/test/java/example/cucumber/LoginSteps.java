package example.cucumber;

import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private ProjectManagementApp projectManagementApp;
    public LoginSteps(ProjectManagementApp projectManagementApp) {
        this.projectManagementApp = projectManagementApp;
    }
    @Given("that no employee is logged in")
    public void that_no_employee_is_logged_in() {
        assertFalse(ProjectManagementApp.isEmployeeLoggedIn());
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(ProjectManagementApp.isEmployeeLoggedIn());
    }

    @Given("there is a employee with initials {string}")
    public void there_is_a_employee_with_initials(String string) {
        Employee employee = new Employee("Hubert", "Baumeister");
    }
    @When("the user logs in")
    public void the_user_logs_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
