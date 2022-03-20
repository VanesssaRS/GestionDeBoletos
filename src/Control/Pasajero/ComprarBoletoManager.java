package Control.Pasajero;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ComprarBoletoManager {

    private static ComprarBoletoManager instace;
    private static Set<String> asientos = new LinkedHashSet<>();

    public static ComprarBoletoManager getInstace(){
        if(instace == null){
            instace = new ComprarBoletoManager();
        }
        return instace;
    }

    public void putAsiento(String asiento){
        asientos.add(asiento);
    }

    public Set<String> getAsientos(){
        return asientos;
    }


}
