package cofre;

/**
 *
 * @author andreendo
 */
public class ValidacaoHelper {
    public static boolean ehNumero(String senha) {
        try {
            Integer.parseInt(senha);
            return true;
        }
        catch(NumberFormatException e){}
        return false;    
    }
    
    public static boolean ehSenhaValida(String senha) {
        if(senha.length() != 6)
            return false;
        
        return ehNumero(senha);
    }
}
