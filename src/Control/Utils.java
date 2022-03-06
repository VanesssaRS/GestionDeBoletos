package Control;

import Control.Administrador.CooperativasManager;
import Model.Usuarios.Administrador.Modulos.AdminCooperativas;

public class Utils {
    /**
     *  Obtiene el id de la cooperativa
     * @param nameCoop Nombre de la cooperativa.
     * @return Retornar el id
     */
    public static int getIdCooperativa(String nameCoop) {
        for (AdminCooperativas item : CooperativasManager.getInstance().getListCooperativas()) {
            if (item.getNombreCooperativa().equalsIgnoreCase(nameCoop)) {
                return item.getId();
            }
        }
        return 0;
    }
}
