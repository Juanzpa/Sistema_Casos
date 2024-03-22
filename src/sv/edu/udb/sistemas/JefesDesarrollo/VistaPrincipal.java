package sv.edu.udb.sistemas.JefesDesarrollo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VistaPrincipal extends JFrame {
    private JList<Caso> listCasos;
    private DefaultListModel<Caso> listModel;
    private JButton btnVerDetalles;
    private List<Caso> casos;

    public VistaPrincipal() {
        initializeComponents();
        setupLayout();
        setListeners();
        cargarCasos();
    }

    private void initializeComponents() {
        listModel = new DefaultListModel<>();
        listCasos = new JList<>(listModel);
        btnVerDetalles = new JButton("Ver Detalles");
        casos = new ArrayList<>();
    }

    private void setupLayout() {
        setTitle("Lista de Casos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JScrollPane(listCasos), BorderLayout.CENTER);
        add(btnVerDetalles, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setListeners() {
        btnVerDetalles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Caso selectedCaso = listCasos.getSelectedValue();
                if (selectedCaso != null) {
                    new DetallesCasoGUI(selectedCaso);
                } else {
                    JOptionPane.showMessageDialog(VistaPrincipal.this, "Selecciona un caso primero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void cargarCasos() {
        for (Caso caso : casos) {
            listModel.addElement(caso);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaPrincipal();
            }
        });
    }
}
