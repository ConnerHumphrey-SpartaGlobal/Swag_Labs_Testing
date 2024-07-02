Feature: Checkout

  Scenario: Checkout with valid details

    Given I have logged in and am on the products page
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my "Conner", "Humphrey" and "B7 4BB"
    And press the continue button
    And press the finish button
    Then I will be told my order has been dispatched


  Scenario: Checkout with missing First Name

    Given I have logged in and am on the products page
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my "", "Humphrey" and "B7 4BB"
    And press the continue button
    Then I will be told I need to enter a first name

  Scenario: Checkout with missing Second Name

    Given I have logged in and am on the products page
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my "Conner", "" and "B7 4BB"
    And press the continue button
    Then I will be told I need to enter a second name

  Scenario: Checkout with missing Postal Name

    Given I have logged in and am on the products page
    And I have added a product to my cart
    And I have navigated to my cart
    When I press checkout
    And Enter my "Conner", "Humphrey" and ""
    And press the continue button
    Then I will be told I need to enter a Zip code