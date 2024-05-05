package dtu.projectmanagement.businesslogic;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeRegistration {
    private int halfHours;
    private Calendar date;
    private Employee employee;

    public TimeRegistration(Integer halfHours, int year, int month, int day, Employee employee) throws OperationNotAllowedException {
        if (halfHours < 1) {
            throwNotAllowed("Only positive time registrations allowed");
        }
        if (halfHours > 48) {
            throwNotAllowed("Only 48 half hours in a day");
        }
        this.date = new GregorianCalendar(year, month, day);
        this.halfHours = halfHours;
        this.employee = employee;
    }

    private void throwNotAllowed(String msg) throws OperationNotAllowedException {
        throw new OperationNotAllowedException(msg);
    }

    public int getHalfHours() {
        return halfHours;
    }

    public void setHalfHours(int halfHours) throws OperationNotAllowedException {
        if (halfHours < 1) {
            throwNotAllowed("Only positive time registrations allowed");
        }
        if (halfHours > 48) {
            throwNotAllowed("Only 48 half hours in a day");
        }
        this.halfHours = halfHours;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Calendar getDate() {
        return this.date;
    }
}
