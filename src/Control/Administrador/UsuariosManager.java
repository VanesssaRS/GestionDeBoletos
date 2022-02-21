package Control.Administrador;


import Control.SingleCallBack;
import Model.Storage.DataBaseManager;
import Model.Usuarios.Administrador.Modulos.AdminCooperativas;
import Model.Usuarios.Administrador.Modulos.AdminUsuarios;
import Model.Usuarios.Administrador.Modulos.TipoUsuario;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class UsuariosManager {

    //public static HashMap<Integer, AdminUsuarios> usuariosHashMap = new HashMap<>();
    private static UsuariosManager instace;

    public static UsuariosManager getInstance() {
        if (instace == null) {
            instace = new UsuariosManager();
        }
        return instace;
    }

    public void ingresarUsuario(String nombre, String apellido, String cedula, String email, String telefono, Date date, String direccion, String usuario, String contrasena, String tipoUser, SingleCallBack callBack) {
        TipoUsuario tpouser = TipoUsuario.getValue(tipoUser);
        if (tpouser != null && DataBaseManager.getInstance().insertarUsuario(nombre, apellido, cedula, email, telefono, date, direccion, usuario, contrasena, tpouser.ordinal())) {
            callBack.onSucces();
            return;
        }
        callBack.onFailed();
    }

    /**
     * Guarda los datos obtenidos en el HashMap para mantenerlos en cache.
     *
     * @return Retorna una lista de las Usuarios obtenidad en base de datos.
     */
    public ArrayList<AdminUsuarios> getListUsuarios() {
        ArrayList<AdminUsuarios> list = DataBaseManager.getInstance().getListUsuarios();
        /*if (list != null && list.size() > 0) {
            for (AdminUsuarios item : list) {
                cooperativasHashMap.put(item.getId(), item);
            }
        }*/
        return list;
    }

    public void deleteUsuarios(int id, SingleCallBack callBack) {
        if (DataBaseManager.getInstance().deleteUsuario(id)) {
            callBack.onSucces();
            return;
        }
        callBack.onFailed();
    }

    /**
     * Obtiene la lista del Enum TipoUsuario y los convierte a string.
     *
     * @return Retorna una lista de String.
     */
    public ArrayList<String> getDataSource() {
        ArrayList<String> list = new ArrayList<>();
        for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
            if (tipoUsuario.equals(TipoUsuario.CHOFER)) continue;
            list.add(tipoUsuario.name());
        }
        return list;
    }

    public void actualizarUsuario(String codigo, String cedula, String nombre, String apellido, String email, String telefono, Date date, String direccion, String tipoUser, SingleCallBack callBack) {
        TipoUsuario typeUser = TipoUsuario.getValue(tipoUser);
        if (typeUser != null && DataBaseManager.getInstance().updateUsuario(Integer.parseInt(codigo), cedula, nombre, apellido, email, Integer.parseInt(telefono), date, direccion, typeUser.name())) {
            callBack.onSucces();
            return;
        }
        callBack.onFailed();
    }


}
