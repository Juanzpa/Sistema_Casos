package sv.edu.udb.sistemas.Programador.programador;

import sv.edu.udb.sistemas.Programador.casos_programador.Casos_Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programador extends JFrame {
    private JPanel pnlProgramador;
    private JLabel lblTitulo;
    private JPanel pnlCasos;

    public Programador(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlProgramador);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
        pnlCasos.setLayout(new BoxLayout(pnlCasos, BoxLayout.Y_AXIS));
    }

    public void agregarCaso(String tituloCaso, String descripcionCaso, String fechaLimite){
        JLabel lblCaso = new JLabel(tituloCaso);
        JButton btnAbrirCaso = new JButton("Abrir");

        btnAbrirCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Casos_Programador casos = new Casos_Programador(tituloCaso, descripcionCaso, fechaLimite, Programador.this);
            }
        });

        JPanel pnlNuevoCaso = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlNuevoCaso.add(lblCaso);
        pnlNuevoCaso.add(btnAbrirCaso);
        pnlCasos.add(pnlNuevoCaso);
        pnlCasos.revalidate();
    }


    public static void main(String[] args) {
        //JFrame frameProgramador = new Programador("Obama");
        //frameProgramador.setVisible(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Programador programmer = new Programador("Programador");
                programmer.agregarCaso("caso 1", "descripcion del caso 1", "12-12-2024");
                programmer.agregarCaso("caso 2cferxewrx ewxzewxfefx ewzfefxerxr", "descripcion del segundo", "12-12-2014");
                programmer.agregarCaso("caso 1 rcgtrxgertxgrtrcx", "la gran descripcion del tercero", "12-12-2025");

            }
        });
    }

}
