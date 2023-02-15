@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user could login with valid email and password
  Given user go to login page
  When user login with "valid" "test@example.com" and "P@ssw0rd"
  And user press on login button
  Then user login to the system successfully
  Scenario Outline: user could login with invalid email and password
    Given user go to login page
    When user login with <string> <string2> and <string3>
    And user press on login button
    Then user could not login to the system
    Examples:
      | string    | string2             | string3    |
      | "invalid" | "wrong@example.com" | "P@ssw0rd" |
