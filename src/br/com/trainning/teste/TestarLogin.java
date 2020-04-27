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
public class TestarLogin {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		UsuarioDAO dao = new UsuarioDAO(con);

		String usuario = "xxx";
		String senha = "123";

		if (dao.login(usuario, senha, "admin")) {
			System.out.println("Logou com Admin");
		} else if (dao.login(usuario, senha, "usuario")) {
			System.out.println("Logou com Usuario");
		} else {
			System.out.println("Logou com erro");
		}

		Conexao.fecharConexao(con);

	}
}
