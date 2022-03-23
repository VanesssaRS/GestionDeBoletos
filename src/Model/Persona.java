package Model;

import Model.Usuarios.TipoUsuario;

import java.util.Date;

public class Persona {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private TipoUsuario tipoUsuario;

    public Persona(int id, String cedula, String nombre, String apellido, String correo, String telefono, String direccion, Date fechaNacimiento, TipoUsuario tipoUsuario) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoUsuario = tipoUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
