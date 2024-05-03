Feature: Employee deletes an activity

    Scenario: Employee deletes activity successfully
        Given there exists a project with the name "p1"
        And the project "p1" has an activity with the name "a1"
        And there is an employee with initials "huba"
        When employee deletes the activity
        Then the activity is not on the activitylist of the project
        And the activity is not on the employee's activitylist
