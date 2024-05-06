package example.junit.whitebox;

import dtu.projectmanagement.businesslogic.OperationNotAllowedException;
import dtu.projectmanagement.businesslogic.ProjectManagementApp;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhiteBoxCreateProject {

    ProjectManagementApp projectManagementApp = new ProjectManagementApp();
    @org.junit.Test
    public void testInputDataSetA() throws OperationNotAllowedException{
        String errorMessage = "";
        projectManagementApp.createProject("ERP-projekt");
        assertTrue(projectManagementApp.hasProjectWithName("ERP-projekt"));
        try {
            projectManagementApp.createProject("ERP-projekt");
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        Assert.assertEquals("There is already a project in the app with the given name", errorMessage);
    }

    @org.junit.Test
    public void testInputDataSetB() throws OperationNotAllowedException{
        String errorMessage = "";
        try {
            projectManagementApp.createProject("");
        } catch (OperationNotAllowedException e) {
            errorMessage = e.getMessage();
        }
        Assert.assertEquals("Project must have a name", errorMessage);
    }

    @org.junit.Test
    public void testInputDataSetC() throws OperationNotAllowedException{
        assertTrue(!(projectManagementApp.hasProjectWithName("ERP-projekt")));
        assertTrue(!("".equals("ERP-projekt")));
        projectManagementApp.createProject("ERP-projekt");
        assertTrue(projectManagementApp.hasProjectWithName("ERP-projekt"));
    }

}