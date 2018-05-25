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
Feature: validar numero

  @tag1
  Scenario: pressionar numero
    Given entrei com o numero 123
    When eu precionei destravar
    Then eh numero

  @tag2
  Scenario: pressionar numero
    Given entrei com o numero 1234444
    When eu precionei destravar
    Then eh numero    
    
  @tag3
  Scenario: pressionar numero
    Given entrei com o numero ""
    When eu precionei destravar
    Then nao e numero

  @tag4
  Scenario: pressionar numero
    Given entrei com o numero 123aaaa
    When eu precionei destravar
    Then nao e numero    
    
  @tag5
  Scenario: pressionar numero
    Given entrei com o numero 123
    When eu precionei destravar
    Then senha invalida
    
  @tag6
  Scenario: pressionar numero
    Given entrei com o numero 1
    When eu precionei destravar
    Then senha invalida
    
  @tag7
  Scenario: pressionar numero
    Given entrei com o numero 12345
    When eu precionei destravar
    Then senha invalida
    
  @tag8
  Scenario: pressionar numero
    Given entrei com o numero 12345a
    When eu precionei destravar
    Then senha invalida
    
  @tag9
  Scenario: pressionar numero
    Given entrei com o numero 123aaaa
    When eu precionei destravar
    Then senha invalida
    
  @tag10
  Scenario: pressionar numero
    Given entrei com o numero 123999
    When eu precionei destravar
    Then senha valida