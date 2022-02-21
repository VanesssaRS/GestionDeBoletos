package Model.Usuarios.Administrador.Modulos;
import Model.Persona;

public class AdminUsuarios {
        private int id;
        private String cedula;
        private String apellido;
        private String nombre;
        private String correo;
        private String telefono;
        private String direccion;
        private String fechaNacimiento;
        private String usuario;
        private String contraseña;
        private int idUsuario;

    public AdminUsuarios(int id, String cedula, String apellido, String nombre, String correo, String telefono, String direccion, String fechaNacimiento, String usuario, String contraseña, int idUsuario) {
        this.id = id;
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.idUsuario = idUsuario;
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

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

}
