package Model.Storage;

import Model.Usuarios.Administrador.Modulos.AdminBuses;
import Model.Usuarios.Administrador.Modulos.AdminCooperativas;
import Model.Usuarios.Administrador.Modulos.AdminUsuarios;
import Model.Usuarios.Administrador.Modulos.AdminViajes;

import javax.xml.crypto.Data;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM VIAJES");
            while (resultSet.next()) {
                list.add(new AdminViajes(resultSet.getInt("id"), resultSet.getDate("FechaDate"), resultSet.getTimestamp("Horario"), resultSet.getInt("ruta_Id_Ruta")));
            }
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
    public boolean insertCooperativa(String nombre, String codProvincia, int numBuses) {
        String sql = "INSERT INTO cooperativa(Nombre_Cooperativa,Cod_Provincia,Num_Bus) VALUES(?,?,?)";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, nombre);
            pp.setString(2, codProvincia);
            pp.setDouble(3, numBuses);
            pp.executeUpdate();
            pp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<AdminCooperativas> getCooperativas() {
        ArrayList<AdminCooperativas> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cooperativa");
            while (resultSet.next()) {
                list.add(new AdminCooperativas(resultSet.getInt("id"), resultSet.getString("Nombre_Cooperativa"), resultSet.getString("Cod_Provincia"), resultSet.getInt("Num_Bus")));
            }
            return list;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public boolean updateCooperativa(String nombre, int codigo, int numBus, String codPovi) {
        String sql = "UPDATE cooperativa SET Nombre_Cooperativa=?, Cod_Provincia=?, Num_Bus=?  WHERE id=?";
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
            PreparedStatement statement = database.open().prepareStatement( "DELETE FROM Persona WHERE id=" + id );
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
                list.add(new AdminBuses(resultSet.getInt("id"), resultSet.getString("Placa_Bus"), resultSet.getInt("numAsientos"), resultSet.getInt("id_cooperativa")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public boolean insertBusesAfiliados(String placa,int asientos, int cooperativa) {
        String sql = "INSERT INTO buses(Placa_Bus,numAsientos,id_cooperativa) VALUES(?,?,?)";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, placa);
            pp.setInt(2, asientos);
            pp.setInt(3, cooperativa);
            pp.executeUpdate();
            pp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean upadateBuses(int codigo,int asientos,String placa, int cooperativa ) {
        String sql = "UPDATE buses SET Placa_Bus=?, numAsientos=?, id_cooperativa=?  WHERE id=?";
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

    public boolean insertarUsuario(String nombre, String apellido, String cedula, String email, String telefono, Date date, String direccion, String usuario, String contrasena, int tipoUser) {
        String sql = "INSERT INTO Persona(Nombre,Cedula,Email,Telefono,FechaNac,Direccion,TipoUser,Apellido) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pp.setString(1, nombre);
            pp.setString(2, cedula);
            pp.setString(3, email);
            pp.setInt(4, Integer.parseInt(telefono));
            pp.setDate(5, date);
            pp.setString(6, direccion);
            pp.setInt(7, 1);
            pp.setString(8, apellido);
            pp.executeUpdate();
            ResultSet rs = pp.getGeneratedKeys();
            int id = rs.getInt(1);
            pp.close();
            PreparedStatement pp2 = database.open().prepareStatement("INSERT INTO Usuario(usuario,clave,id_persona) values(?,?,?)");
            pp2.setString(1, usuario);
            pp2.setString(2, contrasena);
            pp2.setInt(3, id);
            pp2.executeUpdate();
            pp2.close();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Persona");
            while (resultSet.next()) {
                list.add(new AdminUsuarios(
                        resultSet.getInt("id"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Cedula"),
                        resultSet.getString("Email"),
                        resultSet.getInt("Telefono"),
                        new java.util.Date(Long.parseLong(resultSet.getString("FechaNac"))),
                        resultSet.getString("Direccion"),
                        TipoUsuario.getOrdinal(resultSet.getInt("TipoUser")),
                        resultSet.getString("Apellido")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public boolean insertViajes(String cooperativa, String lugarpartida, String destino,long date ,String hora) {
        String sql = "INSERT INTO insert(Cooperativa,LugarPartida,Destino,Fecha,Hora) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pp = database.open().prepareStatement(sql);
            pp.setString(1, cooperativa);
            pp.setString(2, lugarpartida);
            pp.setString(3, destino);
            pp.setDate(4, new Date(date));
            pp.setString(5, hora);

            pp.executeUpdate();
            pp.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    //-----------------------------------USUARIOS---------------------------------------------

    //INSERTAR USUARIO
    public boolean insertUsuario(String nombre, String apellido, String cedula, String email,
            String telefono, String fechaNacimiento, String direccion, String usuario ,String contraseña , int idUsuario) {
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
    public ArrayList<AdminUsuarios> getListUsuariosDb(){
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
            String telefono, String fechaNacimiento, String direccion, String usuario ,String contraseña , int idUsuario){
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

        public boolean deleteUsuario(int id) {
        try {
            PreparedStatement statement = database.open().prepareStatement("DELETE FROM PERSONA WHERE id=" + id);
            statement.executeUpdate();
            database.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
