/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package happinessandco;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author heidi
 */
public class Evento {
    
    private String id;
    private Date fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private ArrayList<Galeria> coleccionGaleria;

    public Evento(String id, Date fecha, String titulo, String ubicacion, String descripcion, ArrayList<Galeria> coleccionGaleria) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.coleccionGaleria = coleccionGaleria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
        return "Evento{" + "id=" + id + ", fecha=" + fecha + ", titulo=" + titulo + ", ubicacion=" + ubicacion + ", descripcion=" + descripcion + ", coleccionGaleria=" + coleccionGaleria + '}';
    }

    
    
    
}
