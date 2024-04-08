Feature: An employee wants to create a new project

Scenario: Employee creates project
  Given the user is logged in
  And there is no project with name "project1"
  When the user creates the project
  Then there is a project with name "project1"

  #Scenario: There is already a project with the given name
  #  Given the user is logged in
  #  And there is a project with name "project1"
  #  When the user creates the project
  #  Then the error message "There is already a project in the app with the given name" is given
