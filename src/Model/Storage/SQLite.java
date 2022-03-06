package Model.Storage;

import Model.Usuarios.Administrador.Modulos.AdminViajes;

import java.sql.*;


public class SQLite {
    private static SQLite instance;
    private Connection connection;


    public static SQLite getInstance(){
        if(instance == null){
            instance = new SQLite();
        }
        return instance;
    }

    public Connection open() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String user = "root";
            String pass = "callofduty1";
            String url = "jdbc:mysql://localhost:3306/dbo";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                System.out.println("Conexión exitosa!");
                return connection;
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.out.println("Error en la conexión");
        }
        return connection;
    }

    public void close() {
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
