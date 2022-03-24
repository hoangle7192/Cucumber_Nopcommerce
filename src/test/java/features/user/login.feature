@login
Feature: Login with user account


  Background:
    Given a web browser is on the Login Page

  Scenario: Login with empty data
    When click Login button
    Then email error message is displayed
      | Please enter your email |

  Scenario: Login with invalid email
    When enter value to Email text box
      | abc#gmail.com |
    And click Login button
    Then email error message is displayed
      | Wrong email |











