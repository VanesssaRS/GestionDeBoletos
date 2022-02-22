/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Usuarios.Administrador.Modulos;

/**
 *
 * @author FERNANDO
 */
public class AdminChofer {
        private int id;
        private String cedula;
        private String apellido;
        private String nombre;
        private String correo;
        private String telefono;
        private String direccion;
        private String fechaNacimiento;
        private int idPerosna;

    public AdminChofer(int id, String cedula, String apellido, String nombre, String correo, String telefono, String direccion, String fechaNacimiento, int idPerosna) {
        this.id = id;
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.idPerosna = idPerosna;
    }

    public int getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getIdPerosna() {
        return idPerosna;
    }
        
        
}
