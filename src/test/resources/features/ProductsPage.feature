Feature: Products page

  Scenario Outline: clicking on a product to go to its page
    Given I have logged in and am on the products page
    When I click the product with the "<ID>"
    Then I will be navigated to the individual "<Product>" page
    Examples:
    |ID        |Product                          |
    |1         |Sauce Labs Bolt T-Shirt          |
    |2         |Sauce Labs Onesie                |
    |3         |Test.allTheThings() T-Shirt (Red)|
    |4         |Sauce Labs Backpack              |
    |5         |Sauce Labs Fleece Jacket         |
    |0         |Sauce Labs Bike Light            |

    Scenario Outline: Adding individual products to cart
      Given I have logged in and am on the products page
      When I click the add to cart button for the product with id "<ID>"
      Then The cart iterator will increase by one
      Examples:
      |ID|
      |1 |
      |2 |
      |3 |
      |4 |
      |5 |
      |6 |

    Scenario: Adding all the products to the cart
      Given I have logged in and am on the products page
      When I click add to cart on all the products
      Then The cart iterator will increase by six
