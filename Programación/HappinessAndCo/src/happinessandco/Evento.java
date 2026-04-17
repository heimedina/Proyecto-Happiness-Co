/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package happinessandco;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author heidi
 */
public class Evento {

    private String id;
    private LocalDate fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private ArrayList<Galeria> coleccionGaleria;

    public Evento(String id, LocalDate fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.coleccionGaleria = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Galeria> getColeccionGaleria() {
        return coleccionGaleria;
    }

    public void setColeccionGaleria(ArrayList<Galeria> coleccionGaleria) {
        this.coleccionGaleria = coleccionGaleria;
    }

    @Override
    public String toString() {
        return "id:" + id + "\t Fecha:" + fecha + "\t Titulo=" + titulo + "\t Ubicacion=" + ubicacion + "\t Descripcion:" + descripcion;
    }

}
