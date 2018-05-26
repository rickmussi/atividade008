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
  Scenario: porta nao fechada
    Given entrei com numero 1
    When eu pressionei destravar
    Then verifica porta
    And  mensagem "Feche a porta antes de digitar a senha" deve aparecer   


  @tag2
  Scenario: digite numero com a porta fechada
    Given entrei com numero 1
    When eu pressionei destravar
    Then verifica porta fechada
    And  mensagem "0" deve aparecer   
        
  @tag3 
  Scenario: teste gravar senha valida porta fechada destravada 
    Given entrei com numero 193566
    When eu pressionei destravar
    Then verifica se porta fechada e destravada
     And mensagem "Senha salva. Cofre trancado" deve aparecer           
     
  @tag4
  Scenario: teste digitar senha com menos de seis 
    Given entrei com numero 1
    When eu pressionei destravar
    Then verifica se senha com de seis
     And mensagem "senha precisa de 6 digitos. Tente novamente" deve aparecer    
    
  @tag5
  Scenario: teste digitar senha com menos de seis 
    Given entrei com numero 11
    When eu pressionei destravar
    Then verifica se senha com de seis
     And mensagem "senha precisa de 6 digitos. Tente novamente" deve aparecer

  @tag6
  Scenario: testar display 
    Given entrei com numero 1
    When eu pressionei destravar
    Then mostra no display
    And mensagem "1" deve aparecer
         
  @tag7
  Scenario: testar display 
    Given entrei com numero 11
    When eu pressionei destravar
    Then mostra no display
    And mensagem "11" deve aparecer
         
  @tag8
  Scenario: teste digitar numeros 
    Given entrei com numero 98
    When eu pressionei destravar
    Then teste digitar numeros 
    And mensagem "98" deve aparecer
    
  @tag9
  Scenario: teste digitar numeros porta fechada
    Given entrei com numero 98
    When eu pressionei destravar
    Then teste digitar numeros porta fechada
    And mensagem "Feche a porta antes de digitar a senha" deve aparecer
    
  @tag10
  Scenario: teste digitar numeros porta fechada e depois abrir e digitar
    Given entrei com numero 7
    When eu pressionei destravar
    Then teste digitar numeros porta fechada e depois abrir e digitar
    And mensagem "7" deve aparecer 
     
  @tag11
  Scenario: clear
    Given limpar
    When clear
    Then limpa cofre
    And mensagem "" deve aparecer         