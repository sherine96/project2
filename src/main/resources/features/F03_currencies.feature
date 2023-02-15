@smoke
  Feature: F03_currencies | users could change currency
    Scenario: user could login with valid email and password
      When user changes currency to euro
      Then user sees the new currency