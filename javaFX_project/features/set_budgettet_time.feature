Feature: Set budgeted for activity

  Scenario: Succesfully set budgeted time for an activity
      Given there exists a project with the name "p1"
      And the project "p1" has an activity with the name "a1"
      When The employee sets the budgetet time for the activity belonging to the project to 100 hours
      Then The activity has the budgetet time 100 hours

  Scenario: Set too large budgeted time
    Given there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When The employee sets the budgetet time for the activity belonging to the project to 5000 hours
    Then the error message "Budgeted time must be below 5000 hours" is received

  Scenario: Set negative too large budgeted time
    Given there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When The employee sets the budgetet time for the activity belonging to the project to -100 hours
    Then the error message "Budgeted time must be positive" is received