package br.com.trainning.dao;

import java.util.List;

import br.com.trainning.model.Seller;
import br.com.trainning.model.Seller;

public interface InterfaceSellerDAO {

    public String inserir(Seller Seller);
    
    public String alterar(Seller Seller);
    
    public String excluir(Seller Seller);
    
    public List<Seller> listarTodos();
 
}
