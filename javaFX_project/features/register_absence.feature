Feature: Employee registers absence (Holiday/sickeness)

  Scenario: The employee registers absence successfully
    Given an employee is logged in
    When the employee registers absence from year 2024 month 5 day 8 to year 2024 month 5 day 12
    Then the app has an absence registration with the same start and end date for that employee


  Scenario: The employee registers absence with end date before startdate
    Given an employee is logged in
    When the employee registers absence from year 2024 month 5 day 8 to year 2024 month 5 day 5
    Then the error message "Start of absence must be before end of absence" is received

  Scenario: The employee deletes an absence registration
    Given an employee is logged in
    And the employee registers absence from year 2024 month 5 day 8 to year 2024 month 5 day 12
    When the employee deletes the absence registration
    Then the app has no absence registration with the same start and end date for that employee


  Scenario: The employee deletes an absence registration for wrong date
    Given an employee is logged in
    And the employee registers absence from year 2024 month 5 day 8 to year 2024 month 5 day 12
    When the employee tries to the absence registration from year 2024 month 5 day 8 to year 2024 month 5 day 19
    Then the error message "Absence registration does not exist" is received