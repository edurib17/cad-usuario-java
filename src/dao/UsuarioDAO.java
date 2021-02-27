/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Fabrica.ConnectionFabrica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Usuario;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    private Connection connection;
    long idcodigo;
    String nome;
    String cpf;
    String endereco;
    String sexo;
    
    public UsuarioDAO(){
        this.connection = new ConnectionFabrica().getConnection();
        
        
    }
    public void adiciona(Usuario usuario){
        String sql = "Insert into usuario(nome,cpf,endereco,sexo)values(?,?,?,?)";
        try{
             PreparedStatement stmt = connection.prepareStatement(sql);
             stmt.setString(1, usuario.getNome());
             stmt.setString(2, usuario.getCpf());
             stmt.setString(3, usuario.getEndereco());
             stmt.setString(4, usuario.getSexo());
             stmt.execute();
             stmt.close();
             
        
        } catch(SQLException u){
            throw new RuntimeException(u);
          
        }
   }
    
    public void Update (Usuario u){
           String sql = "update usuario SET nome = ?, cpf = ?, endereco = ?, sexo = ? where idcodigo = ?";
            try{

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, u.getNome());

            stmt.setString(2, u.getCpf());

            stmt.setString(3, u.getEndereco());

            stmt.setString(4, u.getSexo());

            stmt.setLong(5, u.getIdcodigo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao Atualizar"+ex);

            }
        
    }
    
    public List<Usuario> LEIA(){
        ResultSet rs= null;
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "Select * from usuario";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdcodigo(rs.getLong("idcodigo"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setSexo(rs.getString("sexo"));
                usuarios.add(usuario);
               
            }
        }
        
        catch(SQLException ex){
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,ex);        
        
        }return usuarios;
    }
    public List<Usuario> readForNome(String Nome){
        ResultSet rs = null;
        String sql = "Select * from usuario where nome like ?";
        List<Usuario> Usuarios = new ArrayList<>();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+Nome+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario usuario = new  Usuario();
                usuario.setIdcodigo(rs.getLong("idcodigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setSexo(rs.getString("sexo"));
                Usuarios.add(usuario);
            }
        
        }catch(SQLException ex){
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,ex);   
             
        }
        return Usuarios;
    }
    
    
    
}
