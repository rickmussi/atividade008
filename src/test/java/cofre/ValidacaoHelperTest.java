package cofre;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreendo
 */
public class ValidacaoHelperTest {
    
    public ValidacaoHelperTest() {
    }

    @Test
    public void testEhNumero() {
        
        assertTrue( ValidacaoHelper.ehNumero("123") );
        assertTrue( ValidacaoHelper.ehNumero("1234444") );
        
        assertFalse( ValidacaoHelper.ehNumero("") );
        assertFalse( ValidacaoHelper.ehNumero("123aaaa") );
    }
    
    @Test
    public void testEhSenhaValida() {
        
        assertFalse( ValidacaoHelper.ehSenhaValida("123") );
        assertFalse( ValidacaoHelper.ehSenhaValida("1") );
        assertFalse( ValidacaoHelper.ehSenhaValida("12345") );
        assertFalse( ValidacaoHelper.ehSenhaValida("12345a") );
        
        assertTrue( ValidacaoHelper.ehSenhaValida("123999") );
    }    
}
