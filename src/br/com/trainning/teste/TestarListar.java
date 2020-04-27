/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trainning.teste;

import br.com.trainning.dao.UsuarioDAO;
import br.com.trainning.model.Usuario;
import br.com.trainning.util.Conexao;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Trainning
 */
public class TestarListar {
    
    public static void main(String[] args) {
        
        Connection con = Conexao.abrirConexao();
        
        UsuarioDAO dao = new UsuarioDAO(con);
        
        List <Usuario> listar = dao.listarTodos();
        
        for( Usuario usr : listar ){
            System.out.println("id "+usr.getId()+" Usuario "+usr.getUsuario()+" Senha "+usr.getSenha()+" Tipo "+usr.getTipo());
        }
        

        Conexao.fecharConexao(con);

    }
    
}
