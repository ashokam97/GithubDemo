#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: To add the Places to Maps using the AddPlace API

Scenario: To Verify Whether User is Able is add the Place Successfully
Given Added the Addplace Payload with "<Name>" "<Address>"
When User hits to the Addplace API Using the Post Http Request
Then Verify Place is Added Successfully to the Maps
And Verify "status" showing as "OK"
And Verify "scope" showing as "APP" 

Examples:
|Name  |Address         |
|TESTER|Tester Address  |
|Ashok |Neelaadri E-city|