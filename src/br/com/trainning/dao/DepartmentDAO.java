package br.com.trainning.dao;

import br.com.trainning.model.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends ConnectAbstract implements InterfaceDepartmentDAO {

	public DepartmentDAO(Connection con) {
		super(con);
	}

	@Override
	public String inserir(Department department) {

		String sql = "insert into coursejdbc.Department (id, name) values (?, ?)";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			// Posicao da ? ficar atento a sequencia
			ps.setInt(1, department.getId());
			ps.setString(2, department.getName());

			// ternario
			return (ps.executeUpdate() > 0 ? "Inserido com Sucesso" : "Erro ao Inserir");

		} catch (SQLException e) {
			System.err.println(DepartmentDAO.class.getName());
			return e.getMessage();

		}

	}

	@Override
	public String alterar(Department department) {

		String sql = "update coursejdbc.departament set name=? where id=?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			// Posicao da ? lembrar da sequencia do sql
			ps.setString(1, department.getName());
			ps.setInt(4, department.getId());

			// ternario
			return (ps.executeUpdate() > 0 ? "Alterado com Sucesso" : "Erro ao Alterar");

		} catch (SQLException e) {
			System.err.println(DepartmentDAO.class.getName());
			return e.getMessage();

		}

	}

	@Override
	public String excluir(Department department) {

		String sql = "delete from coursejdbc.department where id=?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			// Posicao da ? lembrar da sequencia do sql
			ps.setInt(1, department.getId());

			// ternario
			return (ps.executeUpdate() > 0 ? "Excluido com Sucesso" : "Erro ao Excluir");

		} catch (SQLException e) {
			System.err.println(DepartmentDAO.class.getName());
			return e.getMessage();

		}

	}

	@Override
	public List<Department> listarTodos() {

		String sql = "select * from coursejdbc.department";

		List<Department> listaDepartment = new ArrayList();

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Department department = new Department();
					
					department.setId(rs.getInt(1));
					department.setName(rs.getString(2));

					listaDepartment.add(department);
				}
				return (listaDepartment);

			} else {
				return (null);

			}

		} catch (SQLException e) {
			System.err.println(DepartmentDAO.class.getName());
			return null;

		}

	}

	public boolean login(int id, String name) {
		boolean autenticado = false;

		String sql = "select * from coursejdbc.department where id=?";

		try {

			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setInt(1, id);
			ps.setString(2, name);

			ResultSet rs = ps.executeQuery();

			return rs.next() ? autenticado = true : autenticado;

		} catch (SQLException e) {
			System.err.println(DepartmentDAO.class.getName());
			return false;

		}

	}

}
