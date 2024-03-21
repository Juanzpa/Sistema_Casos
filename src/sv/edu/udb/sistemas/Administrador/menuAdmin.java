package sv.edu.udb.sistemas.Administrador;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class menuAdmin extends JFrame {
    private JPanel pnlmenuadmin;
    private Statement statement;
    private JTabbedPane tabbedPaneAdmin;
    private JLabel lblTituloProgramador;
    private JTable tblProgramadores;
    private JTextField txtNombreEmpl;
    private JTextField txtApellidoEmpl;
    private JTextField txtUsuarioEmpl;
    private JPasswordField pwdClaveEmpl;
    private JComboBox cmbDepartamentosEmpl;
    private JComboBox cmbCargoEmpl;
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
    private JButton btnEditarDep;
    private JButton btnBorrar;
    private JButton btnCerrarSesionRol;
    private JLabel lblTituloJefeDesarrollo;
    private JTable tblJefeDesarrollo;
    private JButton btnAgregarJefeDesarrollo;
    private JButton btnEditarJefeDesarrollo;
    private JButton btnEliminarJefeDesarrollo;

    private JButton btnBorrarDep;


    private JLabel lblDepartamentoId;

    private JTextField txtDepartamentoId;
    private JButton btnAgregarDep;
    DefaultTableModel modelEmpleado, modeloPogramadores, modeloJefeDesarrollo, modeloAF, modeloDepartamento = null;
    String[] columnaProgramadores, columnaJefeDesarrollo, columnaEmpleado, columnaAF, columnaDepartamento;
    Object[][] datosProgramador, datosJefeDesarrollo, datosEmpleado, datosAF, datosDepartamento;

    private JTabbedPane tabbedPane1;

    private JLabel lblAreaFuncional;
    private JPanel lblPanelAreaFuncional;
    private JScrollPane tblAF;

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_caso";
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

        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Seccion"}, 0);
        tblDepartamento.setModel(tableModel);


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
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        /* PANEL DEPARTAMENTOS */
        mostrarDepartamentos();

        tblDepartamento.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tblDepartamento.getSelectedRow();
                    if (selectedRow != -1) { // Verificar si se ha seleccionado una fila
                        String id = tblDepartamento.getValueAt(selectedRow, 0).toString();
                        String nombreDepartamento = tblDepartamento.getValueAt(selectedRow, 1).toString();
                        String seccion = tblDepartamento.getValueAt(selectedRow, 2).toString();

                        // Establecer los valores en las cajas de texto
                        txtDepartamentoId.setText(id);
                        txtDepartamentoNomb.setText(nombreDepartamento);
                        txtDepartamentoSec.setText(seccion);
                    }
                }
            }
        });

        /* Termina lógica departamentos */

        // Logica para Empleado
        cmbDepartamentosEmpl = new JComboBox<>();
        cmbCargoEmpl = new JComboBox<>();
        String IdDepartamentoPerteneciente = ""; // Variable para almacenar el ID del departamento del empleado seleccionado
        String IdCargo = ""; // Variable para almacenar el ID del cargo del empleado seleccionado
        try {
            // Obtener los nombres de los departamentos desde la base de datos
            String queryDepartamento = "SELECT NombreDepartamento FROM departamentos";
            PreparedStatement preparedStatementDepartamento = connection.prepareStatement(queryDepartamento);
            ResultSet resultSetDepartamento = preparedStatementDepartamento.executeQuery();

            // Llenar el JComboBox de Departamentos con los nombres obtenidos
            while (resultSetDepartamento.next()) {
                String nombreDepartamento = resultSetDepartamento.getString("NombreDepartamento");
                cmbDepartamentosEmpl.addItem(nombreDepartamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los departamentos: " + ex.getMessage());
        }

        try {
            // Obtener los nombres de los cargos desde la base de datos
            String queryCargo = "SELECT Cargo FROM cargos";
            PreparedStatement preparedStatementCargo = connection.prepareStatement(queryCargo);
            ResultSet resultSetCargo = preparedStatementCargo.executeQuery();

            // Llenar el JComboBox de Cargos con los nombres obtenidos
            while (resultSetCargo.next()) {
                String nombreCargo = resultSetCargo.getString("Cargo");
                cmbCargoEmpl.addItem(nombreCargo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los cargos: " + ex.getMessage());
        }

        //Logica de JefeAreaFuncional
        mostrarDatosCaso();
        tblJefeAf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblJefeAf.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String idCasostr = (String) tblJefeAf.getValueAt(filaSeleccionada, 0);
                    int idCaso = Integer.parseInt(idCasostr);
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar este caso?",
                            "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                            String query = "DELETE FROM caso WHERE Id = ?";
                            try (PreparedStatement statement = connection.prepareStatement(query)) {
                                statement.setInt(1, idCaso);
                                int filasEliminadas = statement.executeUpdate();
                                if (filasEliminadas > 0) {
                                    DefaultTableModel modeloAF = (DefaultTableModel) tblJefeAf.getModel();
                                    modeloAF.removeRow(filaSeleccionada); // Eliminar la fila de la tabla de la interfaz de usuario
                                    JOptionPane.showMessageDialog(null, "Caso eliminado correctamente.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el caso.");
                                }
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al eliminar el caso: " + ex.getMessage());
                        }
                    }
                }
            }
        });



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


    private void executeUpdateQuery(String query) {
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta de actualización: " + ex.getMessage());
        }
    }

    // Departamentos
    private void mostrarDepartamentos(){
        try {
            modeloDepartamento.setRowCount(0);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM departamentos");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nombreDepartamento = resultSet.getString("NombreDepartamento");
                String seccion = resultSet.getString("Seccion");
                modeloDepartamento.addRow(new Object[]{id, nombreDepartamento, seccion});
            }

            tblDepartamento.setModel(modeloDepartamento); // Asignar el modelo de tabla a la tabla

        } catch (SQLException e) {
            System.err.println("Error al cargar la tabla: " + e.getMessage());
        }
    }


    // Casos
    private void mostrarDatosCaso(){
        modeloAF.setRowCount(0);
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM caso");

            while (resultSet.next()){
                String idCaso = resultSet.getString("Id");
                String nombreCaso = resultSet.getString("NombreCaso");
                String descripcionCaso = resultSet.getString("DescripcionCaso");
                modeloAF.addRow(new Object[]{idCaso, nombreCaso, descripcionCaso});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de casos" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frama = new menuAdmin("Panel del Administrador");
    frama.setVisible(true);
    }
}
