/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author william
 */
public class Issue {
    private int id;
    private String titulo;
    private String descripcion;
    private int id_tarea;

    public Issue() {
    }

    public Issue(int id, String titulo, String descripcion, int id_tarea) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.id_tarea = id_tarea;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }
    
    
    
}
