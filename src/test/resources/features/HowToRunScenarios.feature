Feature: Transfer

  # one of the main principles of writting cucumber features files
  #steps have to be as dynamic as possible the step responsiblity within other scenarios as
  #null
  Scenario:  Money transfer with insufficient funds
    Given User with account number 23244210 is registered
    And User with account number 4210 deposited $1000
    When User with account number 4210 transfer $110
    Then User with account number 4210 should have $1000 in balance
    And User should see Insufficient Funds message

    # When the step is not highlighted it means it already has an implementations(step definition)

#  Scenario: Demo String params
#    Given User is on Qa-chase.com
