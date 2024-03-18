package sv.edu.udb.sistemas.Administrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class menuAdmin extends JFrame {
    private JPanel pnlmenuadmin;
    private JTabbedPane tabbedPane1;
    private JLabel lblTituloProgramador;
    private JTable tblProgramadores;
    DefaultTableModel modeloPogramadores = null;
    String[] columnaProgramadores;
    Object[][] datosProgramador;

    public menuAdmin(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlmenuadmin);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        columnaProgramadores = new String[] {"Nombre", "Apellido", "Cargo"};
        datosProgramador = new Object[][] {};
        modeloPogramadores = new DefaultTableModel(datosProgramador, columnaProgramadores);
        tblProgramadores.setModel(modeloPogramadores);

    }
    public static void main(String[] args) {
        JFrame frama = new menuAdmin("menuAdmin");
    frama.setVisible(true);
    }
}
