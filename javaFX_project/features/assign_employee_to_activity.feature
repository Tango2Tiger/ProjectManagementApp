Feature: The employee wants to assign an employee, possibly him/herself, to an activity

  Scenario: The employee assigns employee to activity
    Given there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    And an employee is logged in
    When the employee gets assigned to the activity "a1"
    Then the employee is assigned to the activity "a1"