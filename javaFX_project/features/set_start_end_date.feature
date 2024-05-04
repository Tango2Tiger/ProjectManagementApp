Feature: Set the start and end date for an activity

  Scenario: Succesfully set a start and end date for an activity
    Given there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee sets a start year 24, start week 50, end year 25 and end week 5 for the activity
    Then the activity has a start date with year 24 and week 50
    And the activity has an end date with year 25 and week 5

  Scenario: Employee tries to set an end date before a start date
    Given there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee sets a start year 25, start week 8, end year 24 and end week 46 for the activity
    Then the error message "End date cannot be set before start date." is received