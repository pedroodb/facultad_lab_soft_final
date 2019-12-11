package com.example.facultad_lab_soft_final.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class General extends Actividad {

    Ubicacion ubicacion;
    FechaHora fecha_hora;

    public General(int id, String nombre, String descripcion, Ubicacion ubicacion, FechaHora fecha_hora) {
        super(id, nombre, descripcion);
        this.ubicacion = ubicacion;
        this.fecha_hora = fecha_hora;
    }

    public FechaHora getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(FechaHora fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHora() {
        return this.getFecha_hora().getHora();
    }

    public Date getDateTime() {
        return this.getFecha_hora().getDateTime();
    }

    @Override
    public void listarPorFecha(Map<Date, SortedSet<Actividad>> actividades) {
        if (actividades.containsKey(fecha_hora.getDate())) {
            actividades.get(fecha_hora.getDate()).add(this);
        } else {
            SortedSet<Actividad> lista = new TreeSet<Actividad>();
            lista.add(this);
            actividades.put(fecha_hora.getDate(),lista);
        }
    }
}
