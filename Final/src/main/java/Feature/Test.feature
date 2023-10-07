Feature: Automated Tests

  Scenario: User place an order of an item from search
    Given User is on Home page
    Then Getting the title of webpage
    And Getting the current url of the website
    When User searches for Speakers
    Then Selects the item to buy
    And The product is added to cart
    And Checkout from cart
    And Enters details on checkout as guest page
    