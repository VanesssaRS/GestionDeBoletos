package Model.Usuarios;

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
            if (member.name().equalsIgnoreCase(index)) {
                return member;
            }
        }
        return null;
    }

    public static int getValueInt(String index) {
        for (TipoUsuario member : TipoUsuario.values()) {
            if (member.name().equalsIgnoreCase(index)) {
                return member.ordinal();
            }
        }
        return 0;
    }
}
