Feature: Time is registered

  Scenario: Employee succesfully registers time on an activity
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

#  Scenario: Employee registers time on a day not in the gregorian calendar
#    Given an employee is logged in
#    And there exists a project with the name "p1"
#    And the project "p1" has an activity with the name "a1"
#    When the employee registers 25 half hours for the year 2024, month 8, and day 34
#    Then the error message "date must be valid" is received
