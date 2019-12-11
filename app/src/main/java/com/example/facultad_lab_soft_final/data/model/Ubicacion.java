package com.example.facultad_lab_soft_final.data.model;

import java.io.Serializable;

public class Ubicacion implements Serializable {

    String descripcion;
    Double latitud;
    Double longitud;

    public Ubicacion(String descripcion, Double latitud, Double longitud) {
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
