package sv.edu.udb.sistemas.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BitacoraInterfaz extends JFrame {

    private JTextField bitacoraTextField;
    private JProgressBar progressBar;
    private JButton regresarButton;
    private JButton actualizarButton;
    private JButton finalizarButton;

    public BitacoraInterfaz() {
        setTitle("Interfaz de Bitácora");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        bitacoraTextField = new JTextField(20);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        regresarButton = new JButton("Regresar");
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });

        actualizarButton = new JButton("Actualizar");
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(BitacoraInterfaz.this, "Bitácora actualizada correctamente.");
            }
        });

        finalizarButton = new JButton("Finalizar");
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(BitacoraInterfaz.this, "Caso finalizado.");
            }
        });

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5, 1));
        panelPrincipal.add(bitacoraTextField);
        panelPrincipal.add(progressBar);
        panelPrincipal.add(regresarButton);
        panelPrincipal.add(actualizarButton);
        panelPrincipal.add(finalizarButton);

        add(panelPrincipal);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
