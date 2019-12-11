package com.example.facultad_lab_soft_final.data.model;

public class Notification {

    int id;
    String fecha;
    String titulo;
    String descripcion;
    int idActividad;
    String tipoActividad;
    String tipoNotificacion;

    public Notification(int id, String fecha, String titulo, String descripcion, int idActividad, String tipoActividad, String tipoNotificacion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.idActividad = idActividad;
        this.tipoActividad = tipoActividad;
        this.tipoNotificacion = tipoNotificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(String tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }
}
