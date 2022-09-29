Feature: Sorting Items
  Scenario Outline: Sort product feature
    Given User already logged in
    And User already add an item to cart
    When User select sort by <sortOption>
    Then The products should sorted by <sortOption>
    Examples:
    |sortOption|
    |"Name (A to Z)"|
    |"Name (Z to A)"|
    |"Price (low to high)"|
    |"Price (high to low)"|