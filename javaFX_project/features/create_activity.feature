Feature: Employee creates a activity.

    Scenario: Employee creates an activity succesfully
        Given there exists a project with the name "p1"
        And the project "p1" has no activity with the name "a1"
        When the employee creates an activity with the name "a1"
        #Then there is an activity with the name "a1"
