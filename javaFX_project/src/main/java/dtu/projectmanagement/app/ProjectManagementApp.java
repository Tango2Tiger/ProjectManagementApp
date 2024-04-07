package dtu.projectmanagement.app;

import java.util.ArrayList;

public class ProjectManagementApp {
    private static ArrayList<Employee> employeeList;
    public static Employee loggedIn;
    private static boolean employeeLoggedIn = false;

    public static boolean isEmployeeLoggedIn() {
        return employeeLoggedIn;
    }

    public static void setEmployeeLoggedIn(boolean employeeLoggedIn) {
        ProjectManagementApp.employeeLoggedIn = employeeLoggedIn;
    }

    public static void login(String initials) {
        for (Employee employee : employeeList) {
            if(employee.getInitials().equals(initials)) {
                loggedIn = employee;
                employeeLoggedIn = true;
            }
        }
    }
}
