/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import data.IssuesDAO;
import domain.Issue;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class IssuesBusiness {
     private IssuesDAO issueDAO;

    public IssuesBusiness() {
        issueDAO=new IssuesDAO();
    }
     
   
    public void agregar(Issue issue) throws SQLException, Exception{
        if(!issueDAO.exits(issue)){
            issueDAO.agregar(issue);
        }else{
            throw new Exception("El issue ya existe en la BD");
        }
            
    }
    
     public void actualizar(Issue issue) throws SQLException, Exception{
        if(issueDAO.existe(issue)==true){
            issueDAO.actualizar(issue);
        }else{
            throw new Exception("El issue no existe en la BD");
        } 
    }
    
    
      public ArrayList obtener(int cod_tarea) throws SQLException{
        return issueDAO.obtener(cod_tarea);
    }
    
    
    public Issue buscar(Issue issue) throws SQLException, Exception{
        if(issueDAO.existe(issue)==true){
            return issueDAO.buscar(issue);
        }else{
            throw new Exception("El issue no existe ");
        } 
    }
}
