package com.example.facultad_lab_soft_final.data.model;

public class General extends Actividad {

    FechaHora fecha_hora;

    public General(int id, String nombre, String descripcion, Ubicacion ubicacion, FechaHora fecha_hora) {
        super(id, nombre, descripcion, ubicacion);
        this.fecha_hora = fecha_hora;
    }

    public FechaHora getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(FechaHora fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
}
