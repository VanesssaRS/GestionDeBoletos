package Model.Storage;

import java.sql.*;


public class MySQL {
    private static MySQL instance;
    private Connection connection;


    public static MySQL getInstance(){
        if(instance == null){
            instance = new MySQL();
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
