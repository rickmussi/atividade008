package cofre;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author andreendo
 */
public class TravadoCofrePMTest extends CofrePMTest {
    
    @Before
    public void before() {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);    

        when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
        when(sensorMock.travada())
                .thenReturn(Boolean.TRUE);        
    }
      
    @Test
    public void testDigitarSenhaInvalida() {
        when(memoriaMock.getSenha())
                .thenReturn("123456");
        
        cofrePM.pressButton(1);
        cofrePM.pressButton(2);
        cofrePM.pressButton(3);
        cofrePM.pressButton(4);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
        assertEquals("123466", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("senha errada. Tente novamente", cofrePM.getDisplay());
    }
    
    @Test
    public void testDigitarSenhaComMenosDeSeis() {
        when(memoriaMock.getSenha())
                .thenReturn("123456");
        
        cofrePM.pressButton(1);
        assertEquals("1", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("senha errada. Tente novamente", cofrePM.getDisplay());
        
        cofrePM.pressButton(1);
        cofrePM.pressButton(1);
        assertEquals("11", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("senha errada. Tente novamente", cofrePM.getDisplay());        
    }    
    
    @Test
    public void testDigitarSenhaValida() {
        when(memoriaMock.getSenha())
                .thenReturn("123466");
        
        cofrePM.pressButton(1);
        cofrePM.pressButton(2);
        cofrePM.pressButton(3);
        cofrePM.pressButton(4);
        cofrePM.pressButton(6);
        cofrePM.pressButton(6);
        assertEquals("123466", cofrePM.getDisplay());
        
        cofrePM.ok();
        assertEquals("senha correta. Cofre aberto", cofrePM.getDisplay());
        
        verify(sensorMock, times(2)).destravar(); //destravar eh chamado pelo construtor tb
    }    
}
