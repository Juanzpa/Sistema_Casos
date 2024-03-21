package sv.edu.udb.sistemas.EmpleadoAreaFuncional;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
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
    private JButton CerrarSesionEmpleadoProbador;


    //
    CasoRechazado padre;

    DefaultTableModel modelBitacoraEmpleadoProbador, modelCasoAsignadoEmpleadoProbador = null;
    String[] columnaBitacoraEmpleadoProbador, columnaCasoAsignadoEmpleadoProbador;
    Object[][] datosBitacoraEmpleadoProbador, datosCasoAsignadoEmpleadoProbador;

    public EmpleadoProbador(String panel){
        super(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlEmpleado);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());



        columnaBitacoraEmpleadoProbador = new String[] {"Nombre", "Apellido", "Usuario", "Clave", "Departamento", "Cargo"};
        datosBitacoraEmpleadoProbador = new Object[][] {};
        modelBitacoraEmpleadoProbador = new DefaultTableModel(datosBitacoraEmpleadoProbador, columnaBitacoraEmpleadoProbador);
        tblBitacoraEmpleado.setModel(modelBitacoraEmpleadoProbador);

        columnaCasoAsignadoEmpleadoProbador = new String[] {"Nombre", "Apellido", "Usuario", "Clave", "Departamento", "Cargo"};
        datosCasoAsignadoEmpleadoProbador = new Object[][] {};
        modelCasoAsignadoEmpleadoProbador = new DefaultTableModel(datosCasoAsignadoEmpleadoProbador, columnaCasoAsignadoEmpleadoProbador);
        tblCasosEmpleado.setModel(modelCasoAsignadoEmpleadoProbador);

        btnRechazarCasoEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CasoRechazado rechazo = new CasoRechazado(EmpleadoProbador.this); // Índice de la pestaña "Departamento"
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new EmpleadoProbador("panel");
        frame.setVisible(true);

    }

    public EmpleadoProbador(CasoRechazado padre) {
        this.padre = padre;

    }
}
