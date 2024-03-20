package sv.edu.udb.sistemas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    private JButton btnIngresaL;

    private JPanel pnlLogin;
    private JLabel lblLogin;
    private JTextField txtUsuario;
    private JTextField txtClave; // Cambiado a JTextField
    private JButton btnIngresar;
    private JLabel lblUsuario;
    private JLabel lblClave;
    private JLabel lblIcono;


    public Login(String title){
        super(title);

        setTitle("Inicio de sesión");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(pnlLogin);
        setSize(400, 300);
        setLocationRelativeTo(null);
//as

        setTitle("Panel de Jefe de Desarrollo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(pnlLogin);
        setSize(800, 600);
        this.setLocationRelativeTo(getParent());

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String clave = txtClave.getText();


                try {

                    
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3326/sistema_caso", "root", "");

                    String sql = "SELECT * FROM empleados WHERE NombreUsuario = ? AND Contrasenia = ?";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, usuario);
                    statement.setString(2, clave);
                    ResultSet resultSet = statement.executeQuery();


                    if (resultSet.next()) {

                        int idCargo = resultSet.getInt("IdCargo");

                        switch (idCargo) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Caso 1: Eres Admin");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Caso 2: Eres Jefe Funcional");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Caso 3: Eres jefe de desarrollo");
                                break;
                            case 4:
                                JOptionPane.showMessageDialog(null, "Caso 4: Eres Tester");
                                break;
                            case 5:
                                JOptionPane.showMessageDialog(null, "Caso 5: Eres Programador");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Cargo no reconocido");
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
                }
            }
        });
    }

    public static void main(String[] args){
        Login login = new Login(null);

        login.setVisible(true);
    }
}
