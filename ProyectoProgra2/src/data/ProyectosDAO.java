/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import conection.MySQLDB;
import domain.Proyecto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author william
 */
public class ProyectosDAO {
    private MySQLDB mysqlDB;
    
    
    public void agregar(Proyecto proyecto) throws SQLException{
        mysqlDB=new MySQLDB();
        String sql="INSERT INTO `qa`.`proyectos` (`id`, `nombre`, `descripcion`, `id_usuario`) VALUES ('"+proyecto.getId()+"', '"+proyecto.getNombre()+"', '"+proyecto.getDetalle()+"', '"+proyecto.getId_usuario()+"')";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
    
    
    public void borrar(Proyecto proyecto)throws SQLException{
        mysqlDB=new MySQLDB();
        String sql="DELETE FROM proyectos WHERE id='"+proyecto.getId()+"'";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
    
    
    
    
    
    
    public boolean exits (Proyecto proyecto) throws SQLException{
        boolean exist =false;
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM proyectos WHERE nombre='"+proyecto.getNombre()+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            exist=true;
        }
        mysqlDB.closeExecuteQuery();
        return exist;
    }
    
    
    
    public ArrayList obtener(int id_usuario) throws SQLException{
        
        mysqlDB =new MySQLDB();
        String sql= "select * from proyectos WHERE id_usuario='"+id_usuario+"'";
        ResultSet res =mysqlDB.executeQuery(sql);
        ArrayList<Proyecto> a= new ArrayList();
        while(res.next()){
            Proyecto p= new Proyecto();
            p.setId(res.getInt("id"));
            p.setNombre(res.getString("nombre"));
            p.setDetalle(res.getString("descripcion"));
            p.setId_usuario(res.getInt("id_usuario"));
            a.add(p);
        }
        mysqlDB.closeExecuteQuery();
        return a;
        
        
        
    }
    
    public void actualizar(Proyecto proyecto) throws SQLException{
        mysqlDB =new MySQLDB();
        String sql="UPDATE `qa`.`proyectos` SET `nombre`='"+proyecto.getNombre()+"', `descripcion`='"+proyecto.getDetalle()+"' WHERE `id`='"+proyecto.getId()+"'";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
    }
    
    
    
    
    public Proyecto buscar(Proyecto proyecto) throws SQLException{
        mysqlDB =new MySQLDB();
        String sql= "select * from proyectos WHERE id= '"+proyecto.getId()+"'";
        ResultSet res =mysqlDB.executeQuery(sql);
        if(res.next()){
            Proyecto p= new Proyecto();
            if(res.getInt("id_usuario")==proyecto.getId_usuario()){
                p.setId(res.getInt("id"));
                p.setNombre(res.getString("nombre"));
                p.setDetalle(res.getString("descripcion"));
                p.setId_usuario(res.getInt("id_usuario"));
                return p;
            }
            
        }
        mysqlDB.closeExecuteQuery();
        return null;
        
    }
    
    public boolean existe(Proyecto proyecto) throws SQLException{
        boolean existe=false;
        mysqlDB =new MySQLDB();
        String sql= "select * from proyectos WHERE id= '"+proyecto.getId()+"'";
        ResultSet res =mysqlDB.executeQuery(sql);
        if(res.next()){
            existe=true;
        }
        mysqlDB.closeExecuteQuery();
        return existe;
        
        
        
    }
    
    
    
    
}
