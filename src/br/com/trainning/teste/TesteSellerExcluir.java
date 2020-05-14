package br.com.trainning.teste;

import java.sql.Connection;

import br.com.trainning.dao.SellerDAO;
import br.com.trainning.model.Seller;
import br.com.trainning.util.Conexao;

public class TesteSellerExcluir {

	public static void main(String[] args) {
        Connection con = Conexao.abrirConexao();
        
        Seller dep = new Seller();
        Seller dao = new Seller(con);
        
        dep.setId(5);
        dep.setName("Erro5555");
        
        dao.excluir(dep);

	}

}
