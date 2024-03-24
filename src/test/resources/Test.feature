Feature: Login Action
  Description: This feature will test a Login and Logout functionality

  Scenario Outline: Login with Valid Credentials
    Given User is on Home Page
    When User enters "<username>" and "<password>"
    And Keeping case as Valid
    Then User should get logged in
    Then User log out successfully

    Examples:
      | username       | password |
      | student        | Password123 |

  Scenario Outline: Login with Invalid Credentials
    Given User is on Home Page
    When User enters Invalid "<username>" and "<password>"
    And Keeping case as Invalid
    Then User will be asked to go back to the login page
    And Provide correct credentials

    Examples:
      | username         | password |
      | invalid_username | password |
