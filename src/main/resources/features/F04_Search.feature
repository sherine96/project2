@smoke
Feature: F04_search  | User will search for product
Scenario Outline: user could search using product name.
When User enters product name as "<product>"
When User pressess enter
  Then make sure search contains search word as "<product>"
Examples:
| product |
| book|
| laptop |
| nike |
  Scenario Outline: user could search for product using sku.
    When User enters sku as "<product>"
    When Press product link
    Then Make sure entered sku as "<product>" is the same as in page.
    Examples:
      | product |
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
