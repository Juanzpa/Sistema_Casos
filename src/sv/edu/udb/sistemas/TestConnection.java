package sv.edu.udb.sistemas;
import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Obtener la conexión
            conn = Conexion.getConnection();

            // Verificar si la conexión es nula o no
            if (conn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("No se pudo establecer conexión a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            Conexion.close(conn);
        }
    }
}
