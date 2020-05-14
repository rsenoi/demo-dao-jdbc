package br.com.trainning.teste;

import java.sql.Connection;

import br.com.trainning.dao.SellerDAO;
import br.com.trainning.model.Seller;
import br.com.trainning.util.Conexao;

public class TesteSellerInsercao {

	public static void main(String[] args) {
        Connection con = Conexao.abrirConexao();
        
        Seller sell = new Seller();
        SellerDAO dao = new SellerDAO(con);
       
        sell.setName("Teste7");
        sell.setEmail("EmailTeste7");
        sell.setBirthdate(null);
        sell.setBaseSalary(1000.00);
        sell.setDepartmentId(2);
        
        dao.inserir(sell);

        Conexao.fecharConexao(con);

	}

}
