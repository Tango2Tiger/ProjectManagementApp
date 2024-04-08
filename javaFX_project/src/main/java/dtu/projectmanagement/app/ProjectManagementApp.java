package dtu.projectmanagement.app;

import src.main.java.dtu.projectmanagement.app.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectManagementApp {
    public Employee loggedIn;

    public static List<Project> projectList = new ArrayList<Project>();
    private static boolean employeeLoggedIn = false;

    public static boolean isEmployeeLoggedIn() {
        return employeeLoggedIn;
    }

    public static void setEmployeeLoggedIn(boolean employeeLoggedIn) {
        ProjectManagementApp.employeeLoggedIn = employeeLoggedIn;
    }
}
