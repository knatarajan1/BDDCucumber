Feature: Login to Serice #Now using outline

#Background: 
#Given Launch the browser
#And URL is loaded

Scenario Outline: Login Test

When User enters the username as "<userName>"
And User enters the password as "<password>"
And User clicks the signin button
Then Validate login

Examples: 
|userName|password|
|admin|nM4gL0oBPwxS|
|admins|nM4gL0oBPwx|