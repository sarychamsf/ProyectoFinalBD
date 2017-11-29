/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author FiJus
 */
public class Mensaje {
    private int idU1;
    private int idU2;
    private int idC;
    private int prioridad;
    private String asunto;
    private String texto;

    public Mensaje() {
    }

    public Mensaje(int idU1, int idU2, int idC, int prioridad, String asunto, String texto) {
        this.idU1 = idU1;
        this.idU2 = idU2;
        this.idC = idC;
        this.prioridad = prioridad;
        this.asunto = asunto;
        this.texto = texto;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getIdU1() {
        return idU1;
    }

    public void setIdU1(int idU1) {
        this.idU1 = idU1;
    }

    public int getIdU2() {
        return idU2;
    }

    public void setIdU2(int idU2) {
        this.idU2 = idU2;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    
}
