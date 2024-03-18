package sv.edu.udb.sistemas.Administrador;

import javax.swing.*;
import java.awt.*;

public class menuAdmin extends JFrame {
    private JPanel pnlmenuadmin;
    private JTabbedPane tabbedPane1;

    public menuAdmin(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlmenuadmin);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
    }
    public static void main(String[] args) {
        JFrame frama = new menuAdmin("menuAdmin");
    frama.setVisible(true);
    }
}
