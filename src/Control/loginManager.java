/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Storage.DataBaseManager;

/**
 *
 * @author FERNANDO
 */
public class loginManager {
    
    private static loginManager instance;
    private DataBaseManager databaseManager = DataBaseManager.getInstance();

    public loginManager() {
        
    }
    
    public static loginManager getinstance(){
        if(instance ==null){
            instance = new loginManager();
        }
        return instance;
    }
    
    public boolean login (String usuario, String contraseña){
        return databaseManager.Login(usuario, contraseña);
    }
    
}
