/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import conection.MySQLDB;
import domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author william
 */
public class UsuariosDAO {
    private MySQLDB mysqlDB;
    
   
    public Usuario encontrar (String usuario) throws SQLException{
        
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM usuarios WHERE usuario='"+usuario+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            Usuario user=new Usuario();
            user.setId(res.getInt("id"));
            user.setNombre(res.getString("nombre"));
            user.setUsuario(res.getString("usuario"));
            user.setPass(res.getString("contraseña"));
            user.setPuesto(res.getString("puesto"));
            return user;
        }
        mysqlDB.closeExecuteQuery();
        return null;
    }
    
    public void agregar(Usuario usuario) throws SQLException{
        mysqlDB=new MySQLDB();
        String sql="INSERT INTO `qa`.`usuarios` (`usuario`, `contraseña`, `nombre`, `puesto`) VALUES ('"+usuario.getUsuario()+"', '"+usuario.getPass()+"', '"+usuario.getNombre()+"', '"+usuario.getPuesto()+"');";
        mysqlDB.execute(sql);
        mysqlDB.closeExecute();
        
    }
    
    
    public boolean exits (Usuario usuario) throws SQLException{
        boolean exist =false;
        mysqlDB=new MySQLDB();
        String sql="SELECT * FROM usuarios WHERE usuario='"+usuario.getUsuario()+"'"; 
        ResultSet res = mysqlDB.executeQuery(sql);
        if(res.next()){
            exist=true;
        }
        mysqlDB.closeExecuteQuery();
        return exist;
    }
    
    
    
}
