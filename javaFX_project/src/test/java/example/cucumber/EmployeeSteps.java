package example.cucumber;
import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.EmployeeHolder;
import dtu.projectmanagement.app.OperationNotAllowedException;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class EmployeeSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    private EmployeeHolder employeeHolder;
    private ErrorMessageHolder errorMessageHolder;
    public EmployeeSteps(ProjectManagementApp projectManagementApp, EmployeeHolder employeeHolder, ErrorMessageHolder errorMessageHolder) {
        this.projectManagementApp = projectManagementApp;
        this.employeeHolder = employeeHolder;
        this.errorMessageHolder = errorMessageHolder;

    }
    @Given("there is an employee with initials {string}")
    public void there_is_an_employee_with_initials(String string) {
        employee = new Employee("Hubert", "Baumeister");
        employeeHolder.setEmployee(employee);
        assertEquals(employeeHolder.getEmployee().getInitials(), string);
    }

    //@When("the user registers an employee")
    //public void the_user_registers_an_employee() {
      //  projectManagementApp.getEmployeeList();

    //}
    @Then("a new employeee is created")
    public void aNewEmployeeIsCreated() {
        // Write code here that turns the phrase above into concrete actions

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


}
