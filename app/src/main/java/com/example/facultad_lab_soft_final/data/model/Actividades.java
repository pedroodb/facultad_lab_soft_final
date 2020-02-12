package com.example.facultad_lab_soft_final.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Actividades {

    ArrayList<General> generales;
    ArrayList<Obra> obras;

    public Actividades(ArrayList<General> generales, ArrayList<Obra> obras) {
        this.generales = generales;
        this.obras = obras;
    }

    public ArrayList<Actividad> getActividades() {
        ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        actividades.addAll(getGenerales());
        actividades.addAll(getObras());
        return actividades;
    }

    public ArrayList<General> getGenerales() {
        return generales;
    }

    public void setGenerales(ArrayList<General> generales) {
        this.generales = generales;
    }

    public ArrayList<Obra> getObras() {
        return obras;
    }

    public void setObras(ArrayList<Obra> obras) {
        this.obras = obras;
    }

    public Map<Date, ArrayList<Actividad>> listadoPorFechas(){
        Map<Date, ArrayList<Actividad>> listado = new TreeMap<Date, ArrayList<Actividad>>();

        for (Actividad actividad : this.getActividades()) {
            actividad.listarPorFecha(listado);
        }

        return listado;
    }
}
