Feature: Register Sickness or Holiday leave
  Scenario: The employee registers sickness successfully
    Given an employee is logged in
    And the employee has 0 sickness half hours registered
    When the employee registers 16 half hours on sickness
    Then the employee now has 16 half hours sickness registered

