package sv.edu.udb.sistemas.Programador.bitacora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bitacora extends JFrame {
    private JPanel pnlBitacora;
    private JTextField txtBitacora;
    private JProgressBar progressBar;
    private JButton btnRegresar;
    private JButton btnActualizar;
    private JButton btnFinalizar;
    private JLabel lblBitacora;

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
            }
        });

        /*btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });*/
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (progressBar.getValue() < 100) {
                    JOptionPane.showMessageDialog(Bitacora.this, "No puedes finalizar el proyecto aún");
                } else {
                    JOptionPane.showMessageDialog(Bitacora.this, "Finalizó el proyecto.");
                }
            }
        });
    }



    public static void main(String[] args) {
        JFrame frameBitacora = new Bitacora();
        //frameBitacora.setVisible(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


}
