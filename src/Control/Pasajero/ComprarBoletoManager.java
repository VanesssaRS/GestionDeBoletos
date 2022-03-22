package Control.Pasajero;

import Control.GenericCallBack;
import Control.SingleCallBack;
import Control.Validaciones;
import Model.Storage.DataBaseManager;
import Model.Usuarios.Administrador.Modulos.AdminUsuarios;
import Model.Usuarios.Administrador.Modulos.AdminViajes;
import Model.Usuarios.Monto;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ComprarBoletoManager {

    private static ComprarBoletoManager instace;
    private static final Set<String> asientos = new LinkedHashSet<>();

    public static ComprarBoletoManager getInstace() {
        if (instace == null) {
            instace = new ComprarBoletoManager();
        }
        return instace;
    }

    public void putAsiento(String asiento) {
        asientos.add(asiento);
    }

    public Set<String> getAsientos() {
        return asientos;
    }

    /**
     * Ingresa los datos a la base de datos.
     *
     * @param monto
     * @param adminViajes
     * @param numAsientos
     * @param metodoPago
     * @param callBack
     */
    public void insertarBoletos(String cedula, String nombre, String apellido, Monto monto, AdminViajes adminViajes, int numAsientos, int metodoPago, boolean isRegister, SingleCallBack callBack) {
        if (monto != null && adminViajes != null) {
            String msg;
            if (isRegister) {
                msg = DataBaseManager.getInstance().insertBoletoSinRegistro(cedula, nombre, apellido, monto, adminViajes, numAsientos, metodoPago, getStringAsientos());
            } else {
                msg = DataBaseManager.getInstance().insertBoleto(monto, adminViajes, numAsientos, metodoPago, getStringAsientos());
            }
            if (Validaciones.validarStrings(msg)) {
                insertarAsientos(adminViajes);
                callBack.onSucces(msg);
                return;
            }
        }
        callBack.onFailed();
    }

    public void insertarBoletos(String cedula, Monto monto, AdminViajes adminViajes, int numAsientos, int metodoPago, SingleCallBack callBack) {
        if (monto != null && adminViajes != null) {
            String msg;
            msg = DataBaseManager.getInstance().insertBoleto(monto, adminViajes, numAsientos, metodoPago, getStringAsientos());
            if (Validaciones.validarStrings(msg)) {
                insertarAsientos(adminViajes);
                callBack.onSucces(msg);
                return;
            }
        }
        callBack.onFailed();
    }


    public void getPersona(String cedula, GenericCallBack callBack) {
        AdminUsuarios adminUsuarios = DataBaseManager.getInstance().getUsuario(cedula);
        if (adminUsuarios != null) {
            callBack.onSucces(adminUsuarios);
            return;
        }
        callBack.onFailed();
    }

    /**
     * La lista de asientos guardado en cache se combierte en un String.
     *
     * @return Returna el string de asientos
     */
    public String getStringAsientos() {
        StringBuilder vale = new StringBuilder();
        for (String item : asientos) {
            vale.append(item).append(",");
        }
        return vale.toString();
    }

    /**
     * Ingresa los asientos que se va ocupar en la base de datos y tambien limpia el set asientos.
     *
     * @param adminViajes Datos del viaje se leccionado, se va usar para obtener el bus.
     */
    private void insertarAsientos(AdminViajes adminViajes) {
        for (String item : asientos) {
            DataBaseManager.getInstance().insertAsientosBuses(adminViajes.getBus(), item);
        }
        asientos.clear();
    }

    /**
     * Se obtiene una lista de asientos ocupados de un bus.
     *
     * @param placabus Placa del bus.
     * @return
     */
    public ArrayList<String> getListSeat(String placabus) {
        return (ArrayList<String>) DataBaseManager.getInstance().getAsientos(placabus).clone();
    }


}
