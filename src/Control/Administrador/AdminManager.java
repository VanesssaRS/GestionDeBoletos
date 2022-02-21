package Control.Administrador;
import Control.SingleCallBack;
import Model.Storage.DataBaseManager;
import Model.Usuarios.Administrador.Modulos.AdminUsuarios;
import java.util.ArrayList;

import java.util.HashMap;

public class AdminManager {
    private static UsuariosManager instamce;
    public static HashMap<Integer, AdminUsuarios> usuariosHashMap = new HashMap<>();

    public AdminManager() {
    }

    public static UsuariosManager getInstance() {
        if (instamce == null) {
            instamce = new UsuariosManager();
        }
        return instamce;
    }
    //LISTA DE USUARIOS
    public ArrayList<AdminUsuarios> getListUsuarios() {
        ArrayList<AdminUsuarios> list = DataBaseManager.getInstance().getListUsuariosDb();
        if (!list.isEmpty()) {
            for (AdminUsuarios item : list) {
                usuariosHashMap.put(item.getId(), item);
            }
        }
        return list;
    }
    
}
