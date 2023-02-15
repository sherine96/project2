@smoke
Feature: F08_Wishlist | user could use wishlists
  Scenario: User likes at least 1 product
    When click on wishlist button on this product "HTC One M8 Android L 5.0 Lollipop"
    And success message is displayed after wish
    And wait for msg to disappear
    And click on wishlist
    Then check quantity
Scenario: user likes product
When click on wishlist button on this product "HTC One M8 Android L 5.0 Lollipop"
Then success message is displayed after wish
  And background color is green
