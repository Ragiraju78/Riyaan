Feature: Application Login

  Scenario: Home page Default login
    Given User is on the netbank login page
    When User logs in to the app by providing user name and password
    Then Home page is populated
    And User details and account details displayed
