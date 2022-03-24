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

    Scenario: Login with registered email and valid password
      When enter registered email to Email text box
      And enter valid password to Password text box
        | wayne123 |
      And click Login button
      Then a web browser is on the Customer Info Page
        | My account - Customer info |











