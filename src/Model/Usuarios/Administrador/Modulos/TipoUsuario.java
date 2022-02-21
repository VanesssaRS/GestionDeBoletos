package Model.Usuarios.Administrador.Modulos;

public enum TipoUsuario {

    PASAJERO, VENDERDOR, CHOFER, ADMINISTRADOR;

    public static TipoUsuario getOrdinal(int index) {
        for (TipoUsuario member : TipoUsuario.values()) {
            if (member.ordinal() == index) {
                return member;
            }
        }
        return null;
    }

    public static TipoUsuario getValue(String index) {
        for (TipoUsuario member : TipoUsuario.values()) {
            if (member.name().equals(index)) {
                return member;
            }
        }
        return null;
    }
}
