package example.cucumber;

import dtu.projectmanagement.businesslogic.Project;

public class ProjectHolder {
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
