package example.cucumber;

import dtu.projectmanagement.app.ProjectManagementApp;
import io.cucumber.java.en.Given;
import src.main.java.dtu.projectmanagement.app.Project;

import static org.junit.Assert.assertFalse;


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


}
