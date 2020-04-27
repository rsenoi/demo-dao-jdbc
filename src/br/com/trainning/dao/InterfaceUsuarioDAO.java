/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trainning.dao;

import br.com.trainning.model.Usuario;
import java.util.List;

/**
 *
 * @author Trainning
 */
public interface InterfaceUsuarioDAO {
    
    public String inserir(Usuario usuario);
    
    public String alterar(Usuario usuario);
    
    public String excluir(Usuario usuario);
    
    public List<Usuario> listarTodos();
    
    
}
