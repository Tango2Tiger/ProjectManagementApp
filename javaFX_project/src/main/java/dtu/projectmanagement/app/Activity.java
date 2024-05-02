package dtu.projectmanagement.app;

public class Activity {
    private String name;
    private int budgetedTime = 0;
    private int registeredTime = 0;
    private final int MAX_TIME = 5000;
    public Activity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBudgetedTime(Integer budgetedTime) throws OperationNotAllowedException {
        if(budgetedTime >= MAX_TIME) {
            throw new OperationNotAllowedException("Budgeted time must be below " + MAX_TIME + " hours");
        }
        if(budgetedTime < 0) {
            throw new OperationNotAllowedException("Budgeted time must be positive");
        }
        this.budgetedTime = budgetedTime;
    }

    public Integer getBudgetedTime() {
        return budgetedTime;
    }

    public int getRegisteredTime() {
        return registeredTime;
    }

    public void registerTime(int registeredTime) {
        this.registeredTime += registeredTime;
    }
}
