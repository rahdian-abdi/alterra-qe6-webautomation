@login @add-item
Feature: Continue Shopping feature

  Background: User already login and add an item

  Scenario: Verify Continue shopping button is working
    When User clicked on the Cart icon
    And User redirected to Cart Page
    And User clicked on Continue Shopping
    Then User should be directed to products page
