/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Brenda
 */
public class Problema {

    private int idProblema;
    private int idTaR;
    private String nombre;
    private String descripcion;

    public Problema() {
    }

    public Problema(int idProblema, int idTaR, String nombre, String descripcion) {
        this.idProblema = idProblema;
        this.idTaR = idTaR;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public int getIdTaR() {
        return idTaR;
    }

    public void setIdTaR(int idTaR) {
        this.idTaR = idTaR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Problema{" + "idProblema=" + idProblema + ", idTaR=" + idTaR + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
