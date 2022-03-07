package Model.Storage;

import Model.Usuarios.Administrador.Modulos.*;

import javax.xml.crypto.Data;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseManager {
    private static DataBaseManager dataBaseManager;
    private SQLite database = SQLite.getInstance();

    public DataBaseManager() {
    }

    public static DataBaseManager getInstance() {
        if (dataBaseManager == null) {
            dataBaseManager = new DataBaseManager();
        }
        return dataBaseManager;
    }

    public ArrayList<AdminViajes> getViajes() {
        ArrayList<AdminViajes> list = new ArrayList<>();
        try {
            String sql = "{CALL obtenerViajes()}";
            CallableStatement callableStatement = database.open().prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new AdminViajes(resultSet.getInt("id_viaje"),
                        resultSet.getString("Destino"),
                        resultSet.getString("Partida"),
                        new java.util.Date(resultSet.getDate("Fecha").getTime()),
                        resultSet.getString("Hora"),
                        resultSet.getString("Nombre_Cooperativa")));
            }
            resultSet.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public void deleteViaje(int id) {
        try {
            Statement statement = database.open().createStatement();
            statement.executeQuery("DELETE * FROM VIAJES WHERE id=" + id);
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
    }

    /**
     * Inggresa los datos a la DataBase
     *
     * @param nombre
     * @param codProvincia
     * @param numBuses
     * @return
     */
    public String insertCooperativa(String nombre, String codProvincia, int numBuses) {
        String sql = "{CALL crearCooperativa(?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1, nombre);
            pp.setString(2, codProvincia);
            pp.setDouble(3, numBuses);
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getString("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<AdminCooperativas> getCooperativas() {
        ArrayList<AdminCooperativas> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cooperativa");
            while (resultSet.next()) {
                list.add(new AdminCooperativas(resultSet.getInt("id"), resultSet.getString("Nombre_Cooperativa"), resultSet.getString("Codigo_Provincia"), resultSet.getInt("Buses_Disponibles")));
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public boolean updateCooperativa(String nombre, int codigo, int numBus, String codPovi) {
        String sql = "UPDATE cooperativa SET Nombre_Cooperativa=?, Codigo_Provincia=?, Buses_Disponibles=?  WHERE id=?";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, nombre);
            pp.setString(2, codPovi);
            pp.setDouble(3, numBus);
            pp.setDouble(4, codigo);
            pp.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return false;
        }
    }

    public boolean deleteCooperativa(int id) {
        try {
            PreparedStatement statement = database.open().prepareStatement("DELETE FROM cooperativa WHERE id=" + id);
            statement.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteUsuario(int id) {
        try {
            PreparedStatement statement = database.open().prepareStatement("DELETE FROM usuario WHERE id=" + id);
            statement.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<AdminBuses> getListBusesDb() {
        ArrayList<AdminBuses> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM buses");
            while (resultSet.next()) {
                list.add(new AdminBuses(resultSet.getInt("id"), resultSet.getString("Placa"), resultSet.getInt("Num_Asientos"), resultSet.getInt("id_cooperativa")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public String insertBusesAfiliados(String placa, int asientos, int cooperativa) {
        String sql = "{CALL crearBuses(?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1, placa);
            pp.setInt(2, asientos);
            pp.setInt(3, cooperativa);
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getString("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean upadateBuses(int codigo, int asientos, String placa, int cooperativa) {
        String sql = "UPDATE buses SET Placa=?, Num_Asientos=?, id_cooperativa=?  WHERE id=?";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, placa);
            pp.setInt(2, asientos);
            pp.setInt(3, cooperativa);
            pp.setInt(4, codigo);
            pp.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return false;
        }
    }

    public boolean deleteBus(int id) {
        try {
            PreparedStatement statement = database.open().prepareStatement("DELETE FROM buses WHERE id=" + id);
            statement.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String insertarUsuario(String nombre, String apellido, String cedula, String email, String telefono, Date date, String direccion, String usuario, String contrasena, int tipoUser) {
        String sql = "CALL crearUsuario(?,?,?,?,?,?,?,?,?,?)";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1, usuario);
            pp.setString(2, contrasena);
            pp.setString(3, nombre);
            pp.setString(4, apellido);
            pp.setString(5, cedula);
            pp.setString(6, email);
            pp.setString(7, telefono);
            pp.setDate(8, date);
            pp.setString(9, direccion);
            pp.setInt(10, tipoUser+1);
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getString("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean updateUsuario(int codigo, String cedula, String nombre, String apellido, String email, int telefono, Date date, String direccion, String tipoUser) {
        String sql = "UPDATE Persona SET Nombre=? ,Cedula=? ,Email=? ,Telefono=? ,FechaNac=? ,Direccion=? ,TipoUser=? ,Apellido=?  WHERE id=?";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, nombre);
            pp.setString(2, cedula);
            pp.setString(3, email);
            pp.setInt(4, telefono);
            pp.setDate(5, date);
            pp.setString(6, direccion);
            pp.setInt(7, 1);
            pp.setString(8, apellido);
            pp.setInt(9, codigo);
            pp.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return false;
        }
    }

    public ArrayList<AdminUsuarios> getListUsuarios() {
        ArrayList<AdminUsuarios> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persona");
            while (resultSet.next()) {
                list.add(new AdminUsuarios(
                        resultSet.getInt("id_persona"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Cedula"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telefono"),
                        new java.util.Date(resultSet.getDate("FechaNacimiento").getTime()),
                        resultSet.getString("Direccion"),
                        TipoUsuario.getOrdinal(resultSet.getInt("id_tipoUser")),
                        resultSet.getString("Apellido")));
            }
            resultSet.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public String insertViajes(int cooperativa, String lugarpartida, String destino, long date, String hora) {
        String sql = "{CALL crearViaje(?,?,?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setInt(1, cooperativa);
            pp.setString(2, destino);
            pp.setString(3, lugarpartida);
            pp.setDate(4, new Date(date));
            pp.setString(5, hora);
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getString("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


/*
    //-----------------------------------USUARIOS---------------------------------------------

    //INSERTAR USUARIO
    public boolean insertUsuario(String nombre, String apellido, String cedula, String email,
                                 String telefono, String fechaNacimiento, String direccion, String usuario, String contraseña, int idUsuario) {
        String sql = "INSERT INTO usuario(Cedula, Apellido, Nombre, Correo, Telefono, Direccion, "
                + "Fecha_Nacimiento, Persona_Id_Persona) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, nombre);
            pp.setString(2, apellido);
            pp.setString(3, cedula);
            pp.setString(4, email);
            pp.setString(5, telefono);
            pp.setString(6, fechaNacimiento);
            pp.setString(7, direccion);
            pp.setString(8, usuario);
            pp.setString(9, contraseña);
            pp.setInt(10, idUsuario);
            pp.executeUpdate();
            pp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //LISTA DE USUARIOS
    public ArrayList<AdminUsuarios> getListUsuariosDb() {
        ArrayList<AdminUsuarios> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSONA");
            while (resultSet.next()) {
                list.add(new AdminUsuarios(resultSet.getInt("id"), resultSet.getString("Cedula"),
                        resultSet.getString("Apellido"), resultSet.getString("Nombre"),
                        resultSet.getString("Correo"), resultSet.getString("Telefono"),
                        resultSet.getString("Direccion"), resultSet.getString("Fecha_Nacimiento"),
                        resultSet.getString("Usuario"), resultSet.getString("Contraseña"),
                        resultSet.getInt("Persona_Id_Persona")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    //UPDATE USUARIOS (ACTUALIZAR)
    public boolean upadateUsuarioString(String nombre, String apellido, String cedula, String email,
                                        String telefono, String fechaNacimiento, String direccion, String usuario, String contraseña, int idUsuario) {
        String sql = "UPDATE PERSONA SET Cedula=?, Apellido=?, Nombre=?, Correo=?, Telefono=?, "
                + "Direccion=?, Fecha_Nacimiento=?, Persona_Id_Persona=? WHERE id=?";

        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, nombre);
            pp.setString(2, apellido);
            pp.setString(3, cedula);
            pp.setString(4, email);
            pp.setString(5, telefono);
            pp.setString(6, fechaNacimiento);
            pp.setString(7, direccion);
            pp.setString(8, usuario);
            pp.setString(9, contraseña);
            pp.setInt(10, idUsuario);
            pp.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return false;
        }
    }

//ELIMINAR USUARIO


    //-----------------------------------CHOFER---------------------------------------------
        //LISTA DE CHOFER
    public ArrayList<AdminChofer> getListChoferDb(){
        ArrayList<AdminChofer> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSONA");
            while (resultSet.next()) {
                list.add(new AdminChofer(resultSet.getInt("id"), resultSet.getString("Cedula"), 
                        resultSet.getString("Apellido"), resultSet.getString("Nombre"), 
                        resultSet.getString("Correo"), resultSet.getString("Telefono"), 
                        resultSet.getString("Direccion"), resultSet.getString("Fecha_Nacimiento"), 
                        resultSet.getInt("Persona_Id_Persona")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }
    
        //INSERTAR PASAJERO
    public boolean insertChofer(String nombre, String apellido, String cedula, String email, 
            String telefono, String fechaNacimiento, String direccion, int idPersona) {
        String sql = "INSERT INTO PERSONA(Cedula, Apellido, Nombre, Correo, Telefono, Direccion, "
                + "Fecha_Nacimiento, Persona_Id_Persona) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, nombre);
            pp.setString(2, apellido);
            pp.setString(3, cedula);
            pp.setString(4, email);
            pp.setString(5, telefono);
            pp.setString(6, fechaNacimiento);
            pp.setString(7, direccion);
            pp.setInt(8, idPersona);
            pp.executeUpdate();
            pp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
*/

//-----------------------------------INICIAR SESION---------------------------------------------

    public boolean Login(String nombre, String contraseña) {

        boolean respuesta = false;

        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIO WHERE usuario='" + nombre + "' AND clave='" + contraseña + "'");
            while (resultSet.next()) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            respuesta = false;
        } finally {
            database.close();
        }
        database.close();
        return respuesta;
    }
}
