package br.com.trainning.dao;

import br.com.trainning.model.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO extends ConnectAbstract implements InterfaceSellerDAO {

	public SellerDAO(Connection con) {
		super(con);
	}

	@Override
	public String inserir(Seller Seller) {

		String sql = "insert into coursejdbc.Seller (Id, Name, Email, Birthdate, BaseSalary, DepartmentId) values (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement sel = getCon().prepareStatement(sql);
			// Posicao da ? ficar atento a sequencia
			sel.setInt(1, Seller.getId());
			sel.setString(2, Seller.getName());
			sel.setString(3, Seller.getEmail());
			sel.setDate(4, Seller.getBirthdate());
			sel.setDouble(5, Seller.getBaseSalary());
			sel.setInt(6, Seller.getDepartmentId());

			return (sel.executeUpdate() > 0 ? "Inserido com Sucesso" : "Erro ao Inserir");

		} catch (SQLException e) {
			System.err.println(SellerDAO.class.getName());
			return e.getMessage();

		}

	}

	@Override
	public String alterar(Seller Seller) {

		String sql = "update coursejdbc.Seller set BaseSalary=BaseSalary + ? where DepartmentId=?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			// Posicao da ? lembrar da sequencia do sql
			ps.setDouble(1, 200.00);
			ps.setInt(2, 2);

			int rows = ps.executeUpdate();
			System.out.println("Linha alteradas: " + rows);
			// ternario
			return ( rows > 0 ? "Alterado com Sucesso" : "Erro ao Alterar");

		} catch (SQLException e) {
			System.err.println(SellerDAO.class.getName());
			return e.getMessage();

		}

	}

	@Override
	public String excluir(Seller Seller) {

		String sql = "delete from coursejdbc.Seller where id=?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			// Posicao da ? lembrar da sequencia do sql
			ps.setInt(1, Seller.getId());

			// ternario
			return (ps.executeUpdate() > 0 ? "Excluido com Sucesso" : "Erro ao Excluir");

		} catch (SQLException e) {
			System.err.println(SellerDAO.class.getName());
			return e.getMessage();

		}

	}

	@Override
	public List<Seller> listarTodos() {

		String sql = "select * from coursejdbc.Seller";

		List<Seller> listaSeller = new ArrayList();

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Seller Seller = new Seller();
					
					Seller.setId(rs.getInt(1));
					Seller.setName(rs.getString(2));
					Seller.setEmail(rs.getString(3));
					Seller.setBirthdate(rs.getDate(4));
					Seller.setBaseSalary(rs.getDouble(5));
					Seller.setDepartmentId(rs.getInt(6));

					listaSeller.add(Seller);
				}
				return (listaSeller);

			} else {
				return (null);

			}

		} catch (SQLException e) {
			System.err.println(SellerDAO.class.getName());
			return null;

		}

	}

	public boolean login(int id, String name) {
		boolean autenticado = false;

		String sql = "select * from coursejdbc.Seller where id=?";

		try {

			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setInt(1, id);
			ps.setString(2, name);

			ResultSet rs = ps.executeQuery();

			return rs.next() ? autenticado = true : autenticado;

		} catch (SQLException e) {
			System.err.println(SellerDAO.class.getName());
			return false;

		}

	}

}
