@register
Feature: Register a user


  Background:
    Given a web browser is on the Register Page

  @empty-data
  Scenario Outline: Register a user with empty data
    When click to Register button
    Then First name error message is displayed "<First name error message>"
    Then Last name error message is displayed "<Last name error message>"
    Then Email error message is displayed "<Email error message>"
    Then Password error message is displayed "<Password error message>"
    Then Confirm password error message is displayed "<Confirm password error message>"

    Examples:
      | First name error message | Last name error message | Email error message | Password error message | Confirm password error message |
      | First name is required.  | Last name is required.  | Email is required.  | Password is required.  | Password is required.          |

  @invalid-email
  Scenario Outline:  Register a user with invalid email
    When enter "<email>" to Email text box
    And click to Register button
    Then Email error message is displayed "<Email error message>"

    Examples:
      | email   | Email error message |
      | abc#123 | Wrong email         |

  @register_success
  Scenario Outline: Register a user with valid data
    When enter to Your Personal Details form with data
      | gender   | firstName   | lastName   | dateOfBirthDay   | dateOfBirthMonth   | dateOfBirthYear   | email   | company   | password   | confirmPassword   |
      | <gender> | <firstName> | <lastName> | <dateOfBirthDay> | <dateOfBirthMonth> | <dateOfBirthYear> | <email> | <company> | <password> | <confirmPassword> |
    And click to Register button
    Then registered success message has displayed "Your registration completed"
    When click to My account header link
    And get Email attribute value
    When click to Logout button
    And click to Register header link

    Examples:
      | gender | firstName | lastName | dateOfBirthDay | dateOfBirthMonth | dateOfBirthYear | email              | company    | password | confirmPassword |
      | M      | Wayne     | Rooney   | 10             | March            | 1998            | test0011@gmail.com | Manchester | wayne123 | wayne123        |

  @email_already_exists
  Scenario Outline: Register a user with email already exists
    When enter to Your Personal Details form with data
      | gender   | firstName   | lastName   | dateOfBirthDay   | dateOfBirthMonth   | dateOfBirthYear   | email   | company   | password   | confirmPassword   | errorMessage   |
      | <gender> | <firstName> | <lastName> | <dateOfBirthDay> | <dateOfBirthMonth> | <dateOfBirthYear> | <email> | <company> | <password> | <confirmPassword> | <errorMessage> |
    And click to Register button
    Then email already exists error message is displayed "<error message>"

    Examples:
      | gender | firstName | lastName | dateOfBirthDay | dateOfBirthMonth | dateOfBirthYear | email              | company    | password | confirmPassword | error message                      |
      | M      | Wayne     | Rooney   | 10             | March            | 1998            | test0011@gmail.com | Manchester | wayne123 | wayne123        | The specified email already exists |


  @less_than_six
  Scenario Outline: Register a user with password less than 6 character
    When enter "<password>" to Password text box
    And click to Register button
    Then Password error message is displayed "<Password error message>"

    Examples:
      | password | Password error message                                                   |
      | 123      | Password must meet the following rules:\nmust have at least 6 characters |

  @not_match
  Scenario Outline: Register a user with Password not match Confirm Password
    When enter "<password>" to Password text box
    When enter "<confirmPassword>" to Confirm Password text box
    And click to Register button
    Then Confirm password error message is displayed "<Confirm password error message>"

    Examples:
      | password | confirmPassword | Confirm password error message                       |
      | 123      | 123456          | The password and confirmation password do not match. |


