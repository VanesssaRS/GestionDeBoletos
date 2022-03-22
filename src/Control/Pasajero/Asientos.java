package Control.Pasajero;

public class Asientos {
    private String bus;
    private String placa;

    public Asientos(String bus, String placa) {
        this.bus = bus;
        this.placa = placa;
    }

    public String getBus() {
        return bus;
    }

    public String getPlaca() {
        return placa;
    }
}
