package example.cucumber;

import dtu.projectmanagement.app.*;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
public class ProjectSteps {
    private Employee employee;
    private ProjectManagementApp projectManagementApp;
    private ErrorMessageHolder errorMessageHolder;
    private EmployeeHolder employeeHolder;
    private Project project;
    private Activity activity;
    private ActivityHolder activityHolder;
    private ProjectHolder projectHolder;

    public ProjectSteps(ProjectManagementApp projectManagementApp, EmployeeHolder employeeHolder, ErrorMessageHolder errorMessageHolder, ActivityHolder activityHolder, ProjectHolder projectHolder) {
        this.projectManagementApp = projectManagementApp;
        this.employeeHolder = employeeHolder;
        this.errorMessageHolder = errorMessageHolder;
        this.activityHolder = activityHolder;
        this.projectHolder = projectHolder;
    }

    @Given("there exists a project with the name {string}")
    public void there_exists_a_project_with_the_name(String p1) {
        project = new Project(p1);
        projectManagementApp.addProjectToList(project);
        projectHolder.setProject(project);
        assertTrue(projectManagementApp.hasProjectWithName(p1));
    }

    @When("employee deletes the project {string}")
    public void The_employee_deletes_the_project(String string) {
        try {
            projectManagementApp.removeProjectFromList(string);
        } catch (OperationNotAllowedException e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("The project {string} doesn’t exist")
    public void the_project_doesnt_exist(String string){
        assertFalse(projectManagementApp.hasProjectWithName(string));
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


    @When("the employee creates the project with name {string}")
    public void the_employee_creates_the_project_with_name(String string) {
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

    @When("employee sets employee with initials {string} as new leader of the project {string}")
    public void employee_sets_employee_with_initials_as_new_leader_of_the_project(String initials, String p1) {
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

    @Given("the project {string} has no activity with the name {string}")
    public void theProjectHasNoActivityWithTheName(String p1, String a1) {
        assertFalse(projectManagementApp.getProjectWithName(p1).hasActivityWithName(a1));
    }


    @When("the employee gets assigned to the project")
    public void the_employee_gets_assigned_to_the_project() {
        project = new Project("p1");
        project.addEmployee(employeeHolder.getEmployee());

    }

    @Then("the employee is assigned to the project")
    public void the_employee_is_assigned_to_the_project() {
        assertTrue(project.hasEmployee(employeeHolder.getEmployee()));
    }


    @Given("the project {string} has an activity with the name {string}")
    public void theProjectHasAnActivityWithTheName(String p1, String a1) throws OperationNotAllowedException{
        projectManagementApp.createActivity(projectManagementApp.getProjectWithName(p1), a1);
        activityHolder.setActivity(projectManagementApp.getActivityFromProject(p1,a1));

        assertTrue(projectManagementApp.getProjectWithName(p1).hasActivityWithName(a1));
    }

    @Given("the project {string} has no activities")
    public void the_project_has_no_activities(String string) {
        assertTrue(projectManagementApp.getProjectWithName(string).getActivityList().isEmpty());
    }
}
