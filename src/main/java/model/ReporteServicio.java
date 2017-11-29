package model;

public class ReporteServicio {

    private int idServicio;
    private int cuenta;
    private String nombre;

    public ReporteServicio() {
    }

    public ReporteServicio(int idServicio, int cuenta, String nombre) {
        this.idServicio = idServicio;
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    public ReporteServicio(int idServicio, int cuenta) {
        this.idServicio = idServicio;
        this.cuenta = cuenta;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    

}
