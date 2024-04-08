package dtu.projectmanagement.app;

public class Employee {
    private String initials;
    private String name;
    public Employee (String firstName, String lastName) {
        this.name = firstName + " " + lastName;
        String[] firstNameSplit = firstName.toLowerCase().split("");
        String[] lastNameSplit = lastName.toLowerCase().split("");
        this.initials = firstNameSplit[0] + firstNameSplit[1] + lastNameSplit[0] + lastNameSplit[1];
    }
}
