package dtu.projectmanagement.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeRegistration {
    private int halfHours;
    private Calendar date;
    private Employee employee;

    public TimeRegistration(Integer halfHours, int year, int month, int day, Employee employee) throws OperationNotAllowedException {
        if (halfHours < 1) {
            throw new OperationNotAllowedException("Only positive time registrations allowed");
        }
        this.date = new GregorianCalendar(year, month, day);
        this.halfHours = halfHours;
        this.employee = employee;
    }

    public int getHalfHours() {
        return halfHours;
    }

    public void setHalfHours(int halfHours) {
        this.halfHours = halfHours;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Calendar getDate() {
        return this.date;
    }
}
