Feature: Sorting Items

  @assignment
  Scenario Outline: Sort product by descending
    Given User already logged in
    And User already add an item to cart
    When User select sort by <sortOption>
    Then The products should sorted by <sortOption>
    Examples:
    |sortOption|
    |"Name (Z to A)"|