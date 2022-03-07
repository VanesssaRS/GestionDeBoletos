package Model.Usuarios.Administrador.Modulos;

import java.util.Date;

public class AdminUsuarios {
    int code;
    String nombre;
    String apellido;
    String cedula;
    String email;
    String telefono;
    Date fechanac;
    String direcc;
    TipoUsuario tipoUser;

    public AdminUsuarios(int code,String nombre, String cedula,String email,String telefono,Date fechanac,String direcc,TipoUsuario tipouser,String apellido) {
        this.code = code;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.telefono = telefono;
        this.fechanac = fechanac;
        this.direcc = direcc;
        this.tipoUser = tipouser;
    }

    public int getCode() {
        return code;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public String getDirecc() {
        return direcc;
    }

    public TipoUsuario getTipoUser() {
        return tipoUser;
    }
}
