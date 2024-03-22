package sv.edu.udb.sistemas;

public class Empleado {
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