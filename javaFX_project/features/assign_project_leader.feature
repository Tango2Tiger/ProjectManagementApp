Feature: The user wants to assign a leader to a project

    Scenario: The user succesfully assigns a project leader
        Given the employee is logged in
        And there is an employee with initials "huba"
        And there exists a project with the name "p1"
        When employee sets employee with initials "huba" as new leader of the project "p1"
        Then the employee with initials "huba" is the project leader of the project "p1"

    Scenario: The user tries to assign an employee that doesn’t exist
        Given the employee is logged in
        And there exists a project with the name "p1"
        And there is no employee with initials "mahe" in the system
        When employee sets employee with initials "mahe" as new leader of the project "p1"
        Then the error message "Employee with the initials mahe does not exist" is received