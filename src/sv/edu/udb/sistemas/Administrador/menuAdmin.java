package sv.edu.udb.sistemas.Administrador;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

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
    private JButton btnDepartamento;
    private JButton btnEmpleado;
    private JButton btnDesarrollo;
    private JButton jefeAreaFuncionalButton;
    private JButton btnProgramador;
    private JLabel lblJA;
    private JPanel lblJA1;
    private JButton btnAgregarProg;
    private JButton btnEditarProg;
    private JButton btnEliminarProg;
    private JLabel lblDepartamento;
    private JTextField txtDepartamentoNomb;
    private JTextField txtDepartamentoSec;
    private JTable tblDepartamento;
    private JScrollPane JScrollPane;
    private JButton btnEditar;
    private JButton btnBorrar;
    private JButton btnCerrarSesionRol;
    private JLabel lblTituloJefeDesarrollo;
    private JTable tblJefeDesarrollo;
    private JButton btnAgregarJefeDesarrollo;
    private JButton btnEditarJefeDesarrollo;
    private JButton btnEliminarJefeDesarrollo;
    DefaultTableModel modelEmpleado, modeloPogramadores, modeloJefeDesarrollo, modeloAF, modeloDepartamento = null;
    String[] columnaProgramadores, columnaJefeDesarrollo, columnaEmpleado, columnaAF, columnaDepartamento;
    Object[][] datosProgramador, datosJefeDesarrollo, datosEmpleado, datosAF, datosDepartamento;

    private JTabbedPane tabbedPane1;

    private JLabel lblAreaFuncional;
    private JPanel lblPanelAreaFuncional;
    private JScrollPane tblAF;

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_casos";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    private DefaultTableModel tableModel;

    public menuAdmin(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlmenuadmin);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(getParent());

        // Tabla Departamento
        columnaDepartamento = new String[]{"Id", "Nombre", "Seccion"};
        datosDepartamento = new Object[][]{};
        modeloDepartamento = new DefaultTableModel(datosDepartamento, columnaDepartamento);
        tblDepartamento.setModel(modeloDepartamento);

        // Tabla Empleado
        columnaEmpleado = new String[]{"Nombre", "Apellido", "Usuario", "Clave", "Departamento", "Cargo"};
        datosEmpleado = new Object[][]{};
        modelEmpleado = new DefaultTableModel(datosEmpleado, columnaEmpleado);
        tblEmpl.setModel(modelEmpleado);

        // Tabla Programadores
        columnaProgramadores = new String[]{"ID", "Nombre", "Apellido", "Clave", "Cargo"};
        datosProgramador = new Object[][]{};
        modeloPogramadores = new DefaultTableModel(datosProgramador, columnaProgramadores);
        tblProgramadores.setModel(modeloPogramadores);

        // Tabla Jefe de Desarrollo
        columnaJefeDesarrollo = new String[]{"ID", "Nombre", "Apellido", "Clave", "Cargo"};
        datosJefeDesarrollo = new Object[][]{};
        modeloJefeDesarrollo = new DefaultTableModel(datosJefeDesarrollo, columnaJefeDesarrollo);
        tblJefeDesarrollo.setModel(modeloJefeDesarrollo);


        //JefeAreaFuncional
        columnaAF = new String[]{"Id", "Nombre de Caso", "Descripcion de Caso", "Porcentaje de progreso"};
        datosAF = new Object[][]{};
        modeloAF = new DefaultTableModel(datosAF, columnaAF);
        tblJefeAf.setModel(modeloAF);


        // redirecccion departamento

        btnDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPaneAdmin.setSelectedIndex(1); // Índice de la pestaña "Departamento"
            }
        });

        // redirecccion empleado

        btnEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPaneAdmin.setSelectedIndex(2); // Índice de la pestaña "Departamento"
            }
        });

        // redirecccion jefeAreaDesarrollo

        btnDesarrollo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPaneAdmin.setSelectedIndex(3); // Índice de la pestaña "Departamento"
            }
        });

        // redirecccion jefeAreaFuncionalButton

        jefeAreaFuncionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPaneAdmin.setSelectedIndex(4); // Índice de la pestaña "Departamento"
            }
        });

        // redirecccion programadorButton

        btnProgramador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPaneAdmin.setSelectedIndex(5); // Índice de la pestaña "Departamento"
            }
        });

        //Conexion a la BD
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }


        // Logica para la parte de los departamentos
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM departamentos");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nombreDepartamento = resultSet.getString("NombreDepartamento");
                String seccion = resultSet.getString("Seccion");
                modeloDepartamento.addRow(new Object[]{id, nombreDepartamento, seccion});
            }

            tblDepartamento.setModel(modeloDepartamento); // Asignar el modelo de tabla a la tabla

        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        JFrame frama = new menuAdmin("Panel del Administrador");
    frama.setVisible(true);
    }
}
