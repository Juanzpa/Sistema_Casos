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
import sv.edu.udb.sistemas.Programador.casos_programador.Casos_Programador;

public class Programador extends JFrame {
    private JPanel pnlProgramador;
    private JLabel lblTitulo;
    private JPanel pnlCasos;
    private JButton btnCerrarSesionProg;
    private JButton btnCerrarSesionProgramador;

    public Programador(String title){
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
                
            }
        });
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Programador programmer = new Programador("Programador");
                programmer.cargarCasosDesdeBaseDeDatos();
            }
        });
    }
}