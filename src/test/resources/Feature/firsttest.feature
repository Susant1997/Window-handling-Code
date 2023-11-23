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
@tag
Feature: Amazon
  


  @tag2
  Scenario Outline: End to End
    Given Launch the url "<url>"
    And Search the product in search menu and pass ther value "<searchname>" and submit the search option
		And Move to new tab and click the add to cart button
		And Close the new tab and bring the control to home page and refresh the page.
    Examples: 
      | url  									 | searchname | 
      | https://www.amazon.in/ | iphone14 | 