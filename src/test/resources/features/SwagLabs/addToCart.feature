@login
Feature: Add to cart functionality
  Scenario Outline: Verify add to cart feature is working
    Given She is already on inventory page
    When She select item <item>
    Then Add To Cart icon will get badge count
    Examples:

    | item                              |
    | "add-to-cart-sauce-labs-backpack" |