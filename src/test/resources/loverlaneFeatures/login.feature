
Feature: User Login

  @LoginTest1 @reg
  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should be redirected to the dashboard
    Examples:
      | username        | password    |
      | ealia@virid.com | Elisabeta1! |

  @LoginTest2 @reg
  Scenario Outline: Failed login with invalid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And the user clicks the login button
    Then the user should see an error message "<errorMessage>"
    Examples:
      | username | password | errorMessage    |
      | test     | test123  | User not found. |

  @LoginTest3 @reg
  Scenario: Login with empty username
    Given the user is on the login page
    When the user enters "" and "<password>"
    And the user clicks the login button
    Then the user should see an error message "Username is required"

  @LoginTest4 @reg
  Scenario: Login with empty password
    Given the user is on the login page
    When the user enters "<username>" and ""
    And the user clicks the login button
    Then the user should see an error message "Password is required"

  @LoginTest5 @reg
  Scenario: Login with empty username and password
    Given the user is on the login page
    When the user enters "" and ""
    And the user clicks the login button
    Then the user should see an error message "Password is required" and "Username is required"


