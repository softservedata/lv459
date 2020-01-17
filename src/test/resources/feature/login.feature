Feature: Login Customer



  Scenario: Login user
    Given user is in database
    When I click "my account" button
    When I click "Login" link
    When I type email "3774217@gmail.com"
    When I type password
    When I click Login button
    Then Content with "Welcome on board" visible

    Then goto "Adress" Page