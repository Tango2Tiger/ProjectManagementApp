package example.cucumber;
import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class EmployeeSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    public EmployeeSteps(ProjectManagementApp projectManagementApp) {
        this.projectManagementApp = projectManagementApp;

    }
    @Given("there is an employee with name\\{string}")
    public void there_is_an_employee_with_name() {
        employee = new Employee("Hubert", "Baumeister");
    }
    @When("the user registers an employee")
    public void the_user_registers_an_employee() {
        projectManagementApp.getEmployeeList().add(employee);

    }
    @Then("the employee with name\\{string} exists in the system")
    public void the_employee_with_name_string_exists_in_the_system(String name) {
        assertTrue("Employee does not exist in the system", projectManagementApp.hasEmployee(name));
    }

}

