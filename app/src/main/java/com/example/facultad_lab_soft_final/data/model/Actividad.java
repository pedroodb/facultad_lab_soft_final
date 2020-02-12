package com.example.facultad_lab_soft_final.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public abstract class Actividad implements Serializable, Comparable<Actividad> {

    int id;
    String nombre;
    String descripcion;

    public Actividad(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public abstract Ubicacion getUbicacion();

    public abstract String getHora();

    public abstract Date getDateTime();

    @Override
    public int compareTo(Actividad actividad) {
        return this.getDateTime().compareTo(actividad.getDateTime());
    }

    public abstract void listarPorFecha(Map<Date, ArrayList<Actividad>> actividades);
}
