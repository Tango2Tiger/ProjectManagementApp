Feature: Register absence (Holiday/sickeness)

  Scenario: The employee registers absence successfully
    Given an employee is logged in
    When the employee registers absence from year 2024 month 5 day 8 to year 2024 month 5 day 12
    Then the app has an absence registration with the same start and end date for that employee



