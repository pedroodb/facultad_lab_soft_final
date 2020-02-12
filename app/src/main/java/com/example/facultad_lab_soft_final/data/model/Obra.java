package com.example.facultad_lab_soft_final.data.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Obra extends Actividad{

    UbicacionObra ubicacion;
    String elenco;
    String autor;
    String direccion;
    String sinopsis;
    String tematica;
    ArrayList<FechaHora> fecha_hora;

    public Obra(int id, String nombre, String descripcion, UbicacionObra ubicacion, String elenco, String autor, String direccion, String sinopsis, String tematica, ArrayList<FechaHora> fecha_hora) {
        super(id, nombre, descripcion);
        this.ubicacion = ubicacion;
        this.elenco = elenco;
        this.autor = autor;
        this.direccion = direccion;
        this.sinopsis = sinopsis;
        this.tematica = tematica;
        this.fecha_hora = fecha_hora;
    }


    public UbicacionObra getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionObra ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public ArrayList<FechaHora> getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(ArrayList<FechaHora> fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getHora() {
        return this.getFecha_hora().get(0).getHora();
    }

    public Date getDateTime() {
        return this.getFecha_hora().get(0).getDateTime();
    }

    @Override
    public void listarPorFecha(Map<Date, ArrayList<Actividad>> actividades) {
        for (FechaHora fecha_hora : this.fecha_hora) {

            ArrayList<FechaHora> fechaUnica = new ArrayList<FechaHora>();
            fechaUnica.add(fecha_hora);
            Obra obra = new Obra(this.id,this.nombre,this.autor,(UbicacionObra) this.ubicacion,this.elenco,this.autor,this.direccion,this.sinopsis,this.tematica,fechaUnica);

            if (actividades.containsKey(fecha_hora.getDate())) {
                actividades.get(fecha_hora.getDate()).add(obra);
            } else {
                ArrayList<Actividad> lista = new ArrayList<Actividad>();
                lista.add(obra);
                actividades.put(fecha_hora.getDate(),lista);
            }
        }
    }
}
