package sv.edu.udb.sistemas.JefesDesarrollo;

import com.mysql.cj.log.NullLogger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JefesDesarrollo extends JFrame {
    private JPanel pnlJefesDesarrollo;
    private JTabbedPane tabbedPane1;
    private JLabel lblpa;
    private JButton btnCerrarSesion;
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
    private JTextField txtFecha;
    private JTextArea txtaDescripcion;
    private JTable tblProgramador;
    private JButton btnEnviar;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JTextField txtProbador;
    private JTable tblProbador;
    private JButton btnEnviarProbador;
    private JLabel lblGestion;
    private JLabel lblSolicitud;
    private JLabel lblComentario;
    private JLabel lblProgramador;
    private JLabel lblSelectPr;
    private JLabel lblCasoAsignar;
    private JLabel lblFechaLimite;
    private JLabel lblProbasor;
    private JPanel lblSeleccionProb;
    private JLabel lblSelectCaso;
    private JLabel lblFechaSolic;
    private JComboBox comboBox6;
    private JPanel JpanelCasos;
    DefaultTableModel modelo = null;

    public JefesDesarrollo(String title) {
        super(title);
        setTitle("Panel de Jefe de Desarrollo");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(pnlJefesDesarrollo);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(getParent());

        Object[][] data = null;

        String[] columns = {
                "IdCaso", "Titulo", "Descripcion", "Fecha Solicitud", "Fecha Limite", "Estado"
        };

        modelo = new DefaultTableModel(data, columns);

        tblCasosAsig.setModel(modelo);


        btnAbrirCasos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tabbedPane1.setSelectedIndex(1);
            }
        });

        setVisible(true);
        btnGestionarCasos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(0);
            }
        });
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEnviarProbador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }




    public static void main(String[] args) {
      JefesDesarrollo jefesDesarrollo = new JefesDesarrollo(null);

    }




}


