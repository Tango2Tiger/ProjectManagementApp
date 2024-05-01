Feature: User deletes a project.

    Scenario: User deletes a project that exists
        Given an employee is logged in
        And there exists a project with the name "p1"
        When employee deletes the project "p1"
        Then The project "p1" doesn’t exist

    Scenario: User tries to delete a project that doesn't exist
        Given an employee is logged in
        And no project with the name "p1" exists
        When employee deletes the project "p1"
        Then the error message "Project with the name p1 doesn't exist" is received
