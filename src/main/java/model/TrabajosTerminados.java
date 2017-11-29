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
public class TrabajosTerminados {

    private int idUsuario;
    private String nombre;
    private String cargo;
    private String fechaTerminado;
    private String fechaRevisado;
    private int horaInicio;
    private int horaFinal;
    private String fecha;
    private int urgencia;
    private String detalles;

    public TrabajosTerminados() {
    }

    public TrabajosTerminados(int idUsuario, String nombre, String cargo, String fechaTerminado, String fechaRevisado, int horaInicio, int horaFinal, String fecha, int urgencia, String detalles) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaTerminado = fechaTerminado;
        this.fechaRevisado = fechaRevisado;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.fecha = fecha;
        this.urgencia = urgencia;
        this.detalles = detalles;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFechaTerminado() {
        return fechaTerminado;
    }

    public void setFechaTerminado(String fechaTerminado) {
        this.fechaTerminado = fechaTerminado;
    }

    public String getFechaRevisado() {
        return fechaRevisado;
    }

    public void setFechaRevisado(String fechaRevisado) {
        this.fechaRevisado = fechaRevisado;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    @Override
    public String toString() {
        return "TrabajosTerminados{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaTerminado=" + fechaTerminado + ", fechaRevisado=" + fechaRevisado + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal + ", fecha=" + fecha + ", urgencia=" + urgencia + ", detalles=" + detalles + '}';
    }

}
