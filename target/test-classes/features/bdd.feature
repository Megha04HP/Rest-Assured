Feature: Foreign Exchange
@smoke @regression
Scenario: Foreign Exchange Page success
		Given API for foreign exchange
		When posted with correct Information
		Then validate positive response code received

Scenario: Validate response for script and log it on console
		Given API for foreign exchange 
		When posted with correct Information
		Then validate response and log it on console

Scenario: Validating response using atleast two assertions
		Given API for foreign exchange 
		When passing values from get method
		Then validate response received

Scenario: Foreign Exchange Page failure
    Given API for foreign exchange one
		When posted with incorrect Information
		Then validate negative response code received


Scenario: Validate response status code for Negative Scenario using Assertion
    Given API for foreign exchange 
    When posted with correct Information
    Then validate response status code received


 Scenario: Validate response code on passing future date 
    Given API for foreign exchange 
    When posted with correct Information
    Then validate positive response code received

Scenario: Validate response code for negative scenario on passing future date using Assertion
    Given API for foreign exchange 
    When posted with future date Information
    Then validate response status code received

Scenario: login page using data provider
		Given API for for login
		When posted with multiple set of data information
		Then validate positive response code received from login page