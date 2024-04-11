package dtu.projectmanagement.app;

public class Project {
    private String name;
    private int projectNumber;

    private Employee projectLeader;

    public Project(String name, int projectNumber){
        this.name = name;
        this.setProjectNumber(projectNumber);
    }

    public String getName(){
        return this.name;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public Employee getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Employee projectLeader) {
        this.projectLeader = projectLeader;
    }
}
