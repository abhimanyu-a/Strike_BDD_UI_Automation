#Author: abhimanyu.athikayan@gmail.com
Feature: Keyword Search

  @positive @search
  Scenario: TC1 - Search for Nissan Car in Google website
    Given User Navigates to 'Google' website
    When User searches for "Nissan GTR"
    Then User should be shown the relevant results

  @negative @search
  Scenario: TC1 - Search for Kia Car in Google website
    Given User Navigates to 'Google' website
    When User searches for "Kia Seltos"
    Then User should be shown the relevant results