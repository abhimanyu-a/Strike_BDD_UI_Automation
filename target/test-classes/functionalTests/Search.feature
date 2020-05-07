#Author: abhimanyu.athikayan@gmail.com
Feature: Keyword Search

  @positive @all @login
  Scenario: TC1 - Search for Keyword in Google website
    Given User Navigates to 'Google' website
    When User searches for "Nissan GTR"
    Then User should be shown the relevant results