package sv.edu.udb.sistemas.JefeAreaFuncional;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EmpleadoProbadorGUI extends JFrame {
    private JLabel lblTitulo, lblIdCaso, lblEstado, lblBitacora;
    private JTextArea txtDescripcion, txtAreaBitacora;
    private JProgressBar progressBar;

    public EmpleadoProbadorGUI(Caso caso) {
        setTitle("Detalles del Caso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblTitulo = new JLabel("Detalles del Caso");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 28));

        lblIdCaso = new JLabel("ID del Caso: " + caso.getId());
        lblIdCaso.setFont(new Font("Verdana", Font.PLAIN, 18));

        lblEstado = new JLabel("Estado: " + caso.getEstado());
        lblEstado.setFont(new Font("Verdana", Font.PLAIN, 18));

        lblBitacora = new JLabel("Bitácora de Trabajo:");
        lblBitacora.setFont(new Font("Verdana", Font.PLAIN, 18));

        txtDescripcion = new JTextArea(caso.getDescripcion());
        txtDescripcion.setEditable(false);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setBackground(new Color(255, 255, 255));
        txtDescripcion.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(191, 128, 64), 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        txtAreaBitacora = new JTextArea(caso.getBitacoraTrabajo());
        txtAreaBitacora.setEditable(false);
        txtAreaBitacora.setLineWrap(true);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(caso.getPorcentajeProgreso());
        progressBar.setStringPainted(true);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(240, 240, 240));

        JPanel panelInfo = new JPanel(new GridLayout(5, 1, 5, 5));
        panelInfo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Información del Caso"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panelInfo.setBackground(new Color(240, 240, 240));
        panelInfo.add(lblIdCaso);
        panelInfo.add(crearPanel("Descripción:", txtDescripcion));
        panelInfo.add(lblEstado);
        panelInfo.add(progressBar);
        panelInfo.add(lblBitacora);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(new Color(240, 240, 240));
        JButton btnAprobar = new JButton("Aprobar Caso");
        personalizarBoton(btnAprobar);
        JButton btnRechazar = new JButton("Rechazar Caso");
        personalizarBoton(btnRechazar);
        panelBotones.add(btnAprobar);
        panelBotones.add(btnRechazar);

        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        panelPrincipal.add(panelInfo, BorderLayout.CENTER);
        panelPrincipal.add(new JScrollPane(txtAreaBitacora), BorderLayout.SOUTH);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel crearPanel(String titulo, JTextArea textArea) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(titulo);
        label.setFont(new Font("Verdana", Font.PLAIN, 18));
        panel.add(label, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return panel;
    }

    private void personalizarBoton(JButton boton) {
        boton.setFont(new Font("Verdana", Font.BOLD, 14));
        boton.setBackground(new Color(191, 128, 64));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setBorder(new RoundedBorder(20));


        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(210, 140, 70));
                boton.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                boton.setBackground(new Color(191, 128, 64));
                boton.setForeground(Color.WHITE);
            }
        });
    }


    private class RoundedBorder implements Border {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        Caso casoEjemplo = new Caso(1, "Descripción del caso de ejemplo", "En Progreso", 50, "Bitácora de trabajo...");
        new EmpleadoProbadorGUI(casoEjemplo);
    }
}
