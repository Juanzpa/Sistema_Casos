package sv.edu.udb.sistemas;

import java.sql.*;

public class Conexion {
    private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //El puerto es opcional
    private static String JDBC_URL =
            "jdbc:mysql://localhost:3308/sistema_casos";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "";
    private static Driver driver = null;

    public static synchronized Connection getConnection() throws SQLException {
        Connection con = null;
        if (driver == null) {
            try {
                //Se registra el driver
                Class.forName(JDBC_DRIVER);
                //con = DriverManager.getConnection (
// JDBC_URL,JDBC_USER, JDBC_PASS);
            } catch (Exception e) {
                System.out.println("Fallo en cargar el driver JDBC");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,
                JDBC_PASS);
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
