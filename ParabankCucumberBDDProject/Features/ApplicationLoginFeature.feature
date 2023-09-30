#Author: BharathTechAcademy@Gmail.Com
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
@LoginFeature
Feature: Parabank Login Feature
  I want to use this feature file to validate login feature of parabank application

  Background: Initialize all pages and launch the application
    Given Initialize all pages
    And Launch the application using "https://parabank.parasoft.com/parabank/index.htm"
    Then Application should be launched with the title "ParaBank | Welcome | Online Banking"

  @Sanity @Regression
  Scenario: Verify application logo and caption
    Then Verify application logo is displayed
    And Verify application caption is displayed as "Experience the difference"

  @Sanity @Regression
  Scenario: Verify application login page header
    Then Verify application login page header is displayed as "Customer Login"

  @Smoke @Sanity @Regression
  Scenario Outline: Verify application login feature
    When User eneter <Username> and <Password>
    And Click on the login button
    Then Login should be successful

    Examples: 
      | Username     | Password     |
      | Admin        | admin123     |
      | Invalid User | Invalid Pass |
