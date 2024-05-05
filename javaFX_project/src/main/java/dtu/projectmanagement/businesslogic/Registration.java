package dtu.projectmanagement.businesslogic;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Registration {
    private Calendar date;
    private Employee employee;

    public Registration(int year, int month, int day, Employee employee) {
        this.date = new GregorianCalendar(year, month, day);
        this.employee = employee;
    }

    public Calendar getDate() {
        return date;
    }



    public Employee getEmployee() {
        return employee;
    }

}
