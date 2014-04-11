/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import conection.MySQLDB;
import domain.Tarea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class TareasDAO {
    private MySQLDB mysqlDB;

    
    public void agregar(Tarea tarea) throws SQLException{
        mysqlDB=new MySQLDB();
        String sql="INSERT INTO `qa`.`tareas` (`id`, `nombre`, `descripcion`, `id_proyecto`) VALUES ('"+tarea.getId()+"', '"+tarea.getNombre()+"', '"+tarea.getDescripcion()+"', '"+tarea.getId_Proyecto()+"')";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
    
    public void actualizar(Tarea tarea)throws SQLException{
        mysqlDB =new MySQLDB();
        String sql="UPDATE `qa`.`tareas` SET `nombre`='"+tarea.getNombre()+"', `descripcion`='"+tarea.getDescripcion()+"' WHERE `id`='"+tarea.getId()+"'";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
            
    
    
    public boolean exits (Tarea tarea) throws SQLException{
        boolean exist =false;
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM tareas WHERE nombre='"+tarea.getNombre()+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            exist=true;
        }
        mysqlDB.closeExecuteQuery();
        return exist;
    }
    
    public ArrayList obtener(int cod_proyecto) throws SQLException{
        
        mysqlDB =new MySQLDB();
        String sql= "select * from qa.tareas Where id_proyecto='"+cod_proyecto+"' ";
        ResultSet res =mysqlDB.executeQuery(sql);
        ArrayList<Tarea> a= new ArrayList();
        while(res.next()){
            Tarea t= new Tarea();
            t.setId(res.getInt("id"));
            t.setNombre(res.getString("nombre"));
            t.setDescripcion(res.getString("descripcion"));
            t.setId_Proyecto(res.getInt("id_proyecto"));
            a.add(t);
        }
        mysqlDB.closeExecuteQuery();
        return a;
        
        
        
    }
    
    public Tarea buscar(Tarea tarea) throws SQLException{
        mysqlDB =new MySQLDB();
        String sql= "select * from tareas WHERE id= '"+tarea.getId()+"'";
        ResultSet res =mysqlDB.executeQuery(sql);
        if(res.next()){
            Tarea t= new Tarea();
            if(res.getInt("id_proyecto")==tarea.getId_Proyecto()){
                t.setId(res.getInt("id"));
                t.setNombre(res.getString("nombre"));
                t.setDescripcion(res.getString("descripcion"));
                t.setId_Proyecto(res.getInt("id_proyecto"));
                return t;
            }
            
        }
        mysqlDB.closeExecuteQuery();
        return null;
        
    }
    
    public boolean existe (Tarea tarea) throws SQLException{
        boolean exist =false;
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM tareas WHERE id='"+tarea.getId()+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            exist=true;
        }
        mysqlDB.closeExecuteQuery();
        return exist;
    }
    
}
