/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.ProyectosDAO;
import domain.Proyecto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class ProyectosBusiness {
    private ProyectosDAO proyectoDAO;
    
    

    public ProyectosBusiness() {
        proyectoDAO=new ProyectosDAO();
    }
    
    
    public void agregar(Proyecto proyecto) throws SQLException, Exception{
        if(!(proyectoDAO.exits(proyecto))){
            proyectoDAO.agregar(proyecto);
        }else{
            throw new Exception("El proyecto ya existe en la BD");
        } 
    }
    
    public void borrar(Proyecto proyecto) throws SQLException, Exception{
        if(proyectoDAO.existe(proyecto)==true){
            proyectoDAO.borrar(proyecto);
        }else{
            throw new Exception("El proyecto no existe en la BD");
        } 
    }
    
    public ArrayList obtener(int id_usuario) throws SQLException{
        return proyectoDAO.obtener(id_usuario);
    }
    
    public Proyecto buscar(Proyecto proyecto) throws SQLException, Exception{
        if(proyectoDAO.existe(proyecto)==true){
            return proyectoDAO.buscar(proyecto);
        }else{
            throw new Exception("El proyecto no existe en la BD");
        } 
        
        
    }
    
    public void actualizar(Proyecto proyecto) throws SQLException, Exception{
        if(proyectoDAO.existe(proyecto)==true){
            proyectoDAO.actualizar(proyecto);
        }else{
            throw new Exception("El proyecto no existe en la BD");
        } 
    }
    
    public boolean existe(Proyecto proyecto) throws SQLException{
        return proyectoDAO.existe(proyecto);
    }
    
    
}
