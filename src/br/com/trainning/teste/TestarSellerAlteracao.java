package br.com.trainning.teste;

import java.sql.Connection;
import br.com.trainning.dao.SellerDAO;
import br.com.trainning.model.Seller;
import br.com.trainning.util.Conexao;


public class TestarSellerAlteracao {

	public static void main(String[] args) {
		
        Connection con = Conexao.abrirConexao();
        
        Seller sel = new Seller();
        SellerDAO dao = new SellerDAO(con);
        
        
        dao.alterar(sel);

        Conexao.fecharConexao(con);
	}

}
