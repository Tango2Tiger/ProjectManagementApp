package dtu.projectmanagement.businesslogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Objects.isNull;


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

    /**
     @author s235223
     */
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

    /**
     @author s235223
     */
    public void registerTime(TimeRegistration timeRegistration) throws OperationNotAllowedException {
        if (outsideDates(timeRegistration)) {
            throw new OperationNotAllowedException("Please register time within the runtime of the activity");
        }
        if (!isNull(getSpecificTimeRegistration(timeRegistration.getEmployee(), timeRegistration.getDate()))) {
            throw new OperationNotAllowedException("Only one time registration per activity per employee per day");
        }
        this.registeredTime += timeRegistration.getHalfHours();
        this.timeRegistrations.add(timeRegistration);
    }

    private boolean outsideDates(TimeRegistration timeRegistration) {
        if (isNull(startDate) || isNull(endDate)) {
            return false;
        }
        Calendar date = timeRegistration.getDate();
        int registeredWeek = date.get(Calendar.WEEK_OF_YEAR);
        int registeredYear = date.get(Calendar.YEAR);
        if (startDate.getYear() - registeredYear > 0 || endDate.getYear() - registeredYear < 0) {
            return true;
        }
        if (startDate.getYear() - registeredYear == 0 && startDate.getWeek() - registeredWeek > 0 || endDate.getYear() - registeredYear == 0 && endDate.getWeek() - registeredWeek < 0) {
            return true;
        }
        return false;
    }

    /**
     @author s235223
     */
    public TimeRegistration getSpecificTimeRegistration(Employee employee, Calendar date) {
        for (TimeRegistration timeRegistration : timeRegistrations){
            int n = timeRegistration.getDate().compareTo(date);
            if (timeRegistration.getEmployee().equals(employee)  && timeRegistration.getDate().compareTo(date) == 0) {
                return timeRegistration;
            }
        }
        return null;
    }

    public void editTimeRegistration(Employee employee, int newHalfHours, GregorianCalendar gregorianCalendar) throws OperationNotAllowedException {
        TimeRegistration specificTimeRegistration = getSpecificTimeRegistration(employee, gregorianCalendar);
        if (isNull(specificTimeRegistration)) {
            throw new OperationNotAllowedException("No time registration to edit for that date");
        }
        int diff = newHalfHours - specificTimeRegistration.getHalfHours();
        specificTimeRegistration.setHalfHours(newHalfHours);
        employee.addRegisteredTime(diff);
        this.registeredTime += diff;

    }
}
