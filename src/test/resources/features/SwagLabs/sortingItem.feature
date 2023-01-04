@login
Feature: Sorting Items
  Background:
  User want to sort the item base on price and item and user should login first and add an Item
    first.

  Scenario Outline: Sort product feature
    When User select sort by <sortOption>
    Then The products should sorted by <sortOption>
    Examples:
    |sortOption|
    |"Name (A to Z)"|
    |"Name (Z to A)"|
    |"Price (low to high)"|
    |"Price (high to low)"|