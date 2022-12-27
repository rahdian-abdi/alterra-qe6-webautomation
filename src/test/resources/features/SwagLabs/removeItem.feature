@login @add-item
Feature: Remove item feature
  Background: User already login and add an item

  Scenario Outline: Remove item from Cart Page
    When User add item with Add To Cart id <item>
    And User click on cart icon
    And User is directed to Cart Page
    And User remove item with id <item>
    Then Item will be removed from cart
    Examples:
    |item                               |
    |"test.allthethings()-t-shirt-(red)"|