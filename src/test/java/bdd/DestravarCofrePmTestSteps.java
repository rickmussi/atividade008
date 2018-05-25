/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import cofre.CofrePM;
import cofre.Memoria;
import cofre.SensorPorta;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Mussi
 * https://automacaoforadacaixa.wordpress.com/2017/05/04/2-iniciando-um-projeto-no-selenium-e-cucumber-parte-i/
 * OBS: falta fazer as implementações dos testes
 */
public class DestravarCofrePmTestSteps {

    SensorPorta sensorMock = null;
    Memoria memoriaMock = null;
    CofrePM cofrePM = null;

    public void iniciar() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);

        //porta sempre destravada
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);
    }

    @Given("^entrei com o numero (\\d+)$")
    public void entrei_com_o_numero(int arg1) throws Exception {
        cofrePM.pressButton(1);
        cofrePM.pressButton(9);
        cofrePM.pressButton(3);
        cofrePM.pressButton(5);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
    }

    @When("^eu pressionei destravar$")
    public void eu_pressionei_destravar() throws Exception {
        cofrePM.ok();
    }

    @Then("^porta destravada$")
    public void porta_destravada() throws Exception {
        assertEquals("Entre com a senha 6 digitos", cofrePM.getDisplay());
        verify(sensorMock).destravar();
    }

    @Given("^entrei com o texto \"([^\"]*)\"$")
    public void entrei_com_o_texto(String arg1) throws Exception {
        cofrePM.setDisplay("");
    }

    @When("^eu pressionei limpar$")
    public void eu_pressionei_limpar() throws Exception {
        cofrePM.clear();
    }

    @Then("^display limpo$")
    public void display_limpo() throws Exception {
        assertEquals("", cofrePM.getDisplay());
    }

    @When("^ao digitar senha$")
    public void ao_digitar_senha() throws Exception {
        cofrePM.pressButton(1);
        cofrePM.pressButton(9);
        cofrePM.pressButton(3);
        cofrePM.pressButton(5);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
        cofrePM.ok();
    }

    @Then("^verificar se a porta esta aberta$")
    public void verificar_se_a_porta_esta_aberta() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);

        for (int botao = 0; botao <= 9; botao++) {
            cofrePM.pressButton(botao);
            assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
            cofrePM.clear();
        }
    }

    @Then("^feche a porta antes de digitar a senha$")
    public void feche_a_porta_antes_de_digitar_a_senha() throws Exception {
        assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
    }

    @When("^ao pressionar numero$")
    public void ao_pressionar_numero() throws Exception {
        cofrePM.pressButton(0);
    }

    @Then("^verifica se porta fechada$")
    public void verifica_se_porta_fechada() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);

        verify(sensorMock).destravar();
    }

    @Then("^diplay (\\d+)$")
    public void diplay(int arg1) throws Exception {
        assertEquals("0", cofrePM.getDisplay());
    }

    @When("^eu pressionei ok$")
    public void eu_pressionei_ok() throws Exception {
        cofrePM.ok();
    }

    @Then("^senha salva\\. cofre trancado$")
    public void senha_salva_cofre_trancado() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        
        cofrePM.pressButton(1);
        assertEquals("1", cofrePM.getDisplay());
        
        cofrePM.pressButton(9);
        assertEquals("19", cofrePM.getDisplay());
        
        cofrePM.pressButton(3);
        assertEquals("193", cofrePM.getDisplay());
        
        cofrePM.pressButton(5);
        assertEquals("1935", cofrePM.getDisplay());
        
        cofrePM.pressButton(6);
        assertEquals("19356", cofrePM.getDisplay());
        
        cofrePM.pressButton(6);
        assertEquals("193566", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("Senha salva. Cofre trancado", cofrePM.getDisplay());
    }

    @Then("^verficar portar travada$")
    public void verficar_portar_travada() throws Exception {
        verify(sensorMock).travar();
    }

    @Then("^salvar senha$")
    public void salvar_senha() throws Exception {
        verify(memoriaMock).salvarSenha("193566");
    }

    @Then("^senha precisa de (\\d+) digitos\\. tente novamente$")
    public void senha_precisa_de_digitos_tente_novamente(int arg1) throws Exception {
        assertEquals("Entre com a senha 6 digitos", cofrePM.getDisplay());
        verify(sensorMock).destravar();
    }

    @Then("^abrir porta$")
    public void abrir_porta() throws Exception {
        verify(sensorMock).destravar();
    }
}
