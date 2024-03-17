package sv.edu.udb.sistemas.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasoInterfaz extends JFrame {

    private JLabel tituloLabel;
    private JLabel descripcionLabel;
    private JLabel fechaLimiteLabel;
    private JButton regresarButton;
    private JButton llenarBitacoraButton;
    private ProgramadorInterfaz padre;

    public CasoInterfaz(String tituloCaso, String descripcionCaso, String fechaLimiteCaso, ProgramadorInterfaz padre) {
        this.padre = padre;

        setTitle("Interfaz Caso: " + tituloCaso);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla


        tituloLabel = new JLabel("Título del Caso: " + tituloCaso);
        descripcionLabel = new JLabel("Descripción del Caso: " + descripcionCaso);
        fechaLimiteLabel = new JLabel("Fecha Límite: " + fechaLimiteCaso);

        regresarButton = new JButton("Regresar");
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        llenarBitacoraButton = new JButton("Llenar Bitácora");
        llenarBitacoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BitacoraInterfaz bitacoraInterfaz = new BitacoraInterfaz();
            }
        });


        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5, 1));
        panelPrincipal.add(tituloLabel);
        panelPrincipal.add(descripcionLabel);
        panelPrincipal.add(fechaLimiteLabel);
        panelPrincipal.add(regresarButton);
        panelPrincipal.add(llenarBitacoraButton);


        add(panelPrincipal);

        setVisible(true);
    }


    public int getProgreso() {
        return padre.getProgreso(tituloLabel.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
