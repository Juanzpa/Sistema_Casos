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
                // Aquí puedes abrir el caso
            }
        });

        JPanel pnlNuevoCaso = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlNuevoCaso.add(lblCaso);
        pnlNuevoCaso.add(btnAbrirCaso);
        pnlCasos.add(pnlNuevoCaso);
        pnlCasos.revalidate();
    }

    // Método para cargar los casos desde la base de datos
    public void cargarCasosDesdeBaseDeDatos() {
        String sql = "SELECT NombreCaso FROM caso";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String tituloCaso = rs.getString("titulo_caso");
                // Aquí puedes obtener también la descripción y la fecha límite si lo necesitas
                agregarCaso(tituloCaso, "", ""); // Llamada al método agregarCaso con los datos obtenidos de la base de datos
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los casos desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Programador programmer = new Programador("Programador");
                programmer.cargarCasosDesdeBaseDeDatos(); // Cargar los casos desde la base de datos al iniciar la aplicación
            }
        });
    }
}
