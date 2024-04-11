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

    public void login(String initials) throws OperationNotAllowedException{
        for (Employee employee : employeeList) {
            if(employee.getInitials().equals(initials)) {
                loggedIn = employee;
                employeeLoggedIn = true;
                return;
            }
        } throw new OperationNotAllowedException("employee with initials " + initials + " is not in the system");
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

    public boolean hasProjectWithName(String name){
        for(Project p : projectList){
            if(p.getName().equals(name)){
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

    public void removeProjectFromList(String name) throws OperationNotAllowedException{
        for(Project project: projectList){
            if(project.getName().equals(name)){
                projectList.remove(project);
                return;
            }
        }
        throw new OperationNotAllowedException("Project with the name " + name + " doesn't exist");
    }

    public boolean hasEmployeeWithInitials(String initials) {
        for (Employee employee : employeeList) {
            if (employee.getInitials().equals(initials)) {
                return true;
            }
        }
        return false;
    }

    public void addEmployeeToEmployeeList(Employee employee) {
        employeeList.add(employee);
    }

    public void registerEmployee(String firstName, String lastName) throws OperationNotAllowedException {
        if (hasEmployeeWithName(firstName, lastName)){
            throw new OperationNotAllowedException("Employee is already registered");
        }
        Employee employee = new Employee(firstName, lastName);
        addEmployeeToEmployeeList(employee);
    }

    public boolean hasEmployeeWithName(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeWithInitials(String initials) throws OperationNotAllowedException{
        for(Employee employee: employeeList){
            if(employee.getInitials().equals(initials)){
                return employee;
            }
        } throw new OperationNotAllowedException("Employee with the initials " + initials + " does not exist");
    }

    public Project getProjectWithName(String name){
        for(Project project: projectList){
            if(project.getName().equals(name)){
                return project;
            }
        }
        return null;
    }

    public void assignProjectLeader(String projectName, String initials) throws OperationNotAllowedException{
        getProjectWithName(projectName).setProjectLeader(getEmployeeWithInitials(initials));
    }
}
