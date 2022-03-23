package Model.Modulos;

public class AdminCooperativas {
    private int id;
    private String nombreCooperativa;
    private String codProvincia;
    private int numBus;

    public AdminCooperativas(int id, String nombreCooperativa, String codProvincia, int numBus) {
        this.id = id;
        this.nombreCooperativa = nombreCooperativa;
        this.codProvincia = codProvincia;
        this.numBus = numBus;
    }

    public AdminCooperativas( String nombreCooperativa, String codProvincia, int numBus){
        this.nombreCooperativa = nombreCooperativa;
        this.codProvincia = codProvincia;
        this.numBus = numBus;
    }

    public int getId() {
        return id;
    }

    public String getNombreCooperativa() {
        return nombreCooperativa;
    }

    public String getCodProvincia() {
        return codProvincia;
    }

    public int getNumBus() {
        return numBus;
    }
}
