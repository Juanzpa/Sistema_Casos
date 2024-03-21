package sv.edu.udb.sistemas.Programador.bitacora;

import sv.edu.udb.sistemas.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bitacora extends JFrame {
    private JPanel pnlBitacora;
    private JTextField txtBitacora;
    private JProgressBar pgbBitacora;
    private JButton btnRegresar;
    private JButton btnActualizar;
    private JButton btnFinalizar;
    private JLabel lblBitacora;
    private JTextField txtProgresoBitacora;
    private JLabel lblBitacora2;

    private String idCaso;

    public Bitacora(String IdCaso) {
        this.idCaso = IdCaso;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(pnlBitacora);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        verificarExistenciaBitacora();
    }

    private void setProgress() {
        try {
            String progreso = txtProgresoBitacora.getText();
            if (progreso != null && !progreso.isEmpty()) {
                int value = Integer.parseInt(progreso);
                pgbBitacora.setValue(value);
                txtProgresoBitacora.setText(String.valueOf(value));
                pgbBitacora.setString(progreso + "%");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarBitacora(String descripcion, int progreso) {
        String sql = "INSERT INTO bitacora (descripcion, progreso, IdCaso) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setInt(2, progreso);
            pstmt.setString(3, idCaso);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Bitácora creada correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la bitácora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBitacora(String descripcion, int progreso) {
        String sqlUpdate = "UPDATE bitacora SET descripcion = ?, progreso = ? WHERE IdCaso = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, descripcion);
            pstmt.setInt(2, progreso);
            pstmt.setString(3, idCaso);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Bitácora actualizada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna bitácora para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar la bitácora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verificarExistenciaBitacora() {
        String sql = "SELECT descripcion, progreso FROM bitacora WHERE IdCaso = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idCaso);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                int progreso = rs.getInt("progreso");
                txtBitacora.setText(descripcion);
                pgbBitacora.setValue(progreso);
                txtProgresoBitacora.setText(String.valueOf(progreso));
                pgbBitacora.setString(progreso + "%");
                btnActualizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Bitacora.this, "Bitácora actualizada correctamente.");
                        updateBitacora(txtBitacora.getText(), Integer.parseInt(txtProgresoBitacora.getText()));
                    }
                });
            } else {
                btnActualizar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(Bitacora.this, "Bitácora creada correctamente.");
                        guardarBitacora(txtBitacora.getText(), Integer.parseInt(txtProgresoBitacora.getText()));
                    }
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al verificar la existencia de la bitácora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Ejemplo de uso: new Bitacora("25");
            }
        });
    }
}