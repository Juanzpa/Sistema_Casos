package sv.edu.udb.sistemas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame {

    private JPanel pnlLogin;
    private JLabel lblLogin;
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;

    public Login(String title) {
        super(title);
        setTitle("Inicio de sesión");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(pnlLogin);
        setSize(400, 300);
        setLocationRelativeTo(null);
//as
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String clave = new String(txtClave.getPassword());


                if (validarCredenciales(usuario, clave)) {
                    JOptionPane.showMessageDialog(Login.this, "Inicio de sesión exitoso");
                    //
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean validarCredenciales(String usuario, String clave) {

        try (Connection conn = Conexion.getConnection()) {
            String sql = "SELECT * FROM empleados WHERE NombreUsuario = ? AND Contrasenia = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, usuario);
                stmt.setString(2, clave);
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login("Inicio de sesión");
            login.setVisible(true);
        });
    }
}
