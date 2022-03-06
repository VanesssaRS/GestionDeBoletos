package Control.Administrador;

import Control.SingleCallBack;
import Control.Utils;
import Control.Validaciones;
import Model.Storage.DataBaseManager;
import Model.Usuarios.Administrador.Modulos.AdminViajes;

import java.util.HashMap;

public class ViajesManager {

    private static ViajesManager instance;
    public static HashMap<Integer, AdminViajes> viajesHashMap = new HashMap<>();

    public static ViajesManager getInstance(){
        if (instance == null){
            instance= new ViajesManager();
        }
        return instance;
    }

    /**
     * El metodo envia los parametros para insertarlos a la base de datos.
     * @param cooperativa Nombre cooperativa
     * @param lugarpartida Lugar de partida
     * @param destino Destino
     * @param date Fecha del viaje
     * @param hora Hora del viaje
     * @param callBack Informa si hubo fallo o no en el inserccion del documento
     */
    public void insertViaje(String cooperativa, String lugarpartida, String destino, long date , String hora, SingleCallBack callBack){
        int idCooperativa = Utils.getIdCooperativa(cooperativa);
        if (idCooperativa == 0) {
            callBack.onFailed();
            return;
        }
        String msg = DataBaseManager.getInstance().insertViajes(idCooperativa, lugarpartida, destino, date, hora);
        if(Validaciones.validarStrings(msg)){
            callBack.onSucces(msg);
            return;
        }
        callBack.onFailed();
    }
}
