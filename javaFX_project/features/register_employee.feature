Feature: An employee is registered


Scenario: Successfully register new employee
  Given there is an employee with first name "Hubert" and last name "Baumeister"
  When the employee with first name "Hubert" and last name "Baumeister" is registered
  Then the employee with first name "Hubert" and last name "Baumeister" is in the system

Scenario: Register an employee that is already registered
  Given the employee with first name "Hubert" and last name "Baumeister" is registered
  When the employee with first name "Hubert" and last name "Baumeister" is registered again
  Then the error message "Employee is already registered" is received
