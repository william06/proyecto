/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author william
 */
public class Proyecto {
    private int id;
    private String nombre;
    private String detalle;
    private int id_usuario;

    public Proyecto() {
    }

    public Proyecto(int id, String nombre, String detalle, int id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.id_usuario = id_usuario;
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

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

   

    
    
    
    
}
