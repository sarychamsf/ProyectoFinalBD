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
public class Queja {

    private int idQueja;
    private int idUsuario;
    private String nombre;
    private String descripcion;

    public Queja() {
    }

    public Queja(int idQueja, int idUsuario, String nombre, String descripcion) {
        this.idQueja = idQueja;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(int idQueja) {
        this.idQueja = idQueja;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        return "Queja{" + "idQueja=" + idQueja + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
