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
Feature: como usuário quero destravar o cofre travado

  @tag1
  Scenario: pressionar numero
    Given entrei com o numero 123456
    When eu precionei o destravar
    Then o resultado deve ser tente novamente
    And a mensagem "senha errada. Tente novamente" deve aparecer
    
  @tag2
  Scenario: pressionar numero
    Given entrei com o numero 1
    When eu precionei o destravar
    Then o resultado deve ser tente novamente
    And a mensagem "senha errada. Tente novamente" deve aparecer

  @tag3
  Scenario: pressionar numero
    Given entrei com o numero 11
    When eu precionei o destravar
    Then o resultado deve ser tente novamente
    And a mensagem "senha errada. Tente novamente" deve aparecer    
    
  @tag4
  Scenario: pressionar numero
    Given entrei com o numero 123466
    When eu precionei o destravar
    Then cofre sera aberto
    And  a mansagem "senha correta. Cofre aberto" deve aparecer   