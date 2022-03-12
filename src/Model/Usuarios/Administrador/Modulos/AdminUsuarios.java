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

    public AdminUsuarios(){

    }

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

    public void setCode(int code) {
        this.code = code;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public void setTipoUser(TipoUsuario tipoUser) {
        this.tipoUser = tipoUser;
    }
}
