package sv.edu.udb.sistemas.JefesDesarrollo;

public class Caso {

    private int id;
    private String descripcion;
    private String estado;
    private int porcentajeProgreso;
    private String bitacoraTrabajo;


    public Caso(int id, String descripcion, String estado, int porcentajeProgreso, String bitacoraTrabajo) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.porcentajeProgreso = porcentajeProgreso;
        this.bitacoraTrabajo = bitacoraTrabajo;
    }


    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public int getPorcentajeProgreso() {
        return porcentajeProgreso;
    }

    public String getBitacoraTrabajo() {
        return bitacoraTrabajo;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPorcentajeProgreso(int porcentajeProgreso) {
        this.porcentajeProgreso = porcentajeProgreso;
    }

    public void setBitacoraTrabajo(String bitacoraTrabajo) {
        this.bitacoraTrabajo = bitacoraTrabajo;
    }
}
