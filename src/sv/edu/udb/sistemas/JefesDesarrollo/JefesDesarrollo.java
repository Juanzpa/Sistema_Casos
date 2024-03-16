package sv.edu.udb.sistemas.JefesDesarrollo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JefesDesarrollo extends JFrame {
    private JPanel pnlJefesAreaFuncional;
    private JTabbedPane tabbedPane1;
    private JLabel lblpa;
    private JButton cerrarSesionButton;
    private JLabel lblCasosAsig;
    private JTable tblCasosAsig;
    private JLabel lblCasosFin;
    private JTable tblCassosFinalizados;
    private JButton btnAbrirCasos;
    private JTable tblGestionCasos;
    private JButton btnGestionarCasos;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JTextArea textArea1;
    private JTable table1;
    private JButton enviarButton;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTextField textField2;
    private JTable table2;
    private JButton enviarButton1;
    DefaultTableModel modelo = null;

    public JefesDesarrollo(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlJefesAreaFuncional);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        Object [][] data=null;

        String[] columns = {
                "IdCaso", "Titulo", "Descripcion", "Fecha Solicitud", "Fecha Limite", "Estado"
        };

        modelo = new DefaultTableModel(data, columns);

        tblCasosAsig.setModel(modelo);

    }

    public static void main(String[] args) {
        JFrame frame = new JefesDesarrollo("Panel de Jefe de Desarrollo");
        frame.setVisible(true);
    }

}
