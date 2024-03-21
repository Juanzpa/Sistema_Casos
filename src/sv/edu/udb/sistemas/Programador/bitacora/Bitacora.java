package sv.edu.udb.sistemas.Programador.bitacora;

import sv.edu.udb.sistemas.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public Bitacora(){
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

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Bitacora.this, "Bitácora actualizada correctamente.");
                setProgress();
            }
        });

        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pgbBitacora.getValue() < 100) {
                    JOptionPane.showMessageDialog(Bitacora.this, "No puedes finalizar el proyecto aún");
                } else {
                    JOptionPane.showMessageDialog(Bitacora.this, "Finalizó el proyecto.");
                }
            }
        });
    }

    private void setProgress() {
        try {
            String progreso = txtProgresoBitacora.getText();
            if (progreso != null && !progreso.isEmpty()) {
                int value = Integer.parseInt(progreso);
                pgbBitacora.setValue(value);
                txtProgresoBitacora.setText(String.valueOf(value));
                pgbBitacora.setString(progreso + "%");
                guardarBitacora(txtBitacora.getText(), value);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarBitacora(String descripcion, int progreso) {
        String sql = "INSERT INTO bitacora (descripcion, progreso) VALUES (?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setInt(2, progreso);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Datos guardados en la bitácora correctamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los datos en la bitácora", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frameBitacora = new Bitacora();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
