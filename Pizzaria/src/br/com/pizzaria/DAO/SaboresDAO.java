package br.com.pizzaria.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.pizzaria.domain.Sabores;
import br.com.pizzaria.factory.ConexaoFactory;

public class SaboresDAO {

	public void salvar(Sabores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO sabores ");
		sql.append("(sab_descricao, sab_ingredientes) ");
		sql.append("VALUES (?, ?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setString(2, f.getIngredientes());
		comando.executeUpdate();
	}

	public void excluir(Sabores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM sabores ");
		sql.append("WHERE sab_codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}

	public void editar(Sabores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE sabores ");
		sql.append("SET sab_descricao = ?, sab_ingredientes = ? ");
		sql.append("WHERE sab_codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getDescricao());
		comando.setString(2, f.getIngredientes());
		comando.setLong(3, f.getCodigo());
		comando.executeUpdate();

	}

	public Sabores buscaPorCodigo(Sabores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT sab_codigo, sab_descricao, sab_ingredientes ");
		sql.append("FROM sabores ");
		sql.append("WHERE sab_codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Sabores retorno = null;

		if (resultado.next()) {
			retorno = new Sabores();
			retorno.setCodigo(resultado.getLong("sab_codigo"));
			retorno.setDescricao(resultado.getString("sab_descricao"));
			retorno.setIngredientes(resultado.getString("sab_ingredientes"));
		}
		return retorno;
	}

	public ArrayList<Sabores> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT sab_codigo, sab_descricao, sab_ingredientes ");
		sql.append("FROM sabores ");
		sql.append("ORDER BY sab_descricao ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Sabores> lista = new ArrayList<Sabores>();

		while (resultado.next()) {
			Sabores f = new Sabores();
			f.setCodigo(resultado.getLong("sab_codigo"));
			f.setDescricao(resultado.getString("sab_descricao"));
			f.setIngredientes(resultado.getString("sab_ingredientes"));

			lista.add(f);
		}

		return lista;
	}

	public ArrayList<Sabores> buscarPorDescricao(Sabores f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT sab_codigo, sab_descricao, sab_ingredientes ");
		sql.append("FROM sabores ");
		sql.append("WHERE sab_descricao LIKE ? ");
		sql.append("ORDER BY sab_descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Sabores> lista = new ArrayList<Sabores>();

		while (resultado.next()) {
			Sabores item = new Sabores();
			item.setCodigo(resultado.getLong("sab_codigo"));
			item.setDescricao(resultado.getString("sab_descricao"));
			item.setIngredientes(resultado.getString("sab_ingredientes"));

			lista.add(item);
		}
		return lista;
	}

	public static void main(String[] args) {

		Sabores f1 = new Sabores();
		f1.setDescricao("BACON");
		f1.setIngredientes("bacon, massa de tomate, queijo");

		Sabores f2 = new Sabores();
		f2.setDescricao("FRANGO");
		f2.setIngredientes("FRANGO, MASSA DE TOMATE, QUEIJO, OREGANO");

		SaboresDAO fdao = new SaboresDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Salvo com SUCESSO");
		} catch (SQLException e) { // TODO Auto-generated catch block
			System.out.println("Não gravou no BD");
			e.printStackTrace();

		}

		/*
		 * Sabores f1 = new Sabores(); f1.setCodigo(2);
		 * 
		 * SaboresDAO fdao = new SaboresDAO();
		 * 
		 * try{ fdao.excluir(f1);
		 * 
		 * System.out.println("Deletado com sucesso!!"); } catch (Exception e) {
		 * // TODO: handle exception System.out.println("Erro ao deletar");
		 * e.printStackTrace(); }
		 */
		/*
		 * Sabores f1 = new Sabores(); f1.setCodigo(1);
		 * f1.setDescricao("LEANDRO MARQUES");
		 * 
		 * SaboresDAO fdao = new SaboresDAO();
		 * 
		 * try { fdao.editar(f1);
		 * 
		 * System.out.println("Editado com sucesso!!"); } catch (Exception e) {
		 * // TODO: handle exception System.out.println("Erro ao Editar");
		 * e.printStackTrace(); }
		 */
		/*
		 * Sabores f1 = new Sabores(); f1.setCodigo(1);
		 * 
		 * Sabores f2 = new Sabores(); f2.setCodigo(10);
		 * 
		 * SaboresDAO fdao = new SaboresDAO();
		 * 
		 * try { Sabores f3 = fdao.buscaPorCodigo(f1); Sabores f4 =
		 * fdao.buscaPorCodigo(f2);
		 * 
		 * System.out.println("Resultado 1: " + f3);
		 * System.out.println("Resultado 2: " + f4);
		 * 
		 * }catch (Exception e) { // TODO: handle exception
		 * System.out.println("Erro aoa buscar"); e.printStackTrace(); }
		 */
		/*
		 * SaboresDAO fdao = new SaboresDAO();
		 * 
		 * try { ArrayList<Sabores> lista = fdao.listar();
		 * 
		 * for (Sabores f : lista) { System.out.println("Resultado " + f);
		 * } } catch (Exception e) { // TODO: handle exception
		 * System.out.println("ERRO ao listar"); e.printStackTrace(); }
		 */
		/*
		 * Sabores f1 = new Sabores();
		 * 
		 * f1.setDescricao("1");
		 * 
		 * SaboresDAO fdao = new SaboresDAO();
		 * 
		 * try { ArrayList<Sabores>lista = fdao.buscarPorDescricao(f1);
		 * 
		 * for(Sabores f : lista){ System.out.println("Resultado " + f); }
		 * 
		 * } catch (Exception e2) { // TODO: handle exception
		 * System.out.println("ERRO ERRO "); e2.printStackTrace(); }
		 */

	}
}
