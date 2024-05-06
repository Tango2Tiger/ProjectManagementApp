package example.junit.whitebox;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhiteBoxRegisterEmployee {


    @org.junit.Test
    public void testInputDataSetA() throws OperationNotAllowedException {
        String errorMessage = "";
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        projectManagementApp.registerEmployee("Lars", "Bo");
        assertTrue(projectManagementApp.hasEmployeeWithName("Lars", "Bo"));
        try {
            projectManagementApp.registerEmployee("Lars", "Bo");
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Employee is already registered", errorMessage);


    }
    @org.junit.Test
    public void testInputDataSetB() {
        String errorMessage = "";
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        assertTrue(projectManagementApp.getEmployeeList().isEmpty());
        try {
            projectManagementApp.registerEmployee("Lars", "B");
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        assertEquals("Employee names must be two or more characters long", errorMessage);
    }
    @org.junit.Test
    public void testInputDataSetC() throws OperationNotAllowedException {
        ProjectManagementApp projectManagementApp = new ProjectManagementApp();
        assertTrue(projectManagementApp.getEmployeeList().isEmpty());
        projectManagementApp.registerEmployee("Lars", "Bo");
        assertTrue(projectManagementApp.hasEmployeeWithName("Lars", "Bo"));
    }

}
