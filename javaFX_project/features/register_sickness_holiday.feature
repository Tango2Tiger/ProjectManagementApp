Feature: Register Sickness or Holiday leave
  Scenario: The employee registers sickness successfully
    Given an employee is logged in
    And the employee has 0 sickness half hours registered
    When the employee registers 3 days of sickness
    Then the employee now has 3 days sickness registered

