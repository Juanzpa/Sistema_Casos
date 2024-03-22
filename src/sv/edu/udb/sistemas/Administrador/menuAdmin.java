package sv.edu.udb.sistemas.Administrador;
import sv.edu.udb.sistemas.Empleado;
import sv.edu.udb.sistemas.Login;

import javax.swing.JFrame;
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

    private JTabbedPane tabbedPaneAdmin;
    private JLabel lblTituloProgramador;
    private JTable tblProgramadores;
    private JTextField txtNombreEmpl;
    private JTextField txtApellidoEmpl;
    private JTextField txtUsuarioEmpl;
    private JPasswordField pwdEmpl;
    private JComboBox<String> cmbDepartamentoEmpl;
    private JComboBox<String> cmbCargoEmpl;
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
    private Connection connection =  null;

    private DefaultTableModel tableModel;

    private Empleado empleado;




    public menuAdmin(String title, Empleado empleado) {
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

        /* PANEL DEPARTAMENTOS */
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //   System.out.println("Conexión exitosa");

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

        // Editar el departamento
        btnEditarDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = tblDepartamento.getSelectedRow();
                if (selectedRow == -1) {
                    // Si no se ha seleccionado ninguna fila
                    JOptionPane.showMessageDialog(null, "Seleccione un departamento para editar", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String id = txtDepartamentoId.getText();
                String nombre = txtDepartamentoNomb.getText();
                String seccion = txtDepartamentoSec.getText();

                // Validar que los campos no estén vacíos
                if (nombre.isEmpty() || seccion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método porque falta información
                }

                // Actualizar fila seleccionada en la tabla
                tblDepartamento.setValueAt(id, selectedRow, 0);
                tblDepartamento.setValueAt(nombre, selectedRow, 1);
                tblDepartamento.setValueAt(seccion, selectedRow, 2);

                // Query para actualizar la BD
                String updateQuery = "UPDATE departamentos SET NombreDepartamento = '" + nombre + "', Seccion = '" + seccion + "' WHERE Id = " + id;
                executeUpdateQuery(updateQuery);

                JOptionPane.showMessageDialog(null, "Departamento actualizado exitosamente");
            }
        });

        // Borrar Departamento
        btnBorrarDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblDepartamento.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un departamento para eliminar");
                    return;
                }

                String id = tblDepartamento.getValueAt(selectedRow, 0).toString();
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el departamento ?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmacion != JOptionPane.YES_OPTION) {
                    return;
                }

                String deleteQuery = "DELETE FROM departamentos WHERE Id = " + id;
                executeUpdateQuery(deleteQuery);

                DefaultTableModel modelo = (DefaultTableModel) tblDepartamento.getModel();
                modelo.removeRow(selectedRow);

                JOptionPane.showMessageDialog(null, "Departamento eliminado exitosamente");


            }
        });
        /* Termina lógica departamentos */

        // Empleado
        mostrarDatosEmpleados();
        obtenerIdDepartamento();
        obtenerIdCargo();
        btnEnviarEmpl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombreEmpl.getText();
                String apellido = txtApellidoEmpl.getText();
                String usuario = txtUsuarioEmpl.getText();
                String clave = new String(pwdEmpl.getPassword());
                String departamento = cmbDepartamentoEmpl.getSelectedItem().toString();
                String cargo = cmbCargoEmpl.getSelectedItem().toString();

                // Verificar que los campos no estén vacíos
                if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || clave.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                int IdDepartamentoPerteneciente = obtenerIdDepartamento(departamento);


                if (IdDepartamentoPerteneciente != -1) {

                    String insertQuery = "INSERT INTO empleados (Nombre, Apellido, NombreUsuario, Contrasenia, IdDepartamentoPerteneciente, IdCargo) VALUES (?, ?, ?, ?, ?, ?)";
                    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                         PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                        pstmt.setString(1, nombre);
                        pstmt.setString(2, apellido);
                        pstmt.setString(3, usuario);
                        pstmt.setString(4, clave);
                        pstmt.setInt(5, IdDepartamentoPerteneciente);
                        pstmt.setInt(6, obtenerIdCargo(cargo)); // Obtener directamente el ID del cargo seleccionado

                        // Ejecutar la consulta de inserción
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            // Limpiar los campos después de la inserción exitosa
                            limpiarCamposEmpleado();
                            // Actualizar la tabla de empleados para reflejar el nuevo empleado
                            mostrarDatosEmpleados();
                            JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo agregar el empleado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al agregar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del departamento seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        tblEmpl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel model = (DefaultTableModel) tblEmpl.getModel();


                int selectedRow = tblEmpl.getSelectedRow();

                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1) {
                    // Obtener los datos de la fila seleccionada
                    String nombre = model.getValueAt(selectedRow, 0).toString();
                    String apellido = model.getValueAt(selectedRow, 1).toString();
                    String usuario = model.getValueAt(selectedRow, 2).toString();
                    String passwordPlaceholder = "*********";

                    txtNombreEmpl.setText(nombre);
                    txtApellidoEmpl.setText(apellido);
                    txtUsuarioEmpl.setText(usuario);


                    pwdEmpl.setText(passwordPlaceholder);
                    pwdEmpl.setEchoChar((char) 0);


                }
            }
        });

        btnEditarEmpl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblEmpl.getModel();

                // Obtener la fila seleccionada
                int selectedRow = tblEmpl.getSelectedRow();

                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1) {
                    // Obtener los datos de los campos de texto
                    String nombre = txtNombreEmpl.getText();
                    String apellido = txtApellidoEmpl.getText();
                    String usuario = txtUsuarioEmpl.getText();
                    String clave = new String(pwdEmpl.getPassword()); // Se recomienda no almacenar la contraseña en texto plano en un campo de texto

                    // Verificar si los campos obligatorios están llenos
                    if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || clave.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Obtener el ID del departamento seleccionado
                    String departamento = cmbDepartamentoEmpl.getSelectedItem().toString();
                    int idDepartamento = obtenerIdDepartamento(departamento);

                    // Obtener el ID del cargo seleccionado
                    String cargo = cmbCargoEmpl.getSelectedItem().toString();
                    int idCargo = obtenerIdCargo(cargo);

                    // Verificar si se pudo obtener el ID del departamento y el ID del cargo
                    if (idDepartamento == -1 || idCargo == -1) {
                        JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del departamento o del cargo seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Actualizar los datos en la tabla
                    model.setValueAt(nombre, selectedRow, 0);
                    model.setValueAt(apellido, selectedRow, 1);
                    model.setValueAt(usuario, selectedRow, 2);

                    // model.setValueAt(clave, selectedRow, 3);
                    //  model.setValueAt(departamento, selectedRow, departamentoColumnIndex);
                    //       model.setValueAt(cargo, selectedRow, cargoColumnIndex);

                    // Guardar los cambios en la base de datos
                    String updateQuery = "UPDATE empleados SET Nombre=?, Apellido=?, NombreUsuario=?, IdDepartamentoPerteneciente=?, IdCargo=? WHERE Nombre=? AND Apellido=? AND NombreUsuario=?";
                    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                         PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
                        pstmt.setString(1, nombre);
                        pstmt.setString(2, apellido);
                        pstmt.setString(3, usuario);
                        pstmt.setInt(4, idDepartamento);
                        pstmt.setInt(5, idCargo);
                        pstmt.setString(6, nombre);
                        pstmt.setString(7, apellido);
                        pstmt.setString(8, usuario);

                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al actualizar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un empleado para editar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminarEmpl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tblEmpl.getModel();

                // Obtener la fila seleccionada
                int selectedRow = tblEmpl.getSelectedRow();

                // Verificar si se ha seleccionado una fila
                if (selectedRow != -1) {
                    // Obtener el nombre de usuario del empleado seleccionado
                    String nombreUsuario = model.getValueAt(selectedRow, 2).toString();

                    // Confirmar con el usuario si realmente desea eliminar el empleado
                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar al empleado con nombre de usuario '" + nombreUsuario + "'?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) {
                        // Realizar la eliminación en la base de datos
                        String deleteQuery = "DELETE FROM empleados WHERE NombreUsuario=?";
                        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                             PreparedStatement pstmt = connection.prepareStatement(deleteQuery)) {
                            pstmt.setString(1, nombreUsuario);

                            int rowsAffected = pstmt.executeUpdate();
                            if (rowsAffected > 0) {
                                // Eliminar la fila de la tabla
                                model.removeRow(selectedRow);
                                JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un empleado para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Jefe de Desarrollo
        mostrarDatosJefesDesarrollo();



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

        // Programdor
        mostrarDatosProgramador();

        btnCerrarSesionRol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                // Abre la ventana de inicio de sesión
                Empleado empleado = new Empleado();
                Login login = new Login("Inicio de Sesión");
                login.setVisible(true);
            }
        });
    }

    public menuAdmin(Empleado empleado) {
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
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println("Error al ejecutar la consulta de actualización: " + ex.getMessage());
        }
    }

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

    private void mostrarDatosEmpleados() {
        modelEmpleado.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Consulta SQL para obtener los datos de los empleados
            String query = "SELECT Nombre, Apellido, NombreUsuario, Contrasenia, IdDepartamentoPerteneciente, IdCargo FROM empleados";

            // Crear una declaración SQL
            Statement statement = connection.createStatement();

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSet = statement.executeQuery(query);

            // Iterar sobre el resultado y agregar cada empleado a la tabla
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String usuario = resultSet.getString("NombreUsuario");
                String contrasenia = resultSet.getString("Contrasenia");
                int idDepartamento = resultSet.getInt("IdDepartamentoPerteneciente");
                int idCargo = resultSet.getInt("IdCargo");

                // Agregar una nueva fila a la tabla con los datos del empleado
                modelEmpleado.addRow(new Object[]{nombre, apellido, usuario, contrasenia, idDepartamento, idCargo});
            }

            // Cerrar la conexión y liberar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al mostrar los empleados: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int obtenerIdDepartamento(String nombreDepartamento) {
        int idDepartamento = -1;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement("SELECT Id FROM departamentos WHERE NombreDepartamento = ?")) {
            pstmt.setString(1, nombreDepartamento);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                idDepartamento = resultSet.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del departamento: " + ex.getMessage());
        }
        return idDepartamento;
    }

    // Método para obtener el ID del cargo seleccionado
    private int obtenerIdCargo(String nombreCargo) {
        int idCargo = -1;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement("SELECT Id FROM cargos WHERE Cargo = ?")) {
            pstmt.setString(1, nombreCargo);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                idCargo = resultSet.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el ID del cargo: " + ex.getMessage());
        }
        return idCargo;
    }
    private void mostrarDatosJefesDesarrollo(){
        modeloJefeDesarrollo.setRowCount(0);
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            String query = "SELECT * FROM empleados WHERE IdCargo = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1,2);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                String id = resultSet.getString("Id");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String nombreUsuario = resultSet.getString("NombreUsuario");
                String clave = resultSet.getString("Contrasenia");
                String cargo = resultSet.getString("IdCargo");

                modeloJefeDesarrollo.addRow(new Object[]{id, nombre, apellido, nombreUsuario, clave, cargo});
            }
            resultSet.close();
            pstmt.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de Jefes de Desarrollo: " + ex.getMessage());
        }
    }

    private void mostrarDatosProgramador(){
        modeloPogramadores.setRowCount(0);
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "SELECT * FROM empleados WHERE IdCargo = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, 5);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String clave = resultSet.getString("Contrasenia");
                String nombreUsuario = resultSet.getString("NombreUsuario");
                String cargo = resultSet.getString("IdCargo");


                modeloPogramadores.addRow(new Object[]{id, nombre, apellido, nombreUsuario, clave, cargo});
            }

            resultSet.close();
            pstmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar la tabla de Programadores: " + ex.getMessage());
        }
    }

    // cmb de Departamentos en seccion de Empleado(Admin)

    private void limpiarCamposEmpleado() {
        txtNombreEmpl.setText("");
        txtApellidoEmpl.setText("");
        txtUsuarioEmpl.setText("");
        pwdEmpl.setText("");
    }

    // Método para obtener el ID del departamento seleccionado
    private void obtenerIdDepartamento() {
        try{
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_caso", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NombreDepartamento FROM departamentos");
            while(resultSet.next()){
                cmbDepartamentoEmpl.addItem(resultSet.getString("NombreDepartamento"));
            }
            resultSet.close();
            statement.close();

        } catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al obtener los departamentos","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para obtener el ID del cargo seleccionado
    private void obtenerIdCargo() {
        try{
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_caso", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT Cargo FROM cargos WHERE id >= 2");

            while(resultSet.next()){
                cmbCargoEmpl.addItem(resultSet.getString("Cargo"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al obtener los cargos","Warning",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        menuAdmin adminner = new menuAdmin("Panel Administradir", empleado);
        adminner.setVisible(true);}
}