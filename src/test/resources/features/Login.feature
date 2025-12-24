Feature: Login

  Scenario Outline: Logging in
    Given Open Koel Login Page
    When Enter email "<Email>"
    And Enter password "<Password>"
    And Click submit
    Then Logged in
    Examples:
      | Email | Password |
      | adam.nall@testpro.io | adam_test1 |
      | demo@testpro.io | te$t$tudent |
      | test@testpro.io | incorrectpassword |