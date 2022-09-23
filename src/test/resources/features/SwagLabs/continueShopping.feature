Feature: Continue Shopping feature


  Scenario: Verify Continue shopping button is working
    Given User already logged in
    And User already add an item to cart
    When User clicked on the Cart icon
    And User redirected to Cart Page
    And User clicked on Continue Shopping
    Then User should be directed to products page
