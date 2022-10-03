Feature: Login functionality

  Scenario: Login with valid username and valid password
    Given Caca is on the homepage
    When She input "standard_user" on the username field
    And She input "secret_sauce" on the password field
    And She click on the Login button
    Then She will be directed to inventory page

  Scenario: Login with invalid username and valid password
    Given Caca is on the homepage
    When She input "not_standard_user" on the username field
    And She input "secret_sauce" on the password field
    And She click on the Login button
    Then She fail to login
    Then She fail to login

