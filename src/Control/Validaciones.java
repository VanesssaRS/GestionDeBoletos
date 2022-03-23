package Control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    private static final Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
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

    /**
     * Verifica si es un Correo electronico
     * @param email String del valor a verfiicar
     * @return Verdadero si el valor es un Correo Electronico
     */
    public static boolean isEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
