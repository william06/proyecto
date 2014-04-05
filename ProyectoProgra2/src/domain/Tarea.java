/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author william
 */
public class Tarea {
    private int id;
    private String nombre;
    private String descripcion;
    private int id_Proyecto;
    

    public Tarea() {
    }

    public Tarea(int id, String nombre, String descripcion, int id_Proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id_Proyecto = id_Proyecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(int id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }

   
    
    
    
}
