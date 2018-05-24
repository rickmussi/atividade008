#language: en
@tag
Feature: como usuário eu quero destravar cofre        
Scenario: verifica se porta esta fechada
Given entrei com a senha 123456
And validar se senha
When eu precisonei destravar
Then a porta deve destravar
   