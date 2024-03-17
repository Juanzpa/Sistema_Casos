package sv.edu.udb.sistemas;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_caso";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Conexion() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_caso", "root", "");
    }
}
