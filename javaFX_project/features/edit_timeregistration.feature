Feature: Employee edits time registration

  Scenario: Employee edits wrongly submitted time registration
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee registers 25 half hours for the year 2024, month 8, and day 9 on the activity
    And the employee edits the time registration for the year 2024, month 8, and day 9 to be 20 half hours
    Then the employee now has 20 half hours registered
    And the activity now has 20 half hours registered from the employee on the date 2024, 8, 9

  Scenario: Employee tries to edit wrongly submitted time sheet, for date that hasnt been submitted
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee registers 25 half hours for the year 2024, month 8, and day 9 on the activity
    And the employee edits the time registration for the year 2024, month 8, and day 10 to be 20 half hours
    Then the error message "No time registration to edit for that date" is received

  Scenario: Employee tries to edit wrongly submitted time sheet, to negative time
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee registers 25 half hours for the year 2024, month 8, and day 9 on the activity
    And the employee edits the time registration for the year 2024, month 8, and day 9 to be -9 half hours
    Then the error message "Only positive time registrations allowed" is received

  Scenario: Employee tries to edit wrongly submitted time sheet, to more than 48 half hours time
    Given an employee is logged in
    And there exists a project with the name "p1"
    And the project "p1" has an activity with the name "a1"
    When the employee registers 25 half hours for the year 2024, month 8, and day 9 on the activity
    And the employee edits the time registration for the year 2024, month 8, and day 9 to be 49 half hours
    Then the error message "Only 48 half hours in a day" is received