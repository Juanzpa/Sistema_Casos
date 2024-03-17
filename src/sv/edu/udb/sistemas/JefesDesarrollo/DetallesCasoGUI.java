package sv.edu.udb.sistemas.JefesDesarrollo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetallesCasoGUI extends JFrame {
    private JLabel lblId, lblDescripcion, lblEstado, lblProgreso, lblBitacora;
    private JButton btnAprobar, btnRechazar;
    private Caso caso;

    public DetallesCasoGUI(Caso caso) {
        this.caso = caso;
        initializeComponents();
        setupLayout();
        setListeners();
        displayCasoDetails();
    }

    private void initializeComponents() {
        lblId = new JLabel("ID del Caso: " + caso);
        lblDescripcion = new JLabel("Descripción: " + caso);
        lblEstado = new JLabel("Estado: " + caso);
        lblProgreso = new JLabel("Porcentaje de Progreso: " + caso);
        lblBitacora = new JLabel("Bitácora de Trabajo: " + caso);
        btnAprobar = new JButton("Aprobar Caso");
        btnRechazar = new JButton("Rechazar Caso");
    }

    private void setupLayout() {
        setTitle("Detalles del Caso");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));
        add(lblId);
        add(new JLabel());
        add(lblDescripcion);
        add(new JLabel());
        add(lblEstado);
        add(new JLabel());
        add(lblProgreso);
        add(new JLabel());
        add(lblBitacora);
        add(new JLabel());
        add(btnAprobar);
        add(btnRechazar);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setListeners() {
        btnAprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para aprobar el caso
                JOptionPane.showMessageDialog(DetallesCasoGUI.this, "Caso Aprobado", "Aprobado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        });

        btnRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para rechazar el caso
                JOptionPane.showMessageDialog(DetallesCasoGUI.this, "Caso Rechazado", "Rechazado", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        });
    }

    private void displayCasoDetails() {
        // Actualizar los JLabels con los detalles del caso
    }
}
