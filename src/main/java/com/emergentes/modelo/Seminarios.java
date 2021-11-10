/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Jhonny
 */
public class Seminarios {
    private int id;
    private String titulo;
    private String expositor;
    private String fecha;
    private String hora;
    private int cupo;

    public Seminarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getExpositor() {
        return expositor;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
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

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "Seminarios{" + "id=" + id + ", titulo=" + titulo + ", expositor=" + expositor + ", fecha=" + fecha + ", hora=" + hora + ", cupo=" + cupo + '}';
    }

   
    
    
            
}
