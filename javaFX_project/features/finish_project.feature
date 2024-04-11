Feature: User deletes a project.

    Scenario: User deletes a project that exists
        Given the user is logged in
        And There exists a project with the name "p1"
        When user deletes the project "p1"
        Then The project "p1" doesn’t exist


    Scenario: User tries to delete a project that doesn't exist
        Given the user is logged in
        And no project with the name "p1" exists
        When user deletes the project "p1"
        #Then the error message "Project with the name p1 doesn't exist" is received
