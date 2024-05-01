Feature: An employee wants to create a new project

Scenario: Employee creates project
  Given an employee is logged in
  And there is no project with name "project1"
  When the employee creates the project with name "project1"
  Then there is a project with name "project1"

  Scenario: There is already a project with the given name
    Given an employee is logged in
    And there exists a project with the name "project1"
    When the employee creates the project with name "project1"
    Then the error message "There is already a project in the app with the given name" is received
