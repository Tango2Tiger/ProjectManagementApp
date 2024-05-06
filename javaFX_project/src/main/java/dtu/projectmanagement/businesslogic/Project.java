package dtu.projectmanagement.businesslogic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Project {
    private String name;
    private int projectNumber;

    private Employee projectLeader;
    private ArrayList<Activity> activityList = new ArrayList<>();
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<String> employeeNameList = new ArrayList<>();

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

    public void addEmployee(Employee employee) {
        this.getEmployeeList().add(employee);}

    public ArrayList<Employee> getEmployeeList(){ return employeeList;}

    public boolean hasEmployee(Employee employee) {
        for(Employee em : getEmployeeList()){
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

    public ArrayList<String> getActivityNameList(){
        ArrayList<String> activityNameList = new ArrayList<>();
        for(Activity activity: this.activityList){
            activityNameList.add(activity.getName());
        }
        return activityNameList;
    }

    public void deleteActivity(String activityName){
        activityList.remove(getActivityWithName(activityName));
        for(Employee employee: this.getEmployeeList()){
            if(employee.hasActivity(getActivityWithName(activityName))){
                employee.removeActivity(getActivityWithName(activityName));
            }
        }
    }
    public void convertEmployeeListToNameList(){
        employeeNameList.clear();
        for(Employee employee: employeeList){
            employeeNameList.add(employee.getInitials());
        }
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public ArrayList<String> getEmployeeNameList(){
        convertEmployeeListToNameList();
        return employeeNameList;
    }

    public void writeReport(File report){
        try {
            FileWriter writer = new FileWriter(report);
            writer.write("Status report for " + this.name + " - #" + this.getProjectNumber() + "\n\n");

            for(Activity activity: activityList){
                writer.write("Activity name: " + activity.getName() + "  -  Budgeted time: " + activity.getBudgetedTime() + "hours  -  Time spent: " + activity.getRegisteredTime()/2.0 + "hours" + "\n");
            }

            ActivityDate finishingDate = new ActivityDate(0,0);

            for(Activity activity: activityList){
                if(activity.getEndDate() != null){
                    if(activity.getEndDate().getYear()*52 - finishingDate.getYear()*52 + activity.getEndDate().getWeek() - finishingDate.getWeek() > 0){
                        finishingDate = activity.getEndDate();
                    }
                }
            }
            writer.write("Estimated finish week: " + finishingDate.getYear() + "-" + finishingDate.getWeek());
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
