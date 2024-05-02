package dtu.projectmanagement.app;

public class Activity {
    private String name;
    private int budgetedTime;
    private final int MAX_TIME = 5000;
    public Activity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBudgetedTime(Integer budgetedTime) throws OperationNotAllowedException {
        if(budgetedTime >= MAX_TIME) {
            throw new OperationNotAllowedException("Budgetet time must be below " + MAX_TIME + " hours");
        }
        this.budgetedTime = budgetedTime;
    }

    public Integer getBudgetedTime() {
        return budgetedTime;
    }
}
