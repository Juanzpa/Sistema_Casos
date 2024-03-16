package sv.edu.udb.sistemas.Administrador;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdministrador extends JFrame implements ActionListener {
    // Modelos de tablas
    private DefaultTableModel departamentoModel;
    private DefaultTableModel jefeAreaFuncionalModel;
    private DefaultTableModel jefeDesarrolloModel;
    private DefaultTableModel empleadoModel;

    // Ventanas
    private DepartamentoFrame departamentoFrame;
    private JefeAreaFuncionalFrame jefeAreaFuncionalFrame;
    private JefeDesarrolloFrame jefeDesarrolloFrame;
    private EmpleadoFrame empleadoFrame;

    public PanelAdministrador() {
        super("Panel de Administrador");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles para cada sección
        JPanel departamentoPanel = createTablePanel("Departamentos", new String[]{"Nombre", "Descripción"});
        JPanel jefeAreaFuncionalPanel = createTablePanel("Jefes de Áreas Funcionales", new String[]{"Nombre", "Apellido", "Departamento"});
        JPanel jefeDesarrolloPanel = createTablePanel("Jefes de Desarrollo", new String[]{"Nombre", "Apellido", "Departamento"});
        JPanel empleadoPanel = createTablePanel("Empleados", new String[]{"Nombre", "Apellido", "Departamento", "Cargo"});

        // Crear botones para cada sección
        JButton departamentoButton = new JButton("Agregar Departamento");
        JButton jefeAreaFuncionalButton = new JButton("Agregar Jefe de Área Funcional");
        JButton jefeDesarrolloButton = new JButton("Agregar Jefe de Desarrollo");
        JButton empleadoButton = new JButton("Agregar Empleado");

        // Agregar ActionListener a cada botón
        departamentoButton.addActionListener(this);
        jefeAreaFuncionalButton.addActionListener(this);
        jefeDesarrolloButton.addActionListener(this);
        empleadoButton.addActionListener(this);

        // Crear panel principal y agregar paneles y botones
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(departamentoPanel);
        panel.add(jefeAreaFuncionalPanel);
        panel.add(jefeDesarrolloPanel);
        panel.add(empleadoPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(departamentoButton);
        buttonPanel.add(jefeAreaFuncionalButton);
        buttonPanel.add(jefeDesarrolloButton);
        buttonPanel.add(empleadoButton);

        // Agregar paneles al marco
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createTablePanel(String title, String[] columnNames) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));

        // Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Guardar referencia al modelo de tabla para futuras actualizaciones
        if (title.equals("Departamentos")) {
            departamentoModel = model;
        } else if (title.equals("Jefes de Áreas Funcionales")) {
            jefeAreaFuncionalModel = model;
        } else if (title.equals("Jefes de Desarrollo")) {
            jefeDesarrolloModel = model;
        } else if (title.equals("Empleados")) {
            empleadoModel = model;
        }

        return panel;
    }

    private void showDepartamentoFrame() {
        if (departamentoFrame == null) {
            departamentoFrame = new DepartamentoFrame();
        }
        departamentoFrame.setVisible(true);
    }

    private void showJefeAreaFuncionalFrame() {
        if (jefeAreaFuncionalFrame == null) {
            jefeAreaFuncionalFrame = new JefeAreaFuncionalFrame();
        }
        jefeAreaFuncionalFrame.setVisible(true);
    }

    private void showJefeDesarrolloFrame() {
        if (jefeDesarrolloFrame == null) {
            jefeDesarrolloFrame = new JefeDesarrolloFrame();
        }
        jefeDesarrolloFrame.setVisible(true);
    }

    private void showEmpleadoFrame() {
        if (empleadoFrame == null) {
            empleadoFrame = new EmpleadoFrame();
        }
        empleadoFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Agregar Departamento":
                showDepartamentoFrame();
                break;
            case "Agregar Jefe de Área Funcional":
                showJefeAreaFuncionalFrame();
                break;
            case "Agregar Jefe de Desarrollo":
                showJefeDesarrolloFrame();
                break;
            case "Agregar Empleado":
                showEmpleadoFrame();
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PanelAdministrador());
    }
}
