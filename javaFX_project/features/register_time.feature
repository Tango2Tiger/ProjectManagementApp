Feature: Time is registered

  Scenario: Employee succesfully registers time on an activity
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    And the employee has 0 half hours registered
    And the activity has 0 half hours registered
    When the employee registers 25 half hours on the activity
    Then the employee now has 25 half hours registered
    And the activity now has 25 half hours registered

