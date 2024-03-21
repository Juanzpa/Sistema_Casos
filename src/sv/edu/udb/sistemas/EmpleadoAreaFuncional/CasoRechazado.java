package sv.edu.udb.sistemas.EmpleadoAreaFuncional;

import sv.edu.udb.sistemas.Programador.programador.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CasoRechazado extends JFrame {



    private JTabbedPane tabbedPane1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton enviarRechazarButton;
    private JPanel pnlCasoRechazp;

    EmpleadoProbador padre;


    public CasoRechazado(EmpleadoProbador padre){
            this.padre = padre;
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setContentPane(pnlCasoRechazp);
            this.setMinimumSize(new Dimension(800, 600));
            this.setLocationRelativeTo(getParent());
            this.setVisible(true);


        enviarRechazarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpleadoProbador retornar = new EmpleadoProbador(CasoRechazado.this); // Índice de la pestaña "Departamento"
                dispose();
            }
        });

}
}
