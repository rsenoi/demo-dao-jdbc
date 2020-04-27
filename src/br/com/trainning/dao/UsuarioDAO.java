/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trainning.dao;

import br.com.trainning.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trainning
 */
public class UsuarioDAO extends ConnectAbstract implements InterfaceUsuarioDAO{

    public UsuarioDAO(Connection con) {
        super(con);
    }

    @Override
    public String inserir(Usuario usuario) {
        
        String sql = "insert into usuario (usuario, senha, tipo) values (?, ?, ?)";
        
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            //Posicao da ? ficar atento a sequencia
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getTipo());
            
            /*
            if(ps.executeUpdate()>0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
 
            }
            */
            //ternario
            return( ps.executeUpdate()>0 ? "Inserido com Sucesso" : "Erro ao Inserir" );
            
        }catch(SQLException e){
            System.err.println(UsuarioDAO.class.getName());
            return e.getMessage();
            
        }
          

    }

    @Override
    public String alterar(Usuario usuario) {

            String sql = "update usuario set usuario=?, senha=?, tipo=? where id=?";
        
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            //Posicao da ? lembrar da sequencia do sql
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
           
            /*
            if(ps.executeUpdate()>0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
 
            }
            */
            //ternario
            return( ps.executeUpdate()>0 ? "Alterado com Sucesso" : "Erro ao Alterar" );
            
            }catch(SQLException e){
                System.err.println(UsuarioDAO.class.getName());
                return e.getMessage();
            
            }
        
    
    } 

    @Override
    public String excluir(Usuario usuario) {

            String sql = "delete from usuario where id=?";
        
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            //Posicao da ? lembrar da sequencia do sql
            ps.setInt(1, usuario.getId());

            /*
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
           
            /*
            if(ps.executeUpdate()>0){
                return "Inserido com Sucesso";
            }else{
                return "Erro ao Inserir";
 
            }
            */
            //ternario
            return( ps.executeUpdate()>0 ? "Excluido com Sucesso" : "Erro ao Excluir" );
            
            }catch(SQLException e){
                System.err.println(UsuarioDAO.class.getName());
                return e.getMessage();
            
            }

    
    }

    @Override
    public List<Usuario> listarTodos() {

            String sql = "select * from usuario order by id desc";
 
            List <Usuario> listaUsuario = new ArrayList();
            
            
            try{
            PreparedStatement ps = getCon().prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while( rs.next() ){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt(1));
                    usuario.setUsuario(rs.getString(2));
                    usuario.setSenha(rs.getString(3));
                    usuario.setTipo(rs.getString(4));
                    
                    listaUsuario.add(usuario);
                }
                return( listaUsuario );
            
 
            }else{
                return( null );
 
            }
            
           }catch(SQLException e){
                System.err.println(UsuarioDAO.class.getName());
                return null;
            
            }

    
    }
    
  public boolean login(String usuario, String senha, String tipo){  
      boolean autenticado = false;
      
           String sql = "select * from usuario where usuario=? and senha=? and tipo=?";
 
      
            try{
                
                PreparedStatement ps = getCon().prepareStatement(sql);

                ps.setString(1, usuario);
                ps.setString(2, senha);
                ps.setString(3, tipo);
 
                ResultSet rs = ps.executeQuery();
                
                return rs.next() ? autenticado = true : autenticado;

           
           }catch(SQLException e){
                System.err.println(UsuarioDAO.class.getName());
                return false;
            
            }
     
      
 }
  
    
}
