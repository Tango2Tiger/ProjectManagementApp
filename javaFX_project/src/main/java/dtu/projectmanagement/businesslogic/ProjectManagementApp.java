package dtu.projectmanagement.businesslogic;


import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class ProjectManagementApp {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private Employee loggedIn;
    private boolean employeeLoggedIn = false;
    private ArrayList<AbsenceRegistration> absenceRegistrations = new ArrayList<>();
    private int projectCounter = 1;
    private ArrayList<Project> projectList = new ArrayList<>();

    public boolean isEmployeeLoggedIn() {
        return employeeLoggedIn;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     @author s235223
     */
    public void login(String initials) throws OperationNotAllowedException{
        for (Employee employee : employeeList) {
            if(employee.getInitials().equals(initials)) {
                loggedIn = employee;
                employeeLoggedIn = true;
                return;
            }
        } throw new OperationNotAllowedException("employee with initials " + initials + " is not in the system");
    }

    public Employee getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Employee loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     @author s235238
     */
    public boolean hasProjectWithName(String name){
        for(Project p : projectList){
            if(p.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     @author s230607
     */
    public ArrayList<Project> getProjectList(){
        return this.projectList;
    }

    /**
     @author s230607
     */
    public void addProjectToList(Project project){
        this.projectList.add(project);
    }

    /**
     @author s235221
     */
    public void deleteProject(String name) throws OperationNotAllowedException{
        if(hasProjectWithName(name)){
            projectList.remove(getProjectWithName(name));
        } else {
            throw new OperationNotAllowedException("Project with the name " + name + " doesn't exist");
        }
    }

    /**
     @author s235223
     */
    public boolean hasEmployeeWithInitials(String initials) {
        for (Employee employee : employeeList) {
            if (employee.getInitials().equals(initials)) {
                return true;
            }
        }
        return false;
    }

    public void addEmployeeToEmployeeList(Employee employee) {
        employeeList.add(employee);
    }
    /**
     @author s235223
     */

    public void registerEmployee(String firstName, String lastName) throws OperationNotAllowedException {
        if (hasEmployeeWithName(firstName, lastName)){                                                      // 1
            throw new OperationNotAllowedException("Employee is already registered");                       // 2
        }
        if (lastName.length() < 2 || firstName.length() < 2) {                                              // 3
            throw new OperationNotAllowedException("Employee names must be two or more characters long");   // 4
        }
        Employee employee = new Employee(firstName, lastName);                                              // 5
        employee.setInitials();                                                                             // 6
        addEmployeeToEmployeeList(employee);                                                                // 7
    }

    /**
     @author s235233
     */
    public boolean hasEmployeeWithName(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                return true;
            }
        }
        return false;
    }

    /**
     @author s230607
     */
    public Employee getEmployeeWithInitials(String initials) throws OperationNotAllowedException{
        for(Employee employee: employeeList){
            if(employee.getInitials().equals(initials)){
                return employee;
            }
        } throw new OperationNotAllowedException("Employee with the initials " + initials + " does not exist");
    }

    /**
     @author s230607
     */
    public Project getProjectWithName(String name){
        for(Project project: projectList){
            if(project.getName().equals(name)){
                return project;
            }
        }
        return null;
    }

    /**
     @author s230607
     */
    public void assignProjectLeader(String projectName, String initials) throws OperationNotAllowedException{
        getProjectWithName(projectName).setProjectLeader(getEmployeeWithInitials(initials));
    }

    /**
     @author s230607
     @author s235238
     */
    public void createProject(String name) throws OperationNotAllowedException{
        if(hasProjectWithName(name)){
            throw new OperationNotAllowedException("There is already a project in the app with the given name");
        }
        if(name.isEmpty()){
            throw new OperationNotAllowedException("Project must have a name");
        }
        var project = new Project(name);
        getProjectList().add(project);
        project.setProjectNumber(projectCounter);
        projectCounter ++;
    }

    /**
     @author s235233
     */
    public List<String> getProjectNameList() {
        return projectList.stream().map(Project::getName).collect(Collectors.toList());
    }

    public List<String> getEmployeeInitialsList() {
        return employeeList.stream().map(Employee::getInitials).collect(Collectors.toList());
    }

    /**
     @author s230607
     */
    public void createActivity(Project p1, String name) throws OperationNotAllowedException{
        if(p1.hasActivityWithName(name)){
            throw new OperationNotAllowedException("The project \'" + p1.getName() + "\' already has an activity with the name \'" + name + "\'");
        }else {
            p1.createActivity(name);
        }
    }

    /**
     @author s235221
     */
    public Activity getActivityFromProject(String projectName, String activityName) {
        return getProjectWithName(projectName).getActivityWithName(activityName);
    }

    public List<String> getActivityListFromProject(Project project) {
        return project.getActivityList().stream().map(Activity::getName).collect(Collectors.toList());
    }

    /**
     @author s235233
     */
    public boolean projectHasEmployee(Project p1, Employee e1){
        if(p1.hasEmployee(e1)){
            return true;
        }
        return false;
    }

    /**
     @author s230607
     */
    public void addEmployeeToProject(Project p1, Employee e1){
        p1.addEmployee(e1);
    }

    /**
     @author s230607
     */
    public void setStartEndActivity(int startYear, int startWeek, int endYear, int endWeek, String projectName, String activityName) throws OperationNotAllowedException{
        if(endYear*52 - startYear*52 + endWeek - startWeek < 0){
            throw new OperationNotAllowedException("End date cannot be set before start date.");
        } else{
            getProjectWithName(projectName).getActivityWithName(activityName).setStartDate(new ActivityDate(startYear, startWeek));
            getProjectWithName(projectName).getActivityWithName(activityName).setEndDate(new ActivityDate(endYear, endWeek));
        }
    }

    /**
     @author s235223
     */
    public void registerTime(Activity activity, Integer halfHours, int year, int month, int day) throws OperationNotAllowedException {
        TimeRegistration timeRegistration = new TimeRegistration(halfHours, year, month, day, loggedIn);
        activity.registerTime(timeRegistration);
        loggedIn.registerTime(halfHours);
    }

    /**
     @author s230607
     */
    public void deleteActivity(String projectName, String activityName){
        getProjectWithName(projectName).deleteActivity(activityName);
    }
    /**
     @author s235221
     */
    public void assignEmployeeToActivity(Employee employee, Activity activity) throws OperationNotAllowedException {
        employee.assignToActivity(activity);
    }

    /**
     @author s230607
     */
    public boolean employeeHasActivity(Employee employee, Activity activity){
        return employee.hasActivity(activity);
    }

    /**
     @author s235223
     */
    public void editTimeRegistrationForActivity(Employee employee, Activity activity, int halfHours, int year, int month, int day) throws OperationNotAllowedException {
        GregorianCalendar date = new GregorianCalendar(year, month, day);
        activity.editTimeRegistration(employee, halfHours, date);
    }

    /**
     @author s235223
     */
    public ArrayList<String> getEmployeeNameListFromProject(Project project){
        return project.getEmployeeInitialList();
    }

    /**
     @author s230607
     @author s235221
     */
    public void downloadProjectReport(String projectName, Pane pane){
        try{
            Window stage = pane.getScene().getWindow();
            FileChooser fc = new FileChooser();

            fc.setInitialFileName("status_report_" + projectName + ".txt");
            fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Downloads"));

            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
            fc.getExtensionFilters().add(filter);

            File file = fc.showSaveDialog(stage);
            getProjectWithName(projectName).writeReport(file);
        } catch(NullPointerException e){}

    }

    /**
     @author s235238
     */
    public void deleteEmployee(Employee employee)throws OperationNotAllowedException {
        if (!hasEmployee(employee)){                                                        // 1
            throw new OperationNotAllowedException("Employee does not exist");
        }
        for (Project project : projectList){                                                // 2
            if (project.hasEmployee(employee)){                                             // 3
                project.getEmployeeList().remove(employee);
            }
        }
        employeeList.remove(employee);
    }

    /**
     @author s235238
     */
    private boolean hasEmployee(Employee employee) {
        for (Employee em : getEmployeeList()) {
            if (em.equals(employee)) {
                return true;
            }
        }
        return false;
    }

        /**
         @author s235223
         */
        public void logout () {
            this.setLoggedIn(null);
        }

        /**
         @author s235223
         */
        public void registerAbsence ( int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) throws
        OperationNotAllowedException {
            AbsenceRegistration absence = new AbsenceRegistration(startYear, startMonth, startDay, endYear, endMonth, endDay, loggedIn);
            absenceRegistrations.add(absence);
        }

        /**
         @author s235223
         */
        public boolean hasAbsence ( int startYear, int startMonth, int startDay, int endYear, int endMonth,
        int endDay, Employee employee){
            for (AbsenceRegistration absence : absenceRegistrations) {
                if (employee.equals(absence.getEmployee())
                        && absence.getStartYear() == startYear && absence.getStartMonth() == startMonth && absence.getStartDay() == startDay
                        && absence.getEndYear() == endYear && absence.getEndMonth() == endMonth && absence.getEndDay() == endDay) {
                    return true;
                }
            }
            return false;
        }

        /**
         @author s235223
         */
        public AbsenceRegistration getSpecificAbsence ( int startYear, int startMonth, int startDay, int endYear,
        int endMonth, int endDay, Employee employee){
            for (AbsenceRegistration absence : absenceRegistrations) {
                if (employee.equals(absence.getEmployee())
                        && absence.getStartYear() == startYear && absence.getStartMonth() == startMonth && absence.getStartDay() == startDay
                        && absence.getEndYear() == endYear && absence.getEndMonth() == endMonth && absence.getEndDay() == endDay) {
                    return absence;
                }
            }
            return null;
        }

        /**
         @author s235223
         */
        public void deleteAbsence ( int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) throws
                OperationNotAllowedException {
            AbsenceRegistration absenceRegistration = getSpecificAbsence(startYear, startMonth, startDay, endYear, endMonth, endDay, loggedIn);
            if (isNull(absenceRegistration)) {
                throw new OperationNotAllowedException("Absence registration does not exist");
            }
            absenceRegistrations.remove(getSpecificAbsence(startYear, startMonth, startDay, endYear, endMonth, endDay, loggedIn));
        }

    /**
     @author s235233
     */
    public ArrayList<AbsenceRegistration> getAbsencesForLoggedIn () {
        ArrayList<AbsenceRegistration> loggedInAbsences = new ArrayList<AbsenceRegistration>();
        for (AbsenceRegistration absenceRegistration : absenceRegistrations) {
            if (absenceRegistration.getEmployee().equals(loggedIn)) {
                loggedInAbsences.add(absenceRegistration);
            }
        }
        return loggedInAbsences;
    }
}





