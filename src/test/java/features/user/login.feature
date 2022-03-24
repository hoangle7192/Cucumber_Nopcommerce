@login
Feature: Login with user account


  Background:
    Given a web browser is on the Login Page

  Scenario: Login with empty data
    When click Login button
    Then email error message "Please enter your email" is displayed

  Scenario: Login with invalid email
    When enter value invalid "abc#gmail.com" to Email text box
    And click Login button
    Then email error message "Wrong email" is displayed

    Scenario: Login with registered email and valid password
      When enter registered email to Email text box
      And enter valid password to Password text box
        | wayne123 |
      And click Login button
      Then a web browser is on the Customer Info Page with title "My account - Customer info"












