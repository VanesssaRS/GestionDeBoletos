package Control;

public class Validaciones {

    /**
     * Valida si un String es valido o no.
     *
     * @param valor Arreglo de Strings
     * @return Retorna true si cumple con las condificiones
     */
    public static boolean validarStrings(String... valor) {
        for (String item : valor) {
            if (item == null || item.equals("")) {
                return false;
            }
        }
        return true;
    }
}
