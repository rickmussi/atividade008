package cofre;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author andreendo
 */
public class DestravadoCofrePMTest extends CofrePMTest {
    
    @Before
    public void before() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);    
        
        //porta sempre destravada
        when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);        
    }
    
    @Test
    public void testInicializacao() {
        assertEquals("Entre com a senha 6 digitos", cofrePM.getDisplay());
        verify(sensorMock).destravar();
    }

    @Test
    public void testClear() {
        cofrePM.clear();
        
        assertEquals("", cofrePM.getDisplay());
    }

    
    @Test
    public void testPortaNaoFechada() {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
        
        for(int botao = 0; botao <=9; botao++) {
            cofrePM.pressButton(botao);
            assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
            cofrePM.clear();
        }
        
        cofrePM.ok();
        assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
    }
    
    @Test
    public void testDigitarUmNumeroPortaFechada() {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        
        cofrePM.pressButton(0);
        
        assertEquals("0", cofrePM.getDisplay());
    }
    
    @Test
    public void testGravarSenhaValidaPortaFechadaDestravada() {
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

        verify(sensorMock).travar();
        verify(memoriaMock).salvarSenha("193566");
    }       
    
    @Test
    public void testDigitarSenhaComMenosDeSeis() {
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        
        cofrePM.pressButton(1);
        assertEquals("1", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("senha precisa de 6 digitos. Tente novamente", cofrePM.getDisplay());
        
        cofrePM.pressButton(1);
        cofrePM.pressButton(1);
        assertEquals("11", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("senha precisa de 6 digitos. Tente novamente", cofrePM.getDisplay());        
    }     
    
    @Test
    public void testDigitarNumerosPortaFechadaEDepoisAbrirEDigitar() {
        //porta fechada
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        
        cofrePM.pressButton(9);
        cofrePM.pressButton(8);
        assertEquals("98", cofrePM.getDisplay());

        //abriu a porta
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
        
        cofrePM.pressButton(7);
        assertEquals("Feche a porta antes de digitar a senha", cofrePM.getDisplay());
        
        //porta fechada
        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);

        cofrePM.pressButton(7);
        assertEquals("7", cofrePM.getDisplay());

    }
}