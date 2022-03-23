package Control.Administrador;


import Control.SingleCallBack;
import Control.Validaciones;
import Model.Storage.DataBaseManager;
import Model.Modulos.AdminUsuarios;
import Model.Usuarios.TipoUsuario;

import java.sql.Date;
import java.util.ArrayList;

public class UsuariosManager {

    //public static HashMap<Integer, AdminUsuarios> usuariosHashMap = new HashMap<>();
    private static UsuariosManager instace;

    public static UsuariosManager getInstance() {
        if (instace == null) {
            instace = new UsuariosManager();
        }
        return instace;
    }

    /**
     * Se prepara para enviar los datos a la base de datos.
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param email
     * @param telefono
     * @param date
     * @param direccion
     * @param usuario
     * @param contrasena
     * @param tipoUser
     * @param callBack
     */
    public void ingresarUsuario(String nombre, String apellido, String cedula, String email, String telefono, Date date, String direccion, String usuario, String contrasena, String tipoUser, SingleCallBack callBack) {
        TipoUsuario tpouser = TipoUsuario.getValue(tipoUser.trim());
        if (tpouser != null) {
            String msg = DataBaseManager.getInstance().insertarUsuario(nombre, apellido, cedula, email, telefono, date, direccion, usuario, contrasena, tpouser.ordinal());
            if (Validaciones.validarStrings(msg)) {
                callBack.onSucces(msg);
            }
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
            callBack.onSucces("Se ha eliminado al usuario correctamente");
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
            if (tipoUsuario.equals(TipoUsuario.CHOFER)){
                continue;
            }
            list.add(tipoUsuario.name());
        }
        return list;
    }

    public void actualizarUsuario(int codigo, String cedula, String nombre, String apellido, String email, String telefono, Date date, String direccion, String tipoUser, SingleCallBack callBack) {
        int typeUser = TipoUsuario.getValueInt(tipoUser);
        if (typeUser > 0) {
            String msg = DataBaseManager.getInstance().updateUsuario(codigo, cedula, nombre, apellido, email, telefono, date, direccion, typeUser);
            if (Validaciones.validarStrings(msg)) {
                callBack.onSucces("Se ha actualizado el usuario correctamtente");
                return;
            }
        }
        callBack.onFailed();
    }


}
