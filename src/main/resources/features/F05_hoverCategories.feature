@smoke
Feature: F05_hover  | user will hover and click
  Scenario: user could search using product name.
    When User hovers over computers main categories
    And user hovers over desktops subcategories
    And get sub categories text and click
    Then compare text and title page
