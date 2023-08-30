Feature: User account edit

  Scenario: User adds first address to the account
    Given I'm on the hotel authentication page
    When I sign in using "tchiibzalzhlbvfqog@ckptr.com" and "12345"
    And I go to my addresses page
    Then I can see there is no addresses
    When I add new address
    And I enter new address "Osiedle 28", "00-001", "Krakow", "123456789"
    Then I can see new address
    And I verify created address "Osiedle 28", "00-001", "Krakow", "123456789"
