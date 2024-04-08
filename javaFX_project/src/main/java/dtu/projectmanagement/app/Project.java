package src.main.java.dtu.projectmanagement.app;

public class Project {
    private String name;
    private int projectNumber;

    public Project(String name, int number){
        this.name = name;
        this.projectNumber = number;
    }

    public String getName(){
        return this.name;
    }

}
