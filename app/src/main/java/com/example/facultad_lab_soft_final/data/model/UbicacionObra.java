package com.example.facultad_lab_soft_final.data.model;

public class UbicacionObra extends Ubicacion {

    Integer capacidad;

    public UbicacionObra(String descripcion, Double latitud, Double longitud, Integer capacidad) {
        super(descripcion, latitud, longitud);
        this.capacidad = capacidad;
    }
}
