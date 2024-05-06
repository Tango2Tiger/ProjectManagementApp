package example.junit.whitebox;

import dtu.projectmanagement.businesslogic.Employee;
import dtu.projectmanagement.businesslogic.Project;
import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 @author s235221
 */
public class WhiteBoxDeleteEmployee {
    ProjectManagementApp projectManagementApp = new ProjectManagementApp();


    @org.junit.Test
    public void testInputDataSetA() throws OperationNotAllowedException {
        Employee employee1 = new Employee("Jonas", "Grønbeck");
        String errorMessage = "";

        assertFalse(projectManagementApp.getEmployeeList().contains(employee1));
        try {
            projectManagementApp.deleteEmployee(employee1);
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        Assert.assertEquals("Employee does not exist", errorMessage);
    }

    @org.junit.Test
    public void testInputDataSetB() throws OperationNotAllowedException {
        Employee employee1 = new Employee("Jonas", "Grønbeck");
        projectManagementApp.getEmployeeList().add(employee1);
        boolean b = false;
        for (Employee employee : projectManagementApp.getEmployeeList()) {
            if (employee.equals(employee1)) {
                b = true;
            }
        }
        assertTrue(b);
        Project project = new Project("p1");
        assertFalse(project.hasEmployee(employee1));
    }

    @org.junit.Test
    public void testInputDataSetC() throws OperationNotAllowedException {
        Employee employee1 = new Employee("Jonas", "Grønbeck");
        projectManagementApp.getEmployeeList().add(employee1);
        boolean b = false;
        for (Employee employee : projectManagementApp.getEmployeeList()) {
            if (employee.equals(employee1)) {
                b = true;
            }
        }
        assertTrue(b);
        Project project = new Project("p1");
        project.addEmployee(employee1);
        assertTrue(project.hasEmployee(employee1));
    }
}