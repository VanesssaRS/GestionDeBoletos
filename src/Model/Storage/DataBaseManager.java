package Model.Storage;

import Model.Usuarios.Administrador.Modulos.AdminBuses;
import Model.Usuarios.Administrador.Modulos.AdminCooperativas;
import Model.Usuarios.Administrador.Modulos.AdminUsuarios;
import Model.Usuarios.Administrador.Modulos.AdminViajes;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public ArrayList<AdminBuses> getListBusesDb(){
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


    //-----------------------------------USUARIOS--------------------------------------
    
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
    
}
