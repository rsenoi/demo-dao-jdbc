package br.com.trainning.dao;

import java.util.List;

import br.com.trainning.model.Department;
import br.com.trainning.model.Department;

public interface InterfaceDepartmentDAO {

    public String inserir(Department department);
    
    public String alterar(Department department);
    
    public String excluir(Department department);
    
    public List<Department> listarTodos();
 
}
