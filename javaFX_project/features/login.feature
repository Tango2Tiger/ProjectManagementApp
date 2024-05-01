Feature: An employee logs in

Scenario: Employee in the system logs in
  Given that no employee is logged in
  And there is an employee with initials "huba"
  And the employee is registered in the system
  When the employee logs in
  Then the employee is logged in


Scenario: Employee not in the system tries to log in
  Given that no employee is logged in
  And there is an employee with initials "huba"
  And there is no employee with initials "huba" in the system
  When the employee logs in
  Then the error message "employee with initials huba is not in the system" is received

