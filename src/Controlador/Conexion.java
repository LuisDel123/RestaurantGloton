package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    Connection con;

    public Connection getConexion() {
        try {
            String myBD ="jdbc:mysql://localhost:3306/bd_gloton?serverTimezone=UTC";
            con=DriverManager.getConnection(myBD,"luis","luis");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }  
    
}
