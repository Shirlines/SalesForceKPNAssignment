Feature: An user tries to renew conract in salesforce
	This will test the functionality of renewing a contract for a given user
	Case1 - Renew a contract successfully 
	Case2 - Renew a contract unsuccessfully with an error message

Background:
Given A valid user is logged in
When The Renew Contract link is clicked and the create new contract page is loaded

Scenario: Renew a contract in salesforce successfully 
When The fields are filled with contractName as "Peace", term as "1 year", status as Draft and clicked on Done
Then The contract is renewed successfully with correct details

Scenario: Renew a contract in salesforce unsuccessfully with an error message
When The fields are filled with contractName as "Joy", term as "2 years", status as Signed and clicked on Done
Then An error message pops up with a warning
When OK is clicked by the user on the error pop up
Then The user is taken back to the renew contract page with an error message displayed