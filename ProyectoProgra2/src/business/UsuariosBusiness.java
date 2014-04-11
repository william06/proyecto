/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.UsuariosDAO;
import domain.Usuario;
import java.sql.SQLException;

/**
 *
 * @author william
 */
public class UsuariosBusiness {
    UsuariosDAO usuarioDAO;

    public UsuariosBusiness() {
        usuarioDAO= new UsuariosDAO();
    }
    
    public Usuario encontrar (String usuario) throws SQLException{
        return usuarioDAO.encontrar(usuario);
        
    }
    
    public void agregar(Usuario usuario)throws SQLException, Exception{
        if(!usuarioDAO.exits(usuario)){
            usuarioDAO.agregar(usuario);
        }else{
            throw new Exception("el nombre de usuario ya esta en uso");
        }
    }
    
    
}
