package dtu.projectmanagement.app;

public class Employee {
    private String initials;
    private String firstName;
    private String lastName;
    private int registeredTime;
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

    public void addTime(int halfhours){
        this.registeredTime += halfhours;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRegisteredTime() {return registeredTime;}
}
