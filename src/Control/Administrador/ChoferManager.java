/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.Administrador;
import Control.SingleCallBack;
import Model.Storage.DataBaseManager;
import Model.Usuarios.Administrador.Modulos.AdminChofer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author FERNANDO
 */
public class ChoferManager {
    private static UsuariosManager instamce;
    public static HashMap<Integer, AdminChofer> usuariosHashMap = new HashMap<>();

    public ChoferManager() {
    }
    
     public static UsuariosManager getInstance() {
        if (instamce == null) {
            instamce = new UsuariosManager();
        }
        return instamce;
    }
    //LISTA DE USUARIOS
    public ArrayList<AdminChofer> getListChofer() {
        ArrayList<AdminChofer> list = DataBaseManager.getInstance().getListChoferDb();
        if (!list.isEmpty()) {
            for (AdminChofer item : list) {
                usuariosHashMap.put(item.getId(), item);
            }
        }
        return list;
    }
}
