Feature: Employee wants to get a status report
    
    Scenario: Employee downloads a status report
        Given there exists a project with the name "p1"
        And there is a file for the report
        #When employee creates the status report