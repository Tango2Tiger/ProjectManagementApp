package example.junit.unit_tests;

import dtu.projectmanagement.businesslogic.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class unit_tests_UI_methods {
    ProjectManagementApp projectManagementApp;
    @org.junit.Test
    public void getFullNameTest() throws OperationNotAllowedException {
        String firstName = "Hubert";
        String lastName = "Baumeister";
        Employee employee = new Employee(firstName, lastName);
        assertEquals(employee.getFullName(), firstName + " " + lastName);
    }
    @org.junit.Test
    public void returnActivitylistTest() throws OperationNotAllowedException {
        Activity activity1 = new Activity("a1");
        Activity activity2 = new Activity("a2");
        Activity activity3 = new Activity("a3");
        ArrayList<Activity> activityList = new ArrayList<Activity>();
        activityList.add(activity1);
        activityList.add(activity2);
        activityList.add(activity3);
        Employee employee = new Employee("Hubert", "Baumeister");
        employee.assignToActivity(activity1);
        employee.assignToActivity(activity2);
        employee.assignToActivity(activity3);
        assertTrue(activityList.equals(employee.getActivityList()));
    }

    @org.junit.Test
    public void projectGetActivityWithNameTest() {
        Project project = new Project("p1");
        assertTrue(project.getActivityList().isEmpty());
        assertTrue(project.getActivityWithName("p") == null);
    }
    @org.junit.Test
    public void projectGetActivityNameListTest() {
        Project project = new Project("p1");
        ArrayList<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        Activity activity1 = new Activity(list.get(0));
        Activity activity2 = new Activity(list.get(1));
        Activity activity3 = new Activity(list.get(2));
        project.getActivityList().add(activity1);
        project.getActivityList().add(activity2);
        project.getActivityList().add(activity3);
        assertEquals(project.getActivityNameList(), list);
    }

    @org.junit.Test
    public void projectGetEmployeeNamelistTest() {
        projectManagementApp = new ProjectManagementApp();
        Employee employee1 = new Employee("Hubert", "Baumeister");
        employee1.setInitials();
        Employee employee2 = new Employee("Bo", "Skov");
        employee2.setInitials();
        Project project = new Project("p1");
        project.addEmployee(employee1);
        project.addEmployee(employee2);
        ArrayList<String> list = new ArrayList<>();
        list.add(employee1.getInitials());
        list.add(employee2.getInitials());
        projectManagementApp.getEmployeeList().add(employee1);
        projectManagementApp.getEmployeeList().add(employee2);
        projectManagementApp.getProjectList().add(project);
        assertEquals(projectManagementApp.getEmployeeNameListFromProject(project), list);
    }

    @org.junit.Test
    public void projectGetProjectNumber() throws OperationNotAllowedException {
        projectManagementApp = new ProjectManagementApp();
        assertTrue(projectManagementApp.getProjectList().isEmpty());
        projectManagementApp.createProject("p1");
        assertEquals(projectManagementApp.getProjectWithName("p1").getProjectNumber(), 24001);
    }

    @org.junit.Test
    public  void getAbsencesForLoggedInTest() throws OperationNotAllowedException {
        projectManagementApp = new ProjectManagementApp();
        projectManagementApp.registerEmployee("Hubert", "Baumeister");
        projectManagementApp.registerEmployee("bob", "thorn");
        projectManagementApp.login("huba");
        int startYear = 2024;
        int startMonth = 1;
        int startDay = 1;
        int endYear = 2025;
        int endMonth = 1;
        int endDay = 1;
        projectManagementApp.registerAbsence(startYear, startMonth, startDay, endYear, endMonth, endDay);
        projectManagementApp.logout();
        projectManagementApp.login("both");
        assertTrue(projectManagementApp.getAbsencesForLoggedIn().isEmpty());
        projectManagementApp.logout();
        projectManagementApp.login("huba");
        AbsenceRegistration aR = projectManagementApp.getAbsencesForLoggedIn().get(0);
        assertTrue(aR.getStartYear() == startYear && aR.getStartMonth() == startMonth && aR.getStartDay() == startDay
                            &&   aR.getEndYear() == endYear && aR.getEndMonth() == endMonth && aR.getEndDay() == endDay);
    }
    @org.junit.Test
    public  void getEmployeeInitialsListTest() {
        projectManagementApp = new ProjectManagementApp();
        Employee employee = new Employee("Bob", "sko");
        Employee employee1 = new Employee("Brian", "Mop");
        Employee employee2 = new Employee("Jop", "Mop");
        projectManagementApp.getEmployeeList().add(employee);
        projectManagementApp.getEmployeeList().add(employee1);
        projectManagementApp.getEmployeeList().add(employee2);
        ArrayList<String> list = new ArrayList<>();
        employee.setInitials();
        employee1.setInitials();
        employee2.setInitials();
        list.add(employee.getInitials());
        list.add(employee1.getInitials());
        list.add(employee2.getInitials());
        assertEquals(list, projectManagementApp.getEmployeeInitialsList());
    }
    @org.junit.Test
    public void getActivityListFromProjectTest() throws OperationNotAllowedException {
        projectManagementApp = new ProjectManagementApp();
        Project project = new Project("p1");
        projectManagementApp.addProjectToList(project);
        ArrayList<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        Activity activity1 = new Activity(list.get(0));
        Activity activity2 = new Activity(list.get(1));
        Activity activity3 = new Activity(list.get(2));
        projectManagementApp.getProjectWithName("p1").getActivityList().add(activity1);
        projectManagementApp.getProjectWithName("p1").getActivityList().add(activity2);
        projectManagementApp.getProjectWithName("p1").getActivityList().add(activity3);
        assertEquals(projectManagementApp.getActivityListFromProject(project), list);
    }

    @org.junit.Test
    public void getProjectNameListTest() throws OperationNotAllowedException {
        projectManagementApp = new ProjectManagementApp();
        ArrayList<String> list = new ArrayList<>();
        list.add("p1");
        list.add("p2");
        list.add("p3");
        projectManagementApp.createProject(list.get(0));
        projectManagementApp.createProject(list.get(1));
        projectManagementApp.createProject(list.get(2));
        assertEquals(projectManagementApp.getProjectNameList(), list);
    }


}
