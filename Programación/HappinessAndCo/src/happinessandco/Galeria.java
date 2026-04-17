/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package happinessandco;

/**
 *
 * @author heidi
 */
class Galeria {

    private String id;
    private String titulo;
    private String idEvento;

    public Galeria(String id, String titulo, String idEvento) {
        this.id = id;
        this.titulo = titulo;
        this.idEvento = idEvento;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Id:" + id + "\t Titulo:" + titulo + "\t idEvento:" + idEvento;
    }

}
