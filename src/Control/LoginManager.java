/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Persona;
import Model.Storage.DataBaseManager;

/**
 *
 * @author FERNANDO
 */
public class LoginManager {
    
    private static LoginManager instance;
    private DataBaseManager databaseManager = DataBaseManager.getInstance();
    private static Persona loggedPerson;

    public LoginManager() {
        
    }
    
    public static LoginManager getinstance(){
        if(instance ==null){
            instance = new LoginManager();
        }
        return instance;
    }

    public boolean login(String usuario, String contrasena){
        int id_persona = databaseManager.login(usuario,contrasena);
        if ( id_persona == 0){
            return false;
        }
        Persona pasajero = databaseManager.getPersona(id_persona);
        if(pasajero != null){
            System.out.println(pasajero.getCedula()+" : "+pasajero.getTipoUsuario());
            loggedPerson = pasajero;
            return true;
        }
        return false;
    }

    public static Persona getLoggedPerson(){
        return loggedPerson;
    }


    
}
