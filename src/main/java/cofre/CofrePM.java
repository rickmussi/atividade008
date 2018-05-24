package cofre;

import static cofre.ValidacaoHelper.*;

/**
 *
 * @author andreendo
 */
public class CofrePM {
    private String display;
    private SensorPorta sensorPorta;
    private Memoria memoria;
    public static int OK = 99;

    public CofrePM(SensorPorta sensorPorta, Memoria memoria) {
        this.sensorPorta = sensorPorta;
        this.memoria = memoria;
        display = "Entre com a senha 6 digitos";
        this.sensorPorta.destravar();
    }
    
    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
    
    public void ok() {
        if(! sensorPorta.fechada())
            display = "Feche a porta antes de digitar a senha";
        else {
            if(sensorPorta.travada()) 
                realizarAbertura();
            else  
                realizarFechamento();
        }
    }

    private void realizarFechamento() {
        if(ehSenhaValida(display)) {
            memoria.salvarSenha(display);
            sensorPorta.travar();
            display = "Senha salva. Cofre trancado";
        }
        else 
            display = "senha precisa de 6 digitos. Tente novamente";
    }

    private void realizarAbertura() {
        String senhaSalva = memoria.getSenha();
        if(senhaSalva.equals(display)) {
            display = "senha correta. Cofre aberto";
            sensorPorta.destravar();
        }
        else
            display = "senha errada. Tente novamente";
    }
    
    public void clear() {
        display = "";
    }
    
    public void pressButton(int codigo) {
        if(! sensorPorta.fechada())
            display = "Feche a porta antes de digitar a senha";
        else {
            if(! ehNumero(display))
                display = "";
            
            display = display + String.valueOf(codigo);
        }
    }
}
