/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import conection.MySQLDB;
import domain.Issue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class IssuesDAO {
     private MySQLDB mysqlDB;
    
    public void agregar(Issue issue) throws SQLException{
        mysqlDB=new MySQLDB();
        String sql="INSERT INTO `qa`.`issues` (`id`, `titulo`, `descripcion`, `id_tarea`) VALUES ('"+issue.getId()+"', '"+issue.getTitulo()+"', '"+issue.getDescripcion()+"', '"+issue.getId_tarea()+"')";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
    
     public void actualizar(Issue issue) throws SQLException{
        mysqlDB =new MySQLDB();
        String sql="UPDATE `qa`.`issues` SET `titulo`='"+issue.getTitulo()+"', `descripcion`='"+issue.getDescripcion()+"' WHERE `id`='"+issue.getId()+"'";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
    
   public Issue buscar(Issue issue) throws SQLException{
        mysqlDB =new MySQLDB();
        String sql= "select * from issues WHERE id= '"+issue.getId()+"'";
        ResultSet res =mysqlDB.executeQuery(sql);
        if(res.next()){
            Issue i= new Issue();
            if(res.getInt("id_tarea")==issue.getId_tarea()){
                i.setId(res.getInt("id"));
                i.setTitulo(res.getString("titulo"));
                i.setDescripcion(res.getString("descripcion"));
                i.setId_tarea(res.getInt("id_tarea"));
                return i;
            }
            
        }
        mysqlDB.closeExecuteQuery();
        return null;
        
    }
    
      public ArrayList obtener(int cod_tarea) throws SQLException{
        
        mysqlDB =new MySQLDB();
        String sql= "select * from qa.issues Where id_tarea='"+cod_tarea+"' ";
        ResultSet res =mysqlDB.executeQuery(sql);
        ArrayList<Issue> a= new ArrayList();
        while(res.next()){
            Issue i= new Issue();
            i.setId(res.getInt("id"));
            i.setTitulo(res.getString("titulo"));
            i.setDescripcion(res.getString("descripcion"));
            i.setId_tarea(res.getInt("id_tarea"));
            a.add(i);
        }
        mysqlDB.closeExecuteQuery();
        return a;
      }
        
       public boolean exits (Issue issue) throws SQLException{
        boolean exist =false;
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM issues WHERE titulo='"+issue.getTitulo()+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            exist=true;
        }
        mysqlDB.closeExecuteQuery();
        return exist;
    } 
        
       public boolean existe (Issue issue) throws SQLException{
        boolean exist =false;
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM issues WHERE id='"+issue.getId()+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            exist=true;
        }
        mysqlDB.closeExecuteQuery();
        return exist;
    }
    
}
