package dtu.projectmanagement.app;

import java.util.ArrayList;

public class Project {
    private String name;
    private int projectNumber;

    private Employee projectLeader;
    private ArrayList<Activity> activityList = new ArrayList<>();
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

    public void createActivity(String name) throws OperationNotAllowedException {
        activityList.add(new Activity(name));
    }

    public boolean hasActivityWithName(String name){
        for(Activity activity: activityList){
            if(activity.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void addEmployee(Employee employee) {this.employeeList.add(employee);}

    public ArrayList<Employee> getEmployeeList(){ return employeeList;}

    public boolean hasEmployee(Employee employee) {
        for(Employee em : employeeList){
            if(em.equals(employee)){
                return true;
            }
        }
        return false;
    }

    public Activity getActivityWithName(String activityName) {
        for( Activity activity: activityList){
            if(activity.getName().equals(activityName)){
                return activity;
            }
        }
        return null;
    }

    public ArrayList<Activity> getActivityList() {
        return activityList;
    }
}
