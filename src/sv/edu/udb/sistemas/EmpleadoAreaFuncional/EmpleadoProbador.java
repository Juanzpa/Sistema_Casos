package sv.edu.udb.sistemas.EmpleadoAreaFuncional;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sv.edu.udb.sistemas.Login;
import javax.swing.JOptionPane;

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

    CasoRechazado padre;
    DefaultTableModel modelBitacoraEmpleadoProbador, modelCasoAsignadoEmpleadoProbador = null;
    String[] columnaBitacoraEmpleadoProbador, columnaCasoAsignadoEmpleadoProbador;
    Object[][] datosBitacoraEmpleadoProbador, datosCasoAsignadoEmpleadoProbador;

    // Constructor que acepta un argumento de tipo String para el título del panel y un objeto EmpleadoFuncional
    public EmpleadoProbador(String panel, Login.EmpleadoFuncional empleadoFuncional) {
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

        CerrarSesionEmpleadoProbador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual (EmpleadoProbador)
                dispose();

                // Crear una nueva instancia de la ventana de Login
                Login login = new Login("Inicio de sesión");
                login.setVisible(true);
            }
        });

        // Ventana emergente que muestra los datos del empleado funcional
        mostrarDatosEmpleadoFuncional(empleadoFuncional);
    }

    // Constructor adicional que acepta un argumento de tipo CasoRechazado
    public EmpleadoProbador(CasoRechazado padre) {
        this.padre = padre;
    }

    // Constructor que acepta solo un argumento de tipo String para el título del panel
    public EmpleadoProbador(String panel) {
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

    // Método para mostrar los datos del empleado funcional en una ventana emergente
    private void mostrarDatosEmpleadoFuncional(Login.EmpleadoFuncional empleadoFuncional) {
        // Crear el mensaje con los datos del empleado funcional
        String mensaje = "Nombre: " + empleadoFuncional.getNombre() + "\n"
                + "Apellido: " + empleadoFuncional.getApellido() +"\n"
                + "Departamento: " + empleadoFuncional.getDepartamento() + "\n"
                + "Cargo: " + empleadoFuncional.getCargo();

        // Mostrar el mensaje en una ventana emergente
        JOptionPane.showMessageDialog(this, mensaje, "Datos del Empleado Funcional", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Ejemplo de uso del constructor que acepta solo un argumento String
        JFrame frame = new EmpleadoProbador("panel");
        frame.setVisible(true);
    }
}