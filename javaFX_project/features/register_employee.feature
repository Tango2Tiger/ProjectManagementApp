Feature: An employee is registered


Scenario: Successfully register new employee
  Given there is an employee with name{string}
  When the user registers an employee
  Then the employee with name{string} exists in the system"

Scenario: Register an employee that is already registered
  #Given an employee is registered in the system
  #And the user is logged in
  #When the user registers the employee again
  #Then the error message “Employee is already registered” is given
