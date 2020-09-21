Feature: Verify Summer Dresses added to cart on MyStore website.

  Scenario: User signin to MyStore website
    Given User enters correct userid and password on sign in page and clicks signin button
    When user clicks on home button and enters Summer Dresses in search section
    Then user selects dresses and clicks on Add to Cart button
