package Model.Usuarios.Administrador.Modulos;

public class AdminBuses {

    private int id;
    private String placaBus;
    private int numeroAsientos;
    private String idCooperativa;

    public AdminBuses(int id, String placaBus, int numeroAsientos, String idCooperativa) {
        this.id = id;
        this.placaBus = placaBus;
        this.numeroAsientos = numeroAsientos;
        this.idCooperativa = idCooperativa;
    }

    public String getIdCooperativa() {
        return idCooperativa;
    }

    public int getId() {
        return id;
    }

    public String getPlacaBus() {
        return placaBus;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }
}
