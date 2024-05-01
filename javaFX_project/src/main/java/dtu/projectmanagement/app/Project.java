package dtu.projectmanagement.app;

import java.util.ArrayList;

public class Project {
    private String name;
    private int projectNumber;

    private Employee projectLeader;
    private ArrayList<Activity> activityList = new ArrayList<>();

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
}
