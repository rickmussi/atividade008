package bdd;

import cofre.CofrePM;
import cofre.CofrePMTest;
import cofre.Memoria;
import cofre.SensorPorta;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TravadoCofrePMTesteSteps extends CofrePMTest {
    SensorPorta sensorMock = null;
    Memoria memoriaMock = null;
    CofrePM cofrePM = null;
    
    @Given("^entrei com o numero (\\d+)$")
    public void entrei_com_o_numero(String senha) throws Exception {
    	sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
        
        when(memoriaMock.getSenha())
        .thenReturn(senha);
        when(sensorMock.fechada())
        .thenReturn(Boolean.TRUE);
        
        when(sensorMock.travada())
        .thenReturn(Boolean.TRUE);    

    }
    
@When("^eu precionei o destravar$")
public void eu_precionei_o_destravar() throws Exception {    
    cofrePM.pressButton(1);
    cofrePM.pressButton(2);
    cofrePM.pressButton(3);
    cofrePM.pressButton(4);
    cofrePM.pressButton(6);
    cofrePM.pressButton(6);
    
	cofrePM.ok();    
}

@Then("^a mensagem \"([^\"]*)\" deve aparecer$")
public void a_mensagem_deve_aparecer(String mensagem) throws Exception {
	assertEquals(mensagem, cofrePM.getDisplay());
}

@Then("^cofre sera aberto$")
public void cofre_sera_aberto() throws Exception {
	/*
	sensorMock = mock(SensorPorta.class);
	when(sensorMock.travada())
    .thenReturn(Boolean.FALSE);
	*/
   
}

@Then("^a mansagem \"([^\"]*)\" deve aparecer$")
public void a_mansagem_deve_aparecer(String mensagem) throws Exception {
	assertEquals(mensagem, cofrePM.getDisplay());
}

@Then("^o resultado deve ser tente novamente$")
public void o_resultado_deve_ser_tente_novamente() throws Exception {
	assertEquals("senha errada. Tente novamente", cofrePM.getDisplay());
}

}