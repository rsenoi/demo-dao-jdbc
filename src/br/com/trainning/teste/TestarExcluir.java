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

/**
 *
 * @author Trainning
 */
public class TestarExcluir {
    
    public static void main(String[] args) {
        
        Connection con = Conexao.abrirConexao();
        
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO(con);
        
        usuario.setId(3);
        
        dao.excluir(usuario);

        Conexao.fecharConexao(con);


        
    }
}
