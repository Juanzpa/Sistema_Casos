package sv.edu.udb.sistemas.EmpleadoAreaFuncional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmpleadoProbador extends JFrame {

    private JTabbedPane tbdEmpleado;
    private JLabel lblCasosEmpleado;
    private JComboBox cmbCasosEmpleado;
    private JTable tblCasosEmpleado;
    private JButton btnRechazarCasoEmp;
    private JButton btnAceptarCasoEmp;
    private JLabel lblBitacoraEmpleado;
    private JComboBox cmbBitacorasEmpleado;
    private JTable tblBitacoraEmpleado;
    private JPanel pnlEmpleado;

    public EmpleadoProbador(String panel){
        super(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlEmpleado);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());

        btnRechazarCasoEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbdEmpleado.setSelectedIndex(1);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new EmpleadoProbador("panel");
        frame.setVisible(true);
    }
}
