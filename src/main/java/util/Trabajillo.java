/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author LabingXEON
 */
public class Trabajillo {
    private int idServicio;
    private String servicio;
    private int urgencia;
    private String detalles;

    public Trabajillo() {
    }

    public Trabajillo(int idServicio,String servicio, int urgencia, String detalles) {
        this.idServicio=idServicio;
        this.servicio = servicio;
        this.urgencia = urgencia;
        this.detalles = detalles;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    
    

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
    
}
