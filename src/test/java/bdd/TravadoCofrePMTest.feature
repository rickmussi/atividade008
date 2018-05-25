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
Feature: como usuário quero travar o cofre

  @tag1
  Scenario: pressionar numero
    Given entrei com o numero 123456
    When eu precionei destravar
    Then senha errada. tente novamente

  @tag2
  Scenario: pressionar numero
    Given entrei com o numero 1
    When eu precionei destravar
    Then senha errada. tente novamente

  @tag3
  Scenario: pressionar numero
    Given entrei com o numero 11
    When eu precionei destravar
    Then senha errada. tente novamente`
    
  @tag4
  Scenario: pressionar numero
    Given entrei com o numero 123466
    When eu precionei destravar
    Then senha correta. Cofre aberto
    And  chamar destravar   