Feature: Login

  Scenario: Login using Data Driven
    Given I navigate to the test login page
    When User enters sheetname and rownumber 
    And I click the test login button
    Then I should be logged into test
   

    Examples: 
      | Sheetname | RowNumber |
      | Sheet1    | 1         |
      
      
   
