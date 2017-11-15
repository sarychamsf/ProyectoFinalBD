package util;


public class Reporte {
    String nombre;
    int cantidadEnviados;
    int cantidadRecibidos;

    public Reporte() {
    }

    public Reporte(String nombre, int cantidadEnviados, int cantidadRecibidos) {
        this.nombre = nombre;
        this.cantidadEnviados = cantidadEnviados;
        this.cantidadRecibidos = cantidadRecibidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEnviados() {
        return cantidadEnviados;
    }

    public void setCantidadEnviados(int cantidadEnviados) {
        this.cantidadEnviados = cantidadEnviados;
    }

    public int getCantidadRecibidos() {
        return cantidadRecibidos;
    }

    public void setCantidadRecibidos(int cantidadRecibidos) {
        this.cantidadRecibidos = cantidadRecibidos;
    }
    
    
}
