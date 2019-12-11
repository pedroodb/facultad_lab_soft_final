package com.example.facultad_lab_soft_final.data.model;

import java.io.Serializable;

public class FechaHora implements Serializable {

    String fecha;
    String hora;

    public FechaHora(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
