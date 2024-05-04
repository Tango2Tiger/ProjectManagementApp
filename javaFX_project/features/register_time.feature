Feature: An employee who is logged in registers time

  Scenario: Employee successfully registers time on an activity
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    And the employee has 0 half hours registered
    And the activity has 0 half hours registered
    When the employee registers 25 half hours for the year 2024, month 8, and day 9
    Then the employee now has 25 half hours registered
    And the activity now has 25 half hours registered from the employee on the date 2024, 8, 9

  Scenario: Employee registers a negative amount of time
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee registers -6 half hours for the year 2024, month 8, and day 9
    Then the error message "Only positive time registrations allowed" is received

  Scenario: Employee registers time outside activitys planned runtime
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee sets a start year 2024, start week 23, end year 2025 and end week 24 for the activity
    And the employee registers 5 half hours for a day outside of the activity date
    Then the error message "Please register time within the runtime of the activity" is received

  Scenario: Employee edits wrongly submitted time sheet
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee registers 25 half hours for the year 2024, month 8, and day 9
    And the employee edits the time registration for the year 2024, month 8, and day 9 to be 20 half hours
    Then the employee now has 20 half hours registered
    And the activity now has 20 half hours registered from the employee on the date 2024, 8, 9


