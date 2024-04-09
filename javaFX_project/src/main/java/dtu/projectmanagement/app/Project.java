package dtu.projectmanagement.app;

public class Project {
    private String name;
    private int projectNumber;

    public Project(String name, int projectNumber){
        this.name = name;
        this.projectNumber = projectNumber;
    }

    public String getName(){
        return this.name;
    }
}
