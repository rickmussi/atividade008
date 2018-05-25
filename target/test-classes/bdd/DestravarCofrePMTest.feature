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
Feature: como usuário eu quero destravar cofre
  

  @tag1
  Scenario: pressionar numero 
    Given entrei com o numero 193566
    When eu pressionei destravar
    Then porta destravada

  @tag2
  Scenario: limpe o display 
    Given entrei com o texto ""
    When eu pressionei limpar
    Then display limpo    
    
  @tag3
  Scenario: teste porta nao fechada 
    Given entrei com o numero 193566
    When ao digitar senha
    Then verificar se a porta esta aberta
     And feche a porta antes de digitar a senha

     
  @tag4
  Scenario: entre com a senha 
    Given entrei com o numero 193566
    When ao pressionar numero
    Then verifica se porta fechada
     And diplay 0            
     
  @tag5
  Scenario: gravar senha valida porta fechada destravada 
    Given entrei com o numero 193566
    When eu pressionei ok
    Then senha salva. cofre trancado
    And verficar portar travada
    And salvar senha
    
    
  @tag6
  Scenario: digitar senha com menos de seis 
    Given entrei com o numero 1
    When eu pressionei ok
    Then senha precisa de 6 digitos. tente novamente
         
  @tag7
  Scenario: digitar numeros porta fechada e depois abrir e digitar 
    Given entrei com o numero 98
    When eu pressionei ok
    Then abrir porta
         