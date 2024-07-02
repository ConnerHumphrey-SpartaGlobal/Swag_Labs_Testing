Feature: Cart page

  Scenario Outline: Adding one item to cart
    Given I have logged in and am on the products page
    When I click the add to cart button for the product with id "<ID>"
    And I click the cart button
    Then The item with the link id "<Link ID>" and name "<Name>" will be displayed in the cart
    Examples:
      |ID|Link ID|Name|
      |1 |4      |Sauce Labs Backpack|
      |2 |0      |Sauce Labs Bike Light                   |
      |3 |1      |Sauce Labs Bolt T-Shirt                   |
      |4 |5      |Sauce Labs Fleece Jacket                   |
      |5 |2      |Sauce Labs Onesie                   |
      |6 |3      |Test.allTheThings() T-Shirt (Red)                   |

