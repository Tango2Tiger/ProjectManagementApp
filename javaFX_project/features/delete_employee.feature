Feature: Employee deletes an employee

  Scenario: Employee deletes employee successfully
    Given there is an employee with initials "huba"
    And there exists a project with the name "p1"
    When employee deletes the employee with name "huba"
    Then the employee is not on the employeeList
    And the employee is not on the projects employeeList
