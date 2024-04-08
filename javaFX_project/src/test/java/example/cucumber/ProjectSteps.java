package example.cucumber;

import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import src.main.java.dtu.projectmanagement.app.Project;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ProjectSteps {
    private ProjectManagementApp projectManagementApp;
    public ProjectSteps(ProjectManagementApp projectManagementApp) {
        this.projectManagementApp = projectManagementApp;
    }

    @Given("there is no project with name {string}")
    public void there_is_no_project_with_name(String name){
        boolean nameExists = false;
        for(Project p: ProjectManagementApp.projectList){
            if(p.getName().equals(name)){
                nameExists = true;
            }
        }
        assertFalse(nameExists);
    }

    @When("the user creates the project")
    public void the_user_creates_the_project() {
        Project p1 = new Project("project1",1000);
        ProjectManagementApp.addProject(p1);
    }

    @Then("there is a project with name {string}")
    public void there_is_a_project_with_name(String name) {
        assertTrue(ProjectManagementApp.hasProject(name));
    }

}
