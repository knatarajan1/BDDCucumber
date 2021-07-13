Feature: Login to Serice Now

#Background: 
#Given Launch the browser
#And URL is loaded

Scenario: Login Positive
When User enters the username as "admin"
And User enters the password as "nM4gL0oBPwxS"
And User clicks the signin button
Then User should see the dashboard Page

Scenario: Login Negative
When User enters the username as "admin"
And User enters the password as "pass"
And User clicks the signin button
Then User should not see the dashboard Page