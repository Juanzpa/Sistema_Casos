package sv.edu.udb.sistemas.Programador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ProgramadorInterfaz extends JFrame {

    private JLabel tipoUsuarioLabel;
    private JLabel casosAsignadosLabel;
    private JPanel casosPanel;
    private Map<String, Integer> progresoCasos;

    public ProgramadorInterfaz() {
        setTitle("Interfaz Programador");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        tipoUsuarioLabel = new JLabel("Tipo de Usuario: Programador", SwingConstants.RIGHT);
        casosAsignadosLabel = new JLabel("Casos asignados:");
        casosPanel = new JPanel();
        casosPanel.setLayout(new BoxLayout(casosPanel, BoxLayout.Y_AXIS));

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(tipoUsuarioLabel, BorderLayout.NORTH);
        panelPrincipal.add(casosAsignadosLabel, BorderLayout.CENTER);
        panelPrincipal.add(casosPanel, BorderLayout.CENTER);

        add(panelPrincipal);

        progresoCasos = new HashMap<>();

        setVisible(true);
    }

    public void agregarCaso(String tituloCaso, String descripcionCaso, String fechaLimite) {
        JLabel labelCaso = new JLabel(tituloCaso);
        JButton abrirCasoButton = new JButton("Abrir");
        abrirCasoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CasoInterfaz casoInterfaz = new CasoInterfaz(tituloCaso, descripcionCaso, fechaLimite, ProgramadorInterfaz.this);
                casoInterfaz.setVisible(true);
            }
        });
        JPanel casoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        casoPanel.add(labelCaso);
        casoPanel.add(abrirCasoButton);
        casosPanel.add(casoPanel);
        casosPanel.revalidate();
    }

    public int getProgreso(String tituloCaso) {
        return progresoCasos.getOrDefault(tituloCaso, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProgramadorInterfaz programa = new ProgramadorInterfaz();
                // casos de ejemplo
                programa.agregarCaso("Mejorar la funcionalidad de botones en el form de registro #2", "Descripción del caso 1", "2024-04-01");
                programa.agregarCaso("Hacer una lista de las posibles mejoras a realizar este mes", "Descripción del caso 2", "2024-04-15");
                programa.agregarCaso("Darle mantenimiento a la pagina web del cliente 12345678910", "Descripción del caso 3", "2024-04-30");
            }
        });
    }
}
