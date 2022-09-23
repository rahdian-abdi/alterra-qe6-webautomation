Feature: Add to cart functionality

  Scenario Outline: Verify add to cart feature is working
    Given Caca is already login already logged in with <username> username and <password> password
    And She is already on inventory page
    When She select item <item>
    Then Add To Cart icon will get badge count
    Examples:

    | username        | password       | item                              |
    | "standard_user" | "secret_sauce" | "add-to-cart-sauce-labs-backpack" |