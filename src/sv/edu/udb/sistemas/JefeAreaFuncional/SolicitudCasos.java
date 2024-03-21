package sv.edu.udb.sistemas.JefeAreaFuncional;

import sv.edu.udb.sistemas.Conexion;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class SolicitudCasos extends JFrame{
    private JTabbedPane tabbedPane1;
    private JButton enviarButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JPanel JpJArea;
    private JProgressBar progressBar1;
    private JComboBox comboBox2;
    private JTextField textField2;

    public SolicitudCasos(String panel) {
        super(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(JpJArea);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

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

    public static void main(String[] args){
        JFrame frame = new SolicitudCasos("panel");
        frame.setVisible(true);
    }
}
