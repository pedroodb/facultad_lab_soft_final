package com.example.facultad_lab_soft_final.data.model;

import java.util.ArrayList;

public class Actividades {

    ArrayList<General> generales;
    ArrayList<Obra> obras;

    public Actividades(ArrayList<General> generales, ArrayList<Obra> obras) {
        this.generales = generales;
        this.obras = obras;
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
}
