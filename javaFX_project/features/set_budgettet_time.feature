Feature: Set budgetet for activity

  Scenario: Succesfully set budgetet time for an activity
    Given There is an activity
    When The user sets the budgetet time for the activity
    Then The activity is given a bugetet time span

  Scenario: Set a start and end date for a non-existing activity
    Given There is no activity
    When The user set the budgetet time
    Then The error message "There is no activity with this name"