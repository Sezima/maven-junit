@smoke  @regression
Feature: User Management

  @smoke
  Scenario: Creating a new user
    Given the user is on the registration page
    When the user fills in the registration form
    Then the user should be registered successfully

  @regression
  Scenario: Editing user information
    Given the user is logged in
    When the user navigates to the profile page
    Then the user can edit their information

#    every single feature will have a tag