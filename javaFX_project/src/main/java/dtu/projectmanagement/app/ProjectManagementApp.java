package dtu.projectmanagement.app;


import java.util.ArrayList;
import java.util.List;

public class ProjectManagementApp {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private Employee loggedIn;
    private boolean employeeLoggedIn = false;


    private ArrayList<Project> projectList = new ArrayList<>();


    public boolean isEmployeeLoggedIn() {
        return employeeLoggedIn;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setEmployeeLoggedIn(boolean employeeLoggedIn) {
        this.employeeLoggedIn = employeeLoggedIn;
    }

    public void login(String initials) {
        for (Employee employee : employeeList) {
            if(employee.getInitials().equals(initials)) {
                loggedIn = employee;
                employeeLoggedIn = true;
            }
        }
    }

    public Employee getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Employee loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void addProject(Project project){
        projectList.add(project);
    }

    public boolean hasProject(String project){
        for(Project p : projectList){
            if(p.getName().equals(project)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Project> getProjectList(){
        return this.projectList;
    }

    public void addProjectToList(Project project){
        this.projectList.add(project);
    }

    public void removeProjectFromList(String name){
        projectList.removeIf(project -> project.getName().equals(name));
    }
}
