package sv.edu.udb.sistemas.Programador.programador;

import sv.edu.udb.sistemas.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.edu.udb.sistemas.Empleado;
import sv.edu.udb.sistemas.Login;
import sv.edu.udb.sistemas.Programador.casos_programador.Casos_Programador;

public class Programador extends JFrame {
    private JPanel pnlProgramador;
    private JLabel lblTitulo;
    private JPanel pnlCasos;
    private JButton btnCerrarSesionProg;
    private JButton btnCerrarSesionProgramador;
    private Empleado empleado;
    public Programador(String title, Empleado empleado){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlProgramador);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
        pnlCasos.setLayout(new BoxLayout(pnlCasos, BoxLayout.Y_AXIS));

        //cerrar sesion
        btnCerrarSesionProg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual del programador
                dispose();

                // Abre la ventana de inicio de sesión
                Empleado empleado = new Empleado();
                Login login = new Login("Inicio de Sesión");
                login.setVisible(true);
            }
        });
        mostrarDatosEmpleado(empleado);
    }

    private void mostrarDatosEmpleado(Empleado empleado) {
        // Crear el mensaje con los datos del empleado
        String mensaje = "Nombre: " + empleado.getNombre() + "\n"
                + "Apellido: " + empleado.getApellido() +"\n"
                + "Departamento: " + empleado.getIdDepartamentoAsignado() + "\n"
                + "Cargo: " + empleado.getIdCargo();

        // Mostrar el mensaje en una ventana emergente
        JOptionPane.showMessageDialog(this, mensaje, "Datos del Empleado", JOptionPane.INFORMATION_MESSAGE);
    }

    public void agregarCaso(String IdCaso, String tituloCaso, String descripcionCaso, String fechaLimite){
        JLabel lblCaso = new JLabel(tituloCaso);
        JButton btnAbrirCaso = new JButton("Abrir");

        btnAbrirCaso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Casos_Programador caso = new Casos_Programador(IdCaso, tituloCaso, descripcionCaso, fechaLimite, Programador.this);
                dispose();
            }
        });

        JPanel pnlNuevoCaso = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlNuevoCaso.add(lblCaso);
        pnlNuevoCaso.add(btnAbrirCaso);
        pnlCasos.add(pnlNuevoCaso);
        pnlCasos.revalidate();
    }


    public void cargarCasosDesdeBaseDeDatos() {
        String sql = "SELECT Id, NombreCaso, DescripcionCaso, FechaFinal FROM caso";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String idCaso = rs.getString("Id");
                String tituloCaso = rs.getString("NombreCaso");
                String descripcionCaso = rs.getString("DescripcionCaso");
                String fechaLimiteCaso = rs.getString("FechaFinal");
                agregarCaso(idCaso, tituloCaso, descripcionCaso, fechaLimiteCaso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los casos desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void metodoRandomProgramador() {
        // Implementación para Programador
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Empleado empleado = new Empleado();
                Programador programmer = new Programador("Programador", empleado);
                programmer.cargarCasosDesdeBaseDeDatos();
            }
        });
    }
}