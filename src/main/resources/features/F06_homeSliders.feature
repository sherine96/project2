@smoke
  Feature: F06_homeSliders | user uses sliders
    Scenario: first slider is clickable on home page
      Given wait until banner 1 is displayed
      When click on 1st slider
      Then check if url is nokia link
    Scenario: second slider is clickable on home page
      Given wait until banner 2 is displayed
      When click on 2nd slider
      Then check if url is iphone link

