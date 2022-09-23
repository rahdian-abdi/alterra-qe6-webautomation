Feature: Checkout feature
  Scenario Outline: Checkout a product when product available
    Given User already logged in
    And User already add an item to cart
    When User clicked on the Cart icon
    And User redirected to Cart Page
    And User click on Checkout Button
    And User is redirected to Checkout Step One Page
    And User input first name on <firstName> field
    And User input last name on <lastName> field
    And User input postal code on <postalCode> field
    And User click on Continue Button
    And User is redirected to Checkout Step Two Page
    And User click on Finish Button
    Then User will be directed to Checkout Complete Page
    Examples:
    | firstName | lastName | postalCode |
    | "dian"    | "dian"   | "1234"     |