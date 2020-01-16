Feature: Login Customer

  Scenario: Login user
    Given user is in database
    When I click "My account" button
    When I type email
    When I type password
    When I click "Login" button span
    Then Content with "Welcome on board" visible