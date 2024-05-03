package dtu.projectmanagement.app;

import java.util.ArrayList;

public class Employee {
    private String initials;
    private String firstName;
    private String lastName;
    private int registeredTime;
    private ArrayList<Activity> activityList = new ArrayList<>();
    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials() {
        String[] firstNameSplit = firstName.toLowerCase().split("");
        String[] lastNameSplit = lastName.toLowerCase().split("");
        this.initials = firstNameSplit[0] + firstNameSplit[1] + lastNameSplit[0] + lastNameSplit[1];
    }

    public void registerTime(int halfhours){
        this.registeredTime += halfhours;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRegisteredTime() {return registeredTime;}

    public void removeActivity(Activity activity){
        this.activityList.remove(activity);
    }

    public void addActivity(Activity activity){
        this.activityList.add(activity);
    }

    public ArrayList<Activity> getActivityList(){
        return this.activityList;
    }

    public boolean hasActivity(Activity activity){
        for(Activity ele: activityList){
            if(ele == activity){
                return true;
            }
        }
        return false;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }
}
