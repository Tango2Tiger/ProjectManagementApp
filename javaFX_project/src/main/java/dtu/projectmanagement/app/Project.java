package dtu.projectmanagement.app;

import java.util.ArrayList;

public class Project {
    private String name;
    private int projectNumber;
    private Employee projectLeader;
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public Project(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = 24000 + projectNumber;
    }

    public Employee getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Employee projectLeader) {
        this.projectLeader = projectLeader;
    }

    public void addEmployee(Employee employee) {this.employeeList.add(employee);}

    public ArrayList<Employee> getEmployeeList(){ return employeeList;}
}
