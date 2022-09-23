Feature: Remove item feature


  Scenario Outline: Remove item from Cart Page
    Given User already logged in
    And User already add an item to cart
    When User add item with Add To Cart id <item>
    And User click on cart icon
    And User is directed to Cart Page
    And User remove item with id <item>
    Then Item will be removed from cart
    Examples:
    |item                               |
    |"test.allthethings()-t-shirt-(red)"|