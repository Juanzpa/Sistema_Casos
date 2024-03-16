package sv.edu.udb.sistemas.JefesDesarrollo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
    DefaultTableModel modelo = null;

    public JefesDesarrollo(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlJefesDesarrollo);
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

    private void btnGestionarCasos(){
        String opcionSeleccionada = (String) comboBox1.getSelectedItem();
        String opcionSeleccionadad = (String) comboBox6.getSelectedItem();


        DefaultTableModel model = (DefaultTableModel) tblGestionCasos.getModel();
        if (model.getColumnCount() == 0) {
            model.addColumn("Aceptado");
            model.addColumn("Rechazado");
        }

        // Agregar una nueva fila con los datos del formulario
        model.addRow(new Object[]{opcionSeleccionada, opcionSeleccionadad});
    }


}


