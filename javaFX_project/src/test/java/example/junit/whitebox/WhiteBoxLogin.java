package example.junit.whitebox;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;

import static org.junit.Assert.*;


public class WhiteBoxLogin {


    @org.junit.Test
    public void testInputDataSetA() throws OperationNotAllowedException{
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.registerEmployee("Lars", "Bobber");
        projectManagementApp.login("labo");
        assertTrue(projectManagementApp.isEmployeeLoggedIn());
        assertEquals(projectManagementApp.getLoggedIn().getInitials(), "labo");
    }

    @org.junit.Test
    public void testInputDataSetB() {
        String errorMessage = "";
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        assertFalse(projectManagementApp.hasEmployeeWithInitials("labo"));
        try {
            projectManagementApp.login("labo");
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        assertEquals("employee with initials labo is not in the system", errorMessage);
    }
}