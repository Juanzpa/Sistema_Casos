package sv.edu.udb.sistemas.Administrador;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

//

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
    private JButton btnEditarDep;
    private JButton btnBorrar;
    private JButton btnCerrarSesionRol;
    private JLabel lblTituloJefeDesarrollo;
    private JTable tblJefeDesarrollo;
    private JButton btnAgregarJefeDesarrollo;
    private JButton btnEditarJefeDesarrollo;
    private JButton btnEliminarJefeDesarrollo;
    private JTextField txtDepartamentoId;
    private JLabel lblId;
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
        columnaDepartamento = new String[] {"ID","Nombre","Seccion"};
        datosDepartamento = new Object[][] {};
        modeloDepartamento = new DefaultTableModel(datosDepartamento, columnaDepartamento);
        tblDepartamento.setModel(modeloDepartamento);

        // Tabla Empleado
        columnaEmpleado = new String[] {"Nombre", "Apellido", "Usuario", "Clave", "Departamento", "Cargo"};
        datosEmpleado = new Object[][] {};
        modelEmpleado = new DefaultTableModel(datosEmpleado, columnaEmpleado);
        tblEmpl.setModel(modelEmpleado);

        // Tabla Programadores
        columnaProgramadores = new String[] {"ID", "Nombre", "Apellido", "Clave","Cargo"};
        datosProgramador = new Object[][] {};
        modeloPogramadores = new DefaultTableModel(datosProgramador, columnaProgramadores);
        tblProgramadores.setModel(modeloPogramadores);

        // Tabla Jefe de Desarrollo
        columnaJefeDesarrollo = new String[] {"ID", "Nombre", "Apellido", "Clave", "Cargo"};
        datosJefeDesarrollo = new Object[][] {};
        modeloJefeDesarrollo = new DefaultTableModel(datosJefeDesarrollo, columnaJefeDesarrollo);
        tblJefeDesarrollo.setModel(modeloJefeDesarrollo);


        //JefeAreaFuncional
        columnaAF = new String[] {"Id", "Nombre de Caso", "Descripcion de Caso", "Porcentaje de progreso"};
        datosAF = new Object[][] {};
        modeloAF = new DefaultTableModel(datosAF, columnaAF);
        tblJefeAf.setModel(modeloAF);

        tableModel = new DefaultTableModel(new String[]{"ID", "Nombre", "Seccion"}, 0);
        tblDepartamento.setModel(tableModel);

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }

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

        // Logica para la parte de los departamentos
        tblDepartamento = new JTable(tableModel);
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_casos","root","");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM departamentos");

            while (resultSet.next()){
                String id = resultSet.getString("id");
                String nombreDepartamento = resultSet.getString("NombreDepartamento");
                String seccion = resultSet.getString("Seccion");
                tableModel.addRow(new String[]{id, nombreDepartamento, seccion});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

        btnEditarDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados por el admin
                String nombreDepartamento = txtDepartamentoNomb.getText();
                String seccion = txtDepartamentoSec.getText();

                // Obtener la fila seleccionada en la tabla
                int filaSeleccionada = tblDepartamento.getSelectedRow();
                if (filaSeleccionada == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un departamento para editar.");
                    return; // Salir del método si no se selecciona ninguna fila
                }

                // Obtener el ID del departamento seleccionado
                String idDepartamento = tblDepartamento.getValueAt(filaSeleccionada, 0).toString();

                // Actualizar los datos en la tabla de la aplicación
                tblDepartamento.setValueAt(idDepartamento,filaSeleccionada,0);
                tblDepartamento.setValueAt(nombreDepartamento, filaSeleccionada, 1); // Actualizar el nombre
                tblDepartamento.setValueAt(seccion, filaSeleccionada, 2); // Actualizar la sección

                // Actualizar los datos en la base de datos
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String query = "UPDATE departamentos SET NombreDepartamento = ?, Seccion = ? WHERE id = ?";
                    try (PreparedStatement statement = connection.prepareStatement(query)) {
                        statement.setString(1, nombreDepartamento);
                        statement.setString(2, seccion);
                        statement.setString(3, idDepartamento);
                        int filasActualizadas = statement.executeUpdate();
                        if (filasActualizadas > 0) {
                            JOptionPane.showMessageDialog(null, "Departamento actualizado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar el departamento.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar el departamento: " + ex.getMessage());
                }
            }
        });


        tblDepartamento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerDatos(e);
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


    private void tblObtenerDatos(MouseEvent e) {
        int fila = tblDepartamento.rowAtPoint(e.getPoint());
        int columna = tblDepartamento.columnAtPoint(e.getPoint());

        if ((fila > -1) && (columna > -1)) {
            txtDepartamentoId.setText(modeloDepartamento.getValueAt(fila,0).toString());
            txtDepartamentoNomb.setText(modeloDepartamento.getValueAt(fila, 1).toString());
            txtDepartamentoSec.setText(modeloDepartamento.getValueAt(fila, 2).toString());
        }
    }

    public static void main(String[] args) {
        JFrame frama = new menuAdmin("Panel del Administrador");
    frama.setVisible(true);
    }
}
