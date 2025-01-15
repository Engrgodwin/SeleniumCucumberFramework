Feature: SauceDemo End-to-End Test

  @EndToEnd
  Scenario Outline: Validate end-to-end functionality of SauceDemo
    Given user is on the login page
    When user logs in with "<username>" and "<password>"
    Then user should see the inventory page
    When user adds item "<itemName>" to the cart
    And user proceeds to the cart
    And user proceeds to checkout
    And user enters shipping details "<firstName>", "<lastName>", "<zipCode>"
    When user completes the purchase
    Then user should see the confirmation page

    Examples:
      | username      | password     | itemName            | firstName | lastName | zipCode |
      | standard_user | secret_sauce | Sauce Labs Backpack | John      | Doe      | 12345   |