    package sv.edu.udb.sistemas;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import sv.edu.udb.sistemas.EmpleadoAreaFuncional.EmpleadoProbador;

    public class Login extends JFrame {
        private JPanel pnlLogin;
        private JLabel lblLogin;
        private JTextField txtUsuario;
        private JPasswordField txtClave;
        private JButton btnIngresar;

        public Login(String title) {
            super(title);
            setTitle("Inicio de sesión");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setContentPane(pnlLogin);
            setSize(400, 300);
            setLocationRelativeTo(null);

            btnIngresar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String usuario = txtUsuario.getText();
                    String clave = new String(txtClave.getPassword());

                    // Lógica de autenticación
                    Empleado empleado = buscarEmpleado(usuario, clave);
                    if (empleado != null) {
                        switch (empleado.getIdCargo()) {
                            case 1:
                                // Crear objeto para cargo Administrador y llamar a los métodos correspondientes
                                crearObjetoAdministrador(empleado);
                                break;
                            case 2:
                                // Crear objeto para cargo Jefe de desarrollo y llamar a los métodos correspondientes
                                crearObjetoJefeDesarrollo(empleado);
                                break;
                            case 3:
                                // Crear objeto para cargo Jefe de área funcional y llamar a los métodos correspondientes
                                crearObjetoJefeAreaFuncional(empleado);
                                break;
                            case 4:
                                // Crear objeto para cargo Empleado funcional y llamar a los métodos correspondientes
                                crearObjetoEmpleadoFuncional(empleado);
                                break;
                            case 5:
                                // Crear objeto para cargo Programador y llamar a los métodos correspondientes
                                crearObjetoProgramador(empleado);
                                break;
                            default:
                                JOptionPane.showMessageDialog(Login.this, "El cargo del usuario no está soportado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(Login.this, "Nombre de usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        // Método para buscar empleado por nombre de usuario y contraseña
        private Empleado buscarEmpleado(String usuario, String clave) {
            Connection conn = null;

            try {
                conn = Conexion.getConnection();
                String sql = "SELECT * FROM empleados WHERE NombreUsuario = ? AND Contrasenia = ?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, usuario);
                statement.setString(2, clave);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Crear y retornar objeto Empleado con datos del registro
                    Empleado empleado = new Empleado();
                    empleado.setId(resultSet.getInt("Id"));
                    empleado.setNombre(resultSet.getString("Nombre"));
                    empleado.setApellido(resultSet.getString("Apellido"));
                    empleado.setNombreUsuario(resultSet.getString("NombreUsuario"));
                    empleado.setIdDepartamentoAsignado(resultSet.getInt("IdDepartamentoPerteneciente"));
                    empleado.setIdCargo(resultSet.getInt("IdCargo"));
                    return empleado;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexion.close(conn);
            }
            return null; // Retornar null si no se encuentra ningún empleado con los datos proporcionados
        }

        // Método para crear objeto para cargo Administrador y llamar a los métodos correspondientes
        private void crearObjetoAdministrador(Empleado empleado) {
            // Crear objeto para cargo Administrador con los datos del empleado
            Administrador administrador = new Administrador(empleado);
            // Llamar a los métodos randoms del cargo Administrador
            administrador.metodoRandomAdministrador();
            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(Login.this, "Se ha creado un objeto Administrador correctamente", "Objeto Creado", JOptionPane.INFORMATION_MESSAGE);
        }

        // Método para crear objeto para cargo Jefe de desarrollo y llamar a los métodos correspondientes
        private void crearObjetoJefeDesarrollo(Empleado empleado) {
            // Crear objeto para cargo Jefe de desarrollo con los datos del empleado
            JefeDesarrollo jefeDesarrollo = new JefeDesarrollo(empleado);
            // Llamar a los métodos randoms del cargo Jefe de desarrollo
            jefeDesarrollo.metodoRandomJefeDesarrollo();
            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(Login.this, "Se ha creado un objeto Jefe de Desarrollo correctamente", "Objeto Creado", JOptionPane.INFORMATION_MESSAGE);
        }

        // Método para crear objeto para cargo Jefe de área funcional y llamar a los métodos correspondientes
        private void crearObjetoJefeAreaFuncional(Empleado empleado) {
            // Crear objeto para cargo Jefe de área funcional con los datos del empleado
            JefeAreaFuncional jefeAreaFuncional = new JefeAreaFuncional(empleado);
            // Llamar a los métodos randoms del cargo Jefe de área funcional
            jefeAreaFuncional.metodoRandomJefeAreaFuncional();
            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(Login.this, "Se ha creado un objeto Jefe de Área Funcional correctamente", "Objeto Creado", JOptionPane.INFORMATION_MESSAGE);
        }

        // Método para crear objeto para cargo Empleado funcional y llamar a los métodos
        public void crearObjetoEmpleadoFuncional(Empleado empleado) {
                // Crear objeto para cargo Empleado funcional con los datos del empleado
                EmpleadoFuncional empleadoFuncional = new EmpleadoFuncional(empleado);
                // Llamar a los métodos randoms del cargo Empleado funcional
                empleadoFuncional.metodoRandomEmpleadoFuncional();

                // Iniciar la clase EmpleadoProbador pasándole el objeto empleadoFuncional
                EmpleadoProbador empleadoProbador = new EmpleadoProbador("panel", empleadoFuncional);
                empleadoProbador.setVisible(true);

                // Cerrar la ventana actual de Login
                dispose();
        }

        // Método para crear objeto para cargo Programador y llamar a los métodos correspondientes
        private void crearObjetoProgramador(Empleado empleado) {
            // Crear objeto para cargo Programador con los datos del empleado
            Programador programador = new Programador(empleado);
            // Llamar a los métodos randoms del cargo Programador
            programador.metodoRandomProgramador();
            // Mostrar mensaje de confirmación
            JOptionPane.showMessageDialog(Login.this, "Se ha creado un objeto Programador correctamente", "Objeto Creado", JOptionPane.INFORMATION_MESSAGE);
        }

        // Clase Empleado
        private class Empleado {
            private int id;
            private String nombre;
            private String apellido;
            private String nombreUsuario;
            private int idDepartamentoAsignado;
            private int idCargo;
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public String getApellido() {
                return apellido;
            }

            public void setApellido(String apellido) {
                this.apellido = apellido;
            }

            public String getNombreUsuario() {
                return nombreUsuario;
            }

            public void setNombreUsuario(String nombreUsuario) {
                this.nombreUsuario = nombreUsuario;
            }

            public int getIdDepartamentoAsignado() {
                return idDepartamentoAsignado;
            }

            public void setIdDepartamentoAsignado(int idDepartamentoAsignado) {
                this.idDepartamentoAsignado = idDepartamentoAsignado;
            }

            public int getIdCargo() {
                return idCargo;
            }

            public void setIdCargo(int idCargo) {
                this.idCargo = idCargo;
            }
        }

        // Clase para representar Administrador
        public class Administrador {
            private Empleado empleado;

            public Administrador(Empleado empleado) {
                this.empleado = empleado;
            }

            // Método random para Administrador
            public void metodoRandomAdministrador() {
                // Implementación para Administrador
            }
        }

        // Clase para representar Jefe de Desarrollo
        public class JefeDesarrollo {
            private Empleado empleado;

            public JefeDesarrollo(Empleado empleado) {
                this.empleado = empleado;
            }

            // Método random para Jefe de Desarrollo
            public void metodoRandomJefeDesarrollo() {
                // Implementación para Jefe de Desarrollo
            }
        }

        // Clase para representar Jefe de Área Funcional
        public class JefeAreaFuncional {
            private Empleado empleado;

            public JefeAreaFuncional(Empleado empleado) {
                this.empleado = empleado;
            }

            // Método random para Jefe de Área Funcional
            public void metodoRandomJefeAreaFuncional() {
                // Implementación para Jefe de Área Funcional
            }
        }

        // Clase para representar Empleado Funcional
        // Clase para representar Empleado Funcional
        public class EmpleadoFuncional {
            private Empleado empleado;

            public EmpleadoFuncional(Empleado empleado) {
                this.empleado = empleado;
            }

            // Método random para Empleado Funcional
            public void metodoRandomEmpleadoFuncional() {
                // Implementación para Empleado Funcional
            }

            // Métodos getter para acceder a los datos del empleado
            public String getNombre() {
                return empleado.getNombre();
            }

            public String getApellido() {
                return empleado.getApellido();
            }

            public String getDepartamento() {
                return String.valueOf(empleado.getIdDepartamentoAsignado());
            }

            public String getCargo() {
                return String.valueOf(empleado.getIdCargo());
            }
        }

        // Clase para representar Programador
        public class Programador {
            private Empleado empleado;

            public Programador(Empleado empleado) {
                this.empleado = empleado;
            }

            // Método random para Programador
            public void metodoRandomProgramador() {
                // Implementación para Programador
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                Login login = new Login("Inicio de sesión");
                login.setVisible(true);
            });
        }
    }