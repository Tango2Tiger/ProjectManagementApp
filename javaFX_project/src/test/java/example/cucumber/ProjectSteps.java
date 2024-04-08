package example.cucumber;

import dtu.projectmanagement.app.Employee;
import dtu.projectmanagement.app.Project;
import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
public class ProjectSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;

    public ProjectSteps(ProjectManagementApp projectManagementApp) {
        this.projectManagementApp = projectManagementApp;
    }

    @Given("That the user is logged in")
    public void that_the_user_is_logged_in() {
        assertTrue(projectManagementApp.isEmployeeLoggedIn());
    }

    @Given("There exists a project with the name {string}")
    public void there_exists_a_project_with_the_name(String string) {
        Project p1 = new Project("p1");
        projectManagementApp.addProjectToList(p1);
        for (Project project : projectManagementApp.getProjectList()) {
            assertEquals(project.getName(), string);
        }
    }

    @When("The user deletes the project {string}")
    public void The_user_deletes_the_project(String string){
        projectManagementApp.removeProjectFromList(string);
    }

    @Then("The project {string} doesn’t exist")
    public void the_project_doesnt_exist(String string){
        for(Project project: projectManagementApp.getProjectList()){
            assertNotEquals(project.getName(), string);
        }

    }
}