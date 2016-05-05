Feature: Attitude Matters
  In order to understand attitude
  As a IT working guy
  I want to know whom to wish

  @tester
  Scenario Outline: I am an Employee

    Given I work in late nights
    When I meet watchman
    Then I greet him

    Given I work in the mornings
    When I meet newspaper boy
    Then I skip greet him

    Given we work in "<weekday>"
    When we meet "<guy>"
    Then I skip greet him

    Examples:
      | weekday | guy      |
      | weekday | guy      |
      | ten     | watchman |
      | nine    | driver   |