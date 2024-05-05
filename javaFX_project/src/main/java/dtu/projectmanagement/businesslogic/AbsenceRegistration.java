package dtu.projectmanagement.businesslogic;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AbsenceRegistration extends Registration{
    private Calendar endDate;
    public AbsenceRegistration(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay, Employee employee) {
        super(startYear, startMonth, startDay, employee);
        this.endDate = new GregorianCalendar(endYear, endMonth, endDay);
    }

    public int getStartYear() {
        Calendar startDate = super.getDate();
        return startDate.get(Calendar.YEAR);
    }
    public int getStartMonth() {
        Calendar startDate = super.getDate();
        return startDate.get(Calendar.MONTH);
    }
    public int getStartDay() {
        Calendar startDate = super.getDate();
        return startDate.get(Calendar.DAY_OF_MONTH);
    }
    public int getEndYear() {
        return endDate.get(Calendar.YEAR);
    }
    public int getEndMonth() {
        return endDate.get(Calendar.MONTH);
    }
    public int getEndDay() {
        return endDate.get(Calendar.DAY_OF_MONTH);
    }
}
