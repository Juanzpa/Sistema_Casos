package sv.edu.udb.sistemas.JefeAreaFuncional;

import sv.edu.udb.sistemas.Conexion;
import sv.edu.udb.sistemas.Empleado;
import sv.edu.udb.sistemas.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.JFrame;
import java.sql.Statement;

public class SolicitudCasos extends JFrame{
    private JTabbedPane tabbedPane1;
    private JButton enviarButton;
    private JTextField textField1;
    private Connection connection;
    private JComboBox comboBox1;
    private JPanel JpJArea;
    private JProgressBar progressBar;
    private JComboBox cmbProgreso;
    private JTextField textField2;
    private JButton cerrarSesionButton;

    public SolicitudCasos(String panel) {
        super(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JpJArea);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
        obtenerBitacora();
        mostrarBitacora();
        cmbProgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarBitacora();
            }
        });
        enviarButton.addActionListener(e -> {
            String idDepartamentoAsignado = comboBox1.getSelectedItem().toString();
            switch (idDepartamentoAsignado) {
                case "Finanzas" :
                    idDepartamentoAsignado = "1";
                    break;
                case "Ventas" :
                    idDepartamentoAsignado = "2";
                    break;
                case "Facturacion fija" :
                    idDepartamentoAsignado = "3";
                    break;
                case "Facturacion movil" :
                    idDepartamentoAsignado = "4";
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "No se guardo nada en la base de datos");
            }

            String nombreCaso = textField1.getText(); // Obtener el nombre del caso
            String descripcion = textField2.getText(); // Obtener la descripción del caso
            guardarCasos(nombreCaso, idDepartamentoAsignado, descripcion);
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
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

    private void guardarCasos(String NombreCaso, String IdDepartamentoAsignado, String DescripcionCaso) {
        if (IdDepartamentoAsignado.isEmpty() || DescripcionCaso.isEmpty() || NombreCaso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, rellene todos lo campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO caso (IdDepartamentoAsignado, NombreCaso, DescripcionCaso) VALUES (?, ?, ?)";
        try (Connection connection = Conexion.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, IdDepartamentoAsignado);
            pstmt.setString(2, NombreCaso);
            pstmt.setString(3, DescripcionCaso);
            pstmt.executeUpdate();

            // Obtener el Id generado
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                JOptionPane.showMessageDialog(this, "Datos guardados en la bitácora correctamente. Id generado: " + idGenerado);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo obtener el Id generado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la bitácora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //barra progreso casos

    private void obtenerBitacora() {
        try (Connection connection = Conexion.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT IdCaso FROM bitacora")) {

            while (resultSet.next()) {
                int idCaso = resultSet.getInt("IdCaso");
                String nombreCaso = obtenerNombreCaso(idCaso);
                cmbProgreso.addItem(nombreCaso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los casos de la bitácora", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String obtenerNombreCaso(int idCaso) {
        String nombreCaso = null;
        try (Connection connection = Conexion.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT NombreCaso FROM caso WHERE Id = ?")) {
            pstmt.setInt(1, idCaso);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                nombreCaso = resultSet.getString("NombreCaso");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el nombre del caso", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return nombreCaso;
    }

    private void mostrarBitacora() {
        String nombreCasoSeleccionado = cmbProgreso.getSelectedItem().toString();
        int idCasoSeleccionado = obtenerIdCasoSeleccionado(nombreCasoSeleccionado);
        if (idCasoSeleccionado == -1) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el Id del caso seleccionado", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection connection = Conexion.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT progreso FROM bitacora WHERE IdCaso = ?")) {
            statement.setInt(1, idCasoSeleccionado);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int progreso = resultSet.getInt("progreso");
                progressBar.setValue(progreso);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró progreso para el caso seleccionado", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el progreso de la bitácora", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private int obtenerIdCasoSeleccionado(String nombreCasoSeleccionado) {
        int idCasoSeleccionado = -1;
        try (Connection connection = Conexion.getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT Id FROM caso WHERE NombreCaso = ?")) {
            pstmt.setString(1, nombreCasoSeleccionado);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                idCasoSeleccionado = resultSet.getInt("Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el Id del caso seleccionado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return idCasoSeleccionado;
    }




            public static void main(String[] args){
        JFrame frame = new SolicitudCasos("panel");
        frame.setVisible(true);
    }
}