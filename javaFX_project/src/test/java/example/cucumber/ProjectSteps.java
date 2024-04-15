package example.cucumber;

import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.OperationNotAllowedException;
import dtu.projectmanagement.app.Project;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
public class ProjectSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessageHolder;

    public ProjectSteps(ProjectManagementApp projectManagementApp, ErrorMessageHolder errorMessageHolder) {
        this.projectManagementApp = projectManagementApp;
        this.errorMessageHolder = errorMessageHolder;
    }

    @Given("there exists a project with the name {string}")
    public void there_exists_a_project_with_the_name(String string) {
        Project p1 = new Project(string);
        projectManagementApp.addProjectToList(p1);
        for (Project project : projectManagementApp.getProjectList()) {
            assertEquals(project.getName(), string);
        }
    }

    @When("user deletes the project {string}")
    public void The_user_deletes_the_project(String string) {
        try {
            projectManagementApp.removeProjectFromList(string);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("The project {string} doesn’t exist")
    public void the_project_doesnt_exist(String string){
        for(Project project: projectManagementApp.getProjectList()){
            assertNotEquals(project.getName(), string);
        }
    }


    @Given("there is no project with name {string}")
    public void there_is_no_project_with_name(String name){
        boolean nameExists = false;
        for(Project p: projectManagementApp.getProjectList()){
            if (p.getName().equals(name)) {
                nameExists = true;
                break;
            }
        }
        assertFalse(nameExists);
    }


    @When("the user creates the project with name {string}")
    public void the_user_creates_the_project_with_name(String string) {
        try {
            projectManagementApp.createProject(string);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }

    }

    @Then("there is a project with name {string}")
    public void there_is_a_project_with_name(String string) {
        assertTrue(projectManagementApp.hasProjectWithName(string));
    }


    @Given("no project with the name {string} exists")
    public void no_project_with_the_name_exists(String string) {
        assertFalse(projectManagementApp.hasProjectWithName(string));
    }

    @When("user sets employee with initials {string} as new leader of the project {string}")
    public void user_sets_employee_with_initials_as_new_leader_of_the_project(String initials, String p1) {
        try {
            projectManagementApp.assignProjectLeader(p1, initials);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employee with initials {string} is the project leader of the project {string}")
    public void theEmployeeWithInitialsIsTheProjectLeaderOfTheProject(String initials, String p1) {
        try {
            assertSame(projectManagementApp.getProjectWithName(p1).getProjectLeader(), projectManagementApp.getEmployeeWithInitials(initials));
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
}
