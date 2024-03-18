package sv.edu.udb.sistemas.Programador.casos_programador;
import sv.edu.udb.sistemas.Programador.bitacora.Bitacora;
import sv.edu.udb.sistemas.Programador.programador.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Casos_Programador extends JFrame {
    private JLabel lblTitulo;
    private JLabel lblDescripcion;
    private JLabel lblFechaLimite;
    private JButton btnRegresar;
    private JButton btnLlenarBitacora;
    private JPanel pnlCasos_programador;
    private Programador padre;

    public Casos_Programador(String tituloCaso, String descripcionCaso, String fechaLimiteCaso, Programador papa){
        this.padre = papa;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(pnlCasos_programador);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);

        lblTitulo.setText("Caso: " + tituloCaso);
        lblDescripcion.setText("Descripcio0n: " + descripcionCaso);
        lblFechaLimite.setText("Fecha Limite: " + fechaLimiteCaso);


        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        btnLlenarBitacora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bitacora bitacora = new Bitacora();
            }
        });
    }

    public static void main(String[] args) {
        //JFrame frameCasoProg = new Casos_Programador("Casos asignados");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
