package Control.Administrador;

import Control.SingleCallBack;
import Model.Storage.DataBaseManager;
import Model.Usuarios.Administrador.Modulos.AdminBuses;
import Model.Usuarios.Administrador.Modulos.AdminCooperativas;

import java.util.ArrayList;
import java.util.HashMap;

public class BusesManager {
    private static BusesManager instamce;
    public static HashMap<Integer, AdminBuses> busesManager = new HashMap<>();


    public static BusesManager getInstance() {
        if (instamce == null) {
            instamce = new BusesManager();
        }
        return instamce;
    }

    public ArrayList<AdminBuses> getListBuses() {
        ArrayList<AdminBuses> list = DataBaseManager.getInstance().getListBusesDb();
        if (!list.isEmpty()) {
            for (AdminBuses item : list) {
                busesManager.put(item.getId(), item);
            }
        }
        return list;
    }

    public void agregarBusAfiliado(String placa, int asientos, String cooperativa, SingleCallBack callBack) {
        int idCooperativa = getIdByName(cooperativa);
        if (idCooperativa == 0) {
            callBack.onFailed();
            return;
        }
        String msg = DataBaseManager.getInstance().insertBusesAfiliados(placa, asientos, idCooperativa);
        if (msg != null && !msg.equals("")) {
            callBack.onSucces(msg);
            return;
        }
        callBack.onFailed();
    }

    private int getIdByName(String nameCoop) {
        for (AdminCooperativas item : CooperativasManager.getInstance().getListCooperativas()) {
            if (item.getNombreCooperativa().equalsIgnoreCase(nameCoop)) {
                return item.getId();
            }
        }
        return 0;
    }

    public void updateBuses(int codigo, int asientos, String placa, String coop, SingleCallBack callBack) {
        int idCoop = getIdByName(coop);
        if (idCoop == 0) {
            callBack.onFailed();
            return;
        }

        if (DataBaseManager.getInstance().upadateBuses(codigo, asientos, placa, idCoop)) {
            callBack.onSucces("Se ha actualizado correctamente");
            return;
        }
        callBack.onFailed();
    }

    public void deleteBus(int id, SingleCallBack callBack){
        if(DataBaseManager.getInstance().deleteBus(id)){
            callBack.onSucces("Se ha eliminado correctament");
        }
    }

}
