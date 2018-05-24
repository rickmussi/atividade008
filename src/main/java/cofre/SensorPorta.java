package cofre;

/**
 *
 * @author andreendo
 */
public interface SensorPorta {
    public boolean fechada();
    
    public boolean travada();
    
    public void travar();

    public void destravar();
}
