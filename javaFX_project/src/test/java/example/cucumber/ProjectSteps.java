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

    @Given("There exists a project with the name {string}")
    public void there_exists_a_project_with_the_name(String string) {
        Project p1 = new Project("p1", 1);
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

    @When("the user creates the project")
    public void the_user_creates_the_project() {
        Project p1 = new Project("project1",1000);
        projectManagementApp.addProject(p1);
    }

    @Then("there is a project with name {string}")
    public void there_is_a_project_with_name(String name) {
        assertTrue(projectManagementApp.hasProject(name));
    }

}
