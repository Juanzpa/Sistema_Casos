package sv.edu.udb.sistemas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JButton btnIngresaL;
    private JPanel pnlLogin;
    private JLabel lblLogin;
    private JTextField txtUsuario;
    private JTextField txtClave;
    private JButton btnIngresar;
    private JLabel lblUsuario;
    private JLabel lblClave;
    private JLabel lblIcono;


    public Login(String title){
        super(title);
        setTitle("Panel de Jefe de Desarrollo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(pnlLogin);
        setSize(800, 600);
        this.setLocationRelativeTo(getParent());
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args){
        Login login = new Login(null);

        login.setVisible(true);
    }
}
