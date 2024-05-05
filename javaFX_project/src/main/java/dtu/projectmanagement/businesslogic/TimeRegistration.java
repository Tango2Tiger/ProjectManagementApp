package dtu.projectmanagement.businesslogic;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 @author s235223
 */
public class TimeRegistration extends Registration{
    private int halfHours;


    public TimeRegistration(Integer halfHours, int year, int month, int day, Employee employee) throws OperationNotAllowedException {
        super(year, month, day, employee);
        checkHalfHours(halfHours);
        this.halfHours = halfHours;

    }



    public int getHalfHours() {
        return halfHours;
    }

    public void setHalfHours(int halfHours) throws OperationNotAllowedException {
        checkHalfHours(halfHours);
        this.halfHours = halfHours;
    }

    public Employee getEmployee() {
        return super.getEmployee();
    }

    public Calendar getDate() {
        return super.getDate();
    }
    private void checkHalfHours(Integer halfHours) throws OperationNotAllowedException {
        if (halfHours < 1) {
            throw new OperationNotAllowedException("Only positive time registrations allowed");
        }
        if (halfHours > 48) {
            throw new OperationNotAllowedException("Only 48 half hours in a day");
        }
    }
}
