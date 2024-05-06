package example.junit.whitebox;

import dtu.projectmanagement.businesslogic.ActivityDate;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 @author s230607
 */
public class WhiteBoxSetStartEndActivity {

    @org.junit.Test
    public void testSet1() throws OperationNotAllowedException {
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.createProject("p1");
        projectManagementApp.createActivity(projectManagementApp.getProjectWithName("p1"), "a1");
        ActivityDate startDate = new ActivityDate(2024, 25);
        ActivityDate endDate = new ActivityDate(2024, 35);
        projectManagementApp.setStartEndActivity(startDate.getYear(), startDate.getWeek(), endDate.getYear(), endDate.getWeek(), "p1", "a1");

        assertTrue(projectManagementApp.getActivityFromProject("p1", "a1").getStartDate().getYear() == startDate.getYear());
        assertTrue(projectManagementApp.getActivityFromProject("p1", "a1").getStartDate().getWeek() == startDate.getWeek());
        assertTrue(projectManagementApp.getActivityFromProject("p1", "a1").getEndDate().getYear() == endDate.getYear());
        assertTrue(projectManagementApp.getActivityFromProject("p1", "a1").getEndDate().getWeek() == endDate.getWeek());
    }

    @org.junit.Test
    public void testSet2() throws OperationNotAllowedException {
        String errorMessage = "";
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.createProject("p1");
        projectManagementApp.createActivity(projectManagementApp.getProjectWithName("p1"), "act1");
        ActivityDate startDate = new ActivityDate(2024, 35);
        ActivityDate endDate = new ActivityDate(2024, 25);
        try{
            projectManagementApp.setStartEndActivity(startDate.getYear(), startDate.getWeek(), endDate.getYear(), endDate.getWeek(), "p1", "a1");
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        assertEquals(errorMessage,"End date cannot be set before start date.");
    }
}

