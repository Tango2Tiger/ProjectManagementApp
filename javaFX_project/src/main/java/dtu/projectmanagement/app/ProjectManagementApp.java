package dtu.projectmanagement.app;

public class ProjectManagementApp {
    public Employee loggedIn;
    private static boolean employeeLoggedIn = false;

    public static boolean isEmployeeLoggedIn() {
        return employeeLoggedIn;
    }

    public static void setEmployeeLoggedIn(boolean employeeLoggedIn) {
        ProjectManagementApp.employeeLoggedIn = employeeLoggedIn;
    }

    public static void login(String initials) {

    }
}
