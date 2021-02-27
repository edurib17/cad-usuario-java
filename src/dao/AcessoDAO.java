
package dao;

import Fabrica.ConnectionFabrica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcessoDAO {
    private Connection connection ;
    String login;
    String senha;
    
    public AcessoDAO(){
        
        this.connection = new ConnectionFabrica().getConnection();
    }
    
    public boolean checkLogin (String login, String senha){
        
        String sql =  "Select * from acesso where login = ? and senha = ?";
        ResultSet rs= null;
        boolean check = false;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,login);
            stmt.setString(2,senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                
                check = true ;
            
               
            }
        }catch(Exception ex){
            
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        return check;
        
       
    }
    
}
