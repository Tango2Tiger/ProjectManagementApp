Feature: The employee wants to assign an employee, possibly him/herself, to a project

  Scenario: The employee assigns employee to project
    Given the employee is logged in
    And there exists a project with the name "project1"
    And there is an employee with initials "huba"
    When the employee gets assigned to the project
    Then the employee is assigned to the project



