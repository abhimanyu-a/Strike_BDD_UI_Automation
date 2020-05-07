#Author: abhimanyu.athikayan@gmail.com
Feature: Keyword List Search

  @positive @list 
  Scenario Outline: TC1 - Search for Cars in Google website
    Given User Navigates to 'Google' website
    When User searches for "<CarName>"
    Then User should be shown the relevant results

    Examples: 
      | CarName               |
      | Maruti Baleno         |
      | Lamborghini Aventador |
      | Bugatti Chiron        |
      | Ford Mustang          |
