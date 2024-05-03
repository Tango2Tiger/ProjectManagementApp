package dtu.projectmanagement.app;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity {
    private String name;
    private int budgetedTime = 0;
    private int registeredTime = 0;
    private ActivityDate startDate;
    private ActivityDate endDate;
    private ArrayList<TimeRegistration> timeRegistrations = new ArrayList<>();

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


    public ActivityDate getStartDate() {
        return startDate;
    }

    public void setStartDate(ActivityDate startDate) {
        this.startDate = startDate;
    }

    public ActivityDate getEndDate() {
        return endDate;
    }

    public void setEndDate(ActivityDate endDate) {
        this.endDate = endDate;
    }

    public int getRegisteredTime() {
        return registeredTime;
    }

    public void registerTime(TimeRegistration timeRegistration) {
        this.registeredTime += timeRegistration.getHalfHours();
        this.timeRegistrations.add(timeRegistration);
    }

    public TimeRegistration getSpecificTimeRegistration(Employee employee, Calendar date) {
        for (TimeRegistration timeRegistration : timeRegistrations){
            if (timeRegistration.getEmployee().equals(employee)  && timeRegistration.getDate().equals(date)) {
                return timeRegistration;
            }
        }
        return null;
    }
}
