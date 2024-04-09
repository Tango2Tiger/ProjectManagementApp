Feature: User deletes a project.

    Scenario: User deletes a project that exists
        Given the user is logged in
        And There exists a project with the name "p1"
        When The user deletes the project "p1"
        Then The project "p1" doesn’t exist
