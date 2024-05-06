Feature: Employee deletes an activity

    Scenario: Employee deletes activity successfully
        Given there exists a project with the name "p1"
        And the project "p1" has an activity with the name "a1"
        And there is an employee with initials "huba" in the system
        And the employee gets assigned to the project
        And the employee gets assigned to the activity "a1"
        When employee deletes the activity
        Then the activity is not on the activitylist of the project
        And the activity is not on the employee's activitylist


    Scenario: Employee tries to delete activity that doesnt exist
        Given there exists a project with the name "p1"
        And there exists an activity with the name "a1"
        And an employee is logged in
        And the project "p1" has no activity with the name "a1"
        And the employee gets assigned to the project
        And the employee gets assigned to the activity "a1"
        When employee deletes the activity with name "a1"
        Then the activity with name "a1" is not on the activitylist of the project
        And the activity is not on the employee's activitylist
