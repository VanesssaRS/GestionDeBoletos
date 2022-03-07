package Model.Usuarios.Administrador.Modulos;

import java.sql.Timestamp;
import java.util.Date;

public class AdminViajes {
    private int id_viaje;
    private String destino;
    private String partida;
    private Date fecha;
    private String hora;
    private String nombreCooperativa;

    public AdminViajes(int id_viaje, String destino, String partida, Date fecha, String hora, String nombreCooperativa) {
        this.id_viaje = id_viaje;
        this.destino = destino;
        this.partida = partida;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreCooperativa = nombreCooperativa;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public String getDestino() {
        return destino;
    }

    public String getPartida() {
        return partida;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getNombreCooperativa() {
        return nombreCooperativa;
    }
}
