Feature: The employee wants to assign an employee, possibly him/herself, to a project

  Scenario: The employee assigns employee to project
    Given an employee is logged in
    And there exists a project with the name "p1"
    When the employee gets assigned to the project
    Then the employee is assigned to the project
