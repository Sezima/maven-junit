Feature: Deposit Tests - title
  Scenario: We would give Scenario name right here
  Given
  When
    Then Bank account 1 should have $110 dollars in balance

  Scenario: Money Transfer with enough balance
    Given User with account number 123456 is registered
    And User with account number 123456 deposited $500
    When User with account number123456 transfers $300
    And User with account number123456 transfer $200
    Then User with account number 123456 should have $0 in balance
