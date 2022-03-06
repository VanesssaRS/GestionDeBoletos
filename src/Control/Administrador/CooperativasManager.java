package Control.Administrador;

import Control.SingleCallBack;
import Model.Storage.DataBaseManager;
import Model.Storage.SQLite;
import Model.Usuarios.Administrador.Administrador;
import Model.Usuarios.Administrador.Modulos.AdminBuses;
import Model.Usuarios.Administrador.Modulos.AdminCooperativas;

import java.util.ArrayList;
import java.util.HashMap;

public class CooperativasManager {

    public static HashMap<Integer, AdminCooperativas> cooperativasHashMap = new HashMap<>();
    private static CooperativasManager instance;
    private DataBaseManager dataBaseManager = DataBaseManager.getInstance();

    public CooperativasManager() {
    }

    public static CooperativasManager getInstance() {
        if (instance == null) {
            instance = new CooperativasManager();
        }
        return instance;
    }

    /**
     * @param nombre       Nombre de la cooperativa.
     * @param codProvincia Codigo de pronvincia de la cooperativa.
     * @param nBuses       Numero de buses de la cooperativa.
     * @param callBack     Informa el estado de la consulta en la base de datos.
     */
    public void agregarDatos(String nombre, String codProvincia, int nBuses, SingleCallBack callBack) {
        String mensaje = dataBaseManager.insertCooperativa(nombre, codProvincia, nBuses);
        if (mensaje != null && !mensaje.equalsIgnoreCase("")) {
            callBack.onSucces(mensaje);
            return;
        }
        callBack.onFailed();
    }

    /**
     * Guarda los datos obtenidos en el HashMap para mantenerlos en cache.
     *
     * @return Retorna una lista de las Cooperativas obtenidad en base de datos.
     */
    public ArrayList<AdminCooperativas> getListCooperativas() {
        return dataBaseManager.getCooperativas();
    }

    public void updateCooperativa(String nombre, int codigo, int numBuses, String codProvi, SingleCallBack callBack) {
        if (dataBaseManager.updateCooperativa(nombre, codigo, numBuses, codProvi)) {
            callBack.onSucces("Se ha actualizado correctamente");
            return;
        }
        callBack.onFailed();
    }

    public void deleteCooperativa(int id, SingleCallBack callBack){
        if(dataBaseManager.deleteCooperativa(id)){
            callBack.onSucces("Elimminado correctamente");
            return;
        }
        callBack.onFailed();
    }


}
