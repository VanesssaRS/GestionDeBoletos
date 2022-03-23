package Model.Storage;

import Control.LoginManager;
import Model.Modulos.AdminBuses;
import Model.Modulos.AdminCooperativas;
import Model.Modulos.AdminUsuarios;
import Model.Modulos.AdminViajes;
import Model.Persona;
import Model.Usuarios.TipoUsuario;
import Model.Usuarios.Monto;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseManager {
    private static DataBaseManager dataBaseManager;
    private MySQL database = MySQL.getInstance();

    public DataBaseManager() {
    }

    public static DataBaseManager getInstance() {
        if (dataBaseManager == null) {
            dataBaseManager = new DataBaseManager();
        }
        return dataBaseManager;
    }

    public int login(String usuario,String contrasena){
        String sql = "{CALL login(?,?)}";
        int msg = 0;
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1,usuario);
            pp.setString(2, contrasena);

            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getInt("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return 0;
        }
    }

    public String updateViajes(AdminViajes viajes) {
        String sql = "{CALL actualizarViaje(?,?,?,?,?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setInt(1, viajes.getId_viaje());
            pp.setString(2, viajes.getNombreCooperativa());
            pp.setString(3, viajes.getBus());
            pp.setString(4, viajes.getPartida());
            pp.setString(5, viajes.getDestino());
            pp.setDate(6, new Date(viajes.getFecha().getTime()));
            pp.setString(7, viajes.getHora());
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getString("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return null;
        }
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
                        resultSet.getString("Nombre_Cooperativa"),
                        resultSet.getString("Placa"),
                        resultSet.getDouble("valor")));
            }
            resultSet.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public boolean deleteViaje(int id) {
        try {
            PreparedStatement statement = database.open().prepareStatement("DELETE FROM viaje WHERE id_viaje=" + id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
        }
        return false;

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

    public String insertBoleto(Monto monto, AdminViajes adminViajes, int numAsientos, int metodoPago, String asientos) {
        String sql = "{CALL crearBoleto(?,?,?,?,?,?,?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1, LoginManager.getLoggedPerson().getCedula());
            pp.setString(2, adminViajes.getNombreCooperativa());
            pp.setString(3, adminViajes.getPartida());
            pp.setString(4, adminViajes.getDestino());
            pp.setString(5, adminViajes.getHora());
            pp.setInt(6, numAsientos);
            pp.setInt(7, metodoPago);
            pp.setDouble(8, monto.getTotal());
            pp.setString(9, asientos);
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

    public String insertBoletoSinRegistro(String cedula, String Nombre, String apellido, Monto monto, AdminViajes adminViajes, int numAsientos, int metodoPago, String asientos) {
        String sql = "{CALL crearBoletoSinRegistro(?,?,?,?,?,?,?,?,?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1, cedula);
            pp.setString(2, Nombre);
            pp.setString(3, apellido);
            pp.setString(4, adminViajes.getNombreCooperativa());
            pp.setString(5, adminViajes.getPartida());
            pp.setString(6, adminViajes.getDestino());
            pp.setString(7, adminViajes.getHora());
            pp.setInt(8, numAsientos);
            pp.setInt(9, metodoPago);
            pp.setDouble(10, monto.getTotal());
            pp.setString(11, asientos);
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

    public String insertAsientosBuses(String bus, String asiento) {
        String sql = "{CALL agregarAsientos(?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setString(1, asiento);
            pp.setString(2, bus);
            pp.executeQuery();
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
            PreparedStatement statement = database.open().prepareStatement("DELETE FROM persona WHERE id_persona =" + id);
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
            ResultSet resultSet = statement.executeQuery("SELECT b.id, b.Placa,b.Num_Asientos, c.Nombre_Cooperativa FROM buses AS B inner join cooperativa c on B.id_cooperativa = c.id;");
            while (resultSet.next()) {
                list.add(new AdminBuses(resultSet.getInt("id"), resultSet.getString("Placa"), resultSet.getInt("Num_Asientos"), resultSet.getString("Nombre_Cooperativa")));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public ArrayList<String> getBusesPorCoop(String cooperativa) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "{CALL obtenerBusesPorCooperativa(?)}";
            CallableStatement callableStatement = database.open().prepareCall(sql);
            callableStatement.setString(1, cooperativa);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString("Placa"));
            }
            resultSet.close();
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
            pp.setInt(10, tipoUser);
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

    public String updateUsuario(int codigo, String cedula, String nombre, String apellido, String email, String telefono, Date date, String direccion, int tipoUser) {
        String sql = "{CALL actualizarUsuario(?,?,?,?,?,?,?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setInt(1, codigo);
            pp.setString(2, cedula);
            pp.setString(3, nombre);
            pp.setString(4, apellido);
            pp.setString(5, email);
            pp.setString(6, telefono);
            pp.setDate(7, date);
            pp.setString(8, direccion);
            pp.setInt(9, tipoUser);
            ResultSet rs = pp.executeQuery();
            while (rs.next()) {
                msg = rs.getString("Mensaje");
            }
            pp.close();
            return msg;
        } catch (SQLException ex) {
            ex.printStackTrace();
            database.close();
            return null;
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

    public AdminUsuarios getUsuario(String cedula) {
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persona where Cedula = '" + cedula + "'");
            while (resultSet.next()) {
                return new AdminUsuarios(
                        resultSet.getInt("id_persona"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Cedula"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telefono"),
                        new java.util.Date(resultSet.getDate("FechaNacimiento").getTime()),
                        resultSet.getString("Direccion"),
                        TipoUsuario.getOrdinal(resultSet.getInt("id_tipoUser")),
                        resultSet.getString("Apellido"));
            }
            resultSet.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return null;
    }

    public Persona getPersona(int id) {
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persona where id_persona = " + id );
            while (resultSet.next()) {
                return new Persona(resultSet.getInt("id_persona"),
                        resultSet.getString("Cedula"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Apellido"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telefono"),
                        resultSet.getString("Direccion"),
                        new java.util.Date(resultSet.getDate("FechaNacimiento").getTime()),
                        TipoUsuario.getOrdinal(resultSet.getInt("id_tipoUser")));
            }
            resultSet.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return null;
    }
    public ArrayList<String> getAsientos(String bus) {
        ArrayList<String> list = new ArrayList<>();
        try {
            Statement statement = database.open().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT asiento FROM asientosbuses where placaBus = '" + bus + "'");
            while (resultSet.next()) {
                list.add(resultSet.getString("asiento"));
            }
            resultSet.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        database.close();
        return list;
    }

    public String insertViajes(int cooperativa, String bus, String lugarpartida, String destino, long date, String hora, double valor) {
        String sql = "{CALL crearViaje(?,?,?,?,?,?,?)}";
        String msg = "";
        try {
            CallableStatement pp = database.open().prepareCall(sql);
            pp.setInt(1, cooperativa);
            pp.setString(2, bus);
            pp.setString(3, destino);
            pp.setString(4, lugarpartida);
            pp.setDate(5, new Date(date));
            pp.setString(6, hora);
            pp.setDouble(7, valor);
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

}
