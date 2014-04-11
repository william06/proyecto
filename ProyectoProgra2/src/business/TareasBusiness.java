/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.TareasDAO;
import domain.Tarea;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class TareasBusiness {
    private TareasDAO tareaDAO;

    public TareasBusiness() {
        tareaDAO=new TareasDAO();
    }
    
    public void agregar(Tarea tarea) throws SQLException, Exception{
        if(!tareaDAO.exits(tarea)){
            tareaDAO.agregar(tarea);
        }else{
            throw new Exception("La tarea ya existe en la BD");
        }
            
    }
    
    public ArrayList obtener(int cod_proyecto) throws SQLException{
        return tareaDAO.obtener(cod_proyecto);
    }
    
    
    public Tarea buscar(Tarea tarea) throws SQLException, Exception{
        if(tareaDAO.existe(tarea)==true){
            return tareaDAO.buscar(tarea);
        }else{
            throw new Exception("La tarea  no existe ");
        } 
    }
    
    public void actualizar(Tarea tarea) throws SQLException, Exception{
        if(tareaDAO.existe(tarea)==true){
            tareaDAO.actualizar(tarea);
        }else{
            throw new Exception("La tarea  no existe ");
        } 
    }
    
}
