package dtu.projectmanagement.app;

public class ActivityDate {
    private int year;
    private int week;
    public ActivityDate(int year, int week){
        this.setYear(year);
        this.setWeek(week);

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
