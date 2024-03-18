package sv.edu.udb.sistemas.Administrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class menuAdmin extends JFrame {
    private JPanel pnlmenuadmin;

    private JTabbedPane tabbedPaneAdmin;
    private JLabel lblTituloProgramador;
    private JTable tblProgramadores;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField pwdEmpl;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton btnEnviarEmpl;
    private JButton btnEditarEmpl;
    private JButton btnEliminarEmpl;

    private JButton btnBorrarJefeAf;

    private JTable tblJefeAf;
    private JTable tblEmpl;
    private JLabel lbltittleEmpl;
    private JLabel lblNombreEmpl;
    private JLabel lblApellidoEmpl;
    private JLabel lblUsuarioEmpl;
    private JLabel lblClaveEmpl;
    private JLabel lblDepartamentoEmpl;
    private JLabel lblCargoEmpl;
    private JLabel lbltitleWelcome;
    private JButton departamentoButton;
    private JButton empleadoButton;
    private JButton jefeDesarrolloButton;
    private JButton jefeAreaFuncionalButton;
    private JButton programadorButton;
    private JLabel lblJA;
    private JPanel lblJA1;
    DefaultTableModel modelEmpleado, modeloPogramadores, modeloAF = null;
    String[] columnaProgramadores, columnaEmpleado, columnaAF;
    Object[][] datosProgramador, datosEmpleado, datosAF;

    private JTabbedPane tabbedPane1;
    private JLabel lblAreaFuncional;
    private JPanel lblPanelAreaFuncional;
    private JScrollPane tblAF;


    public menuAdmin(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlmenuadmin);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(getParent());


        // Tabla Empleado
        columnaEmpleado = new String[] {"Nombre", "Apellido", "Usuario", "Clave", "Departamento", "Cargo"};
        datosEmpleado = new Object[][] {};
        modelEmpleado = new DefaultTableModel(datosEmpleado, columnaEmpleado);
        tblEmpl.setModel(modelEmpleado);

        // Tabla Programadores

        columnaProgramadores = new String[] {"Nombre", "Apellido", "Cargo"};
        datosProgramador = new Object[][] {};
        modeloPogramadores = new DefaultTableModel(datosProgramador, columnaProgramadores);
        tblProgramadores.setModel(modeloPogramadores);


        //JefeAreaFuncional
        columnaAF = new String[] {"Id", "Nombre de Caso", "Descripcion de Caso", "Porcentaje de progreso"};
        datosAF = new Object[][] {};
        modeloAF = new DefaultTableModel(datosAF, columnaAF);
        tblJefeAf.setModel(modeloAF);
    }
    public static void main(String[] args) {
        JFrame frama = new menuAdmin("menuAdmin");
    frama.setVisible(true);
    }
}
