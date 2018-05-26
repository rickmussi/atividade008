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
import static org.junit.Assert.fail;
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

	@Given("^entrei com numero (\\d+)$")
	public void entrei_com_numero(String senha) throws Exception {
    	sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
           
        when(memoriaMock.getSenha())
        .thenReturn(senha);
        when(sensorMock.fechada())
        .thenReturn(Boolean.FALSE);
        
        when(sensorMock.travada())
        .thenReturn(Boolean.FALSE);    

	}

	@Then("^verifica porta$")
	public void verifica_porta() throws Exception {
	    when(sensorMock.fechada())
        .thenReturn(Boolean.FALSE);
        cofrePM.ok();
        assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
	}
	
	@Then("^verifica se senha com de seis$")
	public void verifica_se_senha_com_de_seis() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);

         cofrePM.ok();
         assertEquals("senha precisa de 6 digitos. Tente novamente", cofrePM.getDisplay());
	}

	@Then("^mostra no display$")
	public void mostra_no_display() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);
		cofrePM.pressButton(Integer.parseInt(memoriaMock.getSenha()));
		assertEquals(memoriaMock.getSenha(), cofrePM.getDisplay());
	}
	
	@Then("^teste digitar numeros$")
	public void teste_digitar_numeros() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);

        cofrePM.pressButton(9);
        cofrePM.pressButton(8);
        assertEquals("98", cofrePM.getDisplay());

	}

	@Then("^teste digitar numeros porta fechada$")
	public void teste_digitar_numeros_porta_fechada() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.FALSE);

        cofrePM.pressButton(7);
        assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
	}

	@Then("^teste digitar numeros porta fechada e depois abrir e digitar$")
	public void teste_digitar_numeros_porta_fechada_e_depois_abrir_e_digitar() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);

        cofrePM.pressButton(7);
        assertEquals("7", cofrePM.getDisplay());
	}	
	
	@Then("^verifica se porta fechada e destravada$")
	public void verifica_se_porta_fechada_e_destravada() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);
		
       cofrePM.pressButton(1);
       cofrePM.pressButton(9);
       cofrePM.pressButton(3);
       cofrePM.pressButton(5);
       cofrePM.pressButton(6);
       cofrePM.pressButton(6);
        
        
		cofrePM.ok();
        assertEquals("Senha salva. Cofre trancado", cofrePM.getDisplay());

        sensorMock.travar();
        memoriaMock.salvarSenha(memoriaMock.getSenha());
	}
	
	@Then("^verifica porta fechada$")
	public void verifica_porta_fechada() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);

        cofrePM.pressButton(0);

        assertEquals("0", cofrePM.getDisplay());
	}

	
	@When("^eu pressionei destravar$")
	public void eu_pressionei_destravar() throws Exception {
    	cofrePM.ok();
	}

	@Given("^entrei com o texto \"([^\"]*)\"$")
	public void entrei_com_o_texto(String texto) throws Exception {
		cofrePM.setDisplay(texto);
	}

	@When("^eu pressionei limpar$")
	public void eu_pressionei_limpar() throws Exception {
		display_limpo(); 
	}

	@Then("^display limpo$")
	public void display_limpo() throws Exception {
		assertEquals("", cofrePM.getDisplay());
	}

	@When("^ao digitar senha$")
	public void ao_digitar_senha() throws Exception {
		verificar_se_a_porta_esta_aberta();
	}

	@Then("^verificar se a porta esta aberta$")
	public void verificar_se_a_porta_esta_aberta() throws Exception {
       sensorMock.fechada();
	}

	@Then("^feche a porta antes de digitar a senha$")
	public void feche_a_porta_antes_de_digitar_a_senha() throws Exception {
		assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
	}

	@When("^ao pressionar numero$")
	public void ao_pressionar_numero() throws Exception {
		verifica_se_porta_fechada();
	}

	@Then("^verifica se porta fechada$")
	public void verifica_se_porta_fechada() throws Exception {
		sensorMock.fechada();
	}

	@Then("^diplay (\\d+)$")
	public void diplay(String num) throws Exception {
		assertEquals(num, cofrePM.getDisplay());
	}

	@When("^eu pressionei ok$")
	public void eu_pressionei_ok() throws Exception {
        eu_pressionei_destravar();
	}

	@Then("^senha salva\\. cofre trancado$")
	public void senha_salva_cofre_trancado() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);

        eu_pressionei_destravar();
        assertEquals("Senha salva. Cofre trancado", cofrePM.getDisplay());
	}

	@Then("^verficar portar travada$")
	public void verficar_portar_travada() throws Exception {
	    verficar_portar_travada();
	}

	@Then("^salvar senha$")
	public void salvar_senha() throws Exception {
		memoriaMock.salvarSenha(memoriaMock.getSenha());
	}

	@Then("^senha precisa de (\\d+) digitos\\. tente novamente$")
	public void senha_precisa_de_digitos_tente_novamente(String mensagem) throws Exception {
        assertEquals(mensagem, cofrePM.getDisplay());
	}

	@Then("^abrir porta$")
	public void abrir_porta() throws Exception {
        when(sensorMock.fechada())
        .thenReturn(Boolean.FALSE);
        
        when(sensorMock.travada())
        .thenReturn(Boolean.FALSE);  
	}
	
	@Then("^cofre abrira$")
	public void cofre_abrira() throws Exception {
		
		sensorMock = mock(SensorPorta.class);
		when(sensorMock.travada())
	    .thenReturn(Boolean.FALSE);
		
	}

	@Then("^mensagem \"([^\"]*)\" deve aparecer$")
	public void mensagem_deve_aparecer(String mensagem) throws Exception {
		assertEquals(mensagem, cofrePM.getDisplay());
	}
	
	@Given("^entrei com numero$")
	public void entrei_com_numero() throws Exception {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);    
        
        //porta sempre destravada
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE); 
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);
	}

	@Then("^inicializacao$")
	public void inicializacao() throws Exception {
		 assertEquals("Entre com a senha 6 digitos", cofrePM.getDisplay());
	}

	@Given("^limpar$")
	public void limpar() throws Exception {
    	sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
		cofrePM.clear();
	}

	@When("^clear$")
	public void clear() throws Exception {
        
	}

	@Then("^limpa cofre$")
	public void limpa_cofre() throws Exception {
		assertEquals("", cofrePM.getDisplay());
	}

	
}
