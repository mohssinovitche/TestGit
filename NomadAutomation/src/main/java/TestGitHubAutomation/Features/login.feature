#Author: your.email@your.domain.com
Feature: login to github.com
  
  
  
  Scenario 1 : connect witg a bad login
  
    Given firefox is open
    And github page is loaded
    When I enter a bad login
    And I enter a bad password
    And I click on submit
    Then user should not be sign in
    
  Scenario 2 : connect witg a valid login
  
    Given firefox is open
    And github page is loaded
    When I enter a valid login
    And I enter a bad password
    And I click on submit
    Then the user should be sign in
