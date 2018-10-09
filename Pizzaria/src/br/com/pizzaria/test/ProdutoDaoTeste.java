package br.com.pizzaria.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.pizzaria.DAO.SaboresDAO;
import br.com.pizzaria.DAO.PizzaDAO;
import br.com.pizzaria.domain.Sabores;
import br.com.pizzaria.domain.Pizza;
import br.com.pizzaria.factory.ConexaoFactory;

public class ProdutoDaoTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException{

		Pizza p1 = new Pizza();
		p1.setDescricao("DIPIRONA");
		p1.setQuantidade(12L);
		p1.setPreco(2.99);
		Sabores f = new Sabores();
		f.setCodigo(20l);
		p1.setFornecedores(f);

		PizzaDAO pdao = new PizzaDAO();
		try {
			pdao.salvar(p1);
			System.out.println("Produto salvo com SUCESSO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao Salvar Produto");
			e.printStackTrace();
		}

	}
	
	@Test
	@Ignore
	public void listar()throws SQLException {
		
		PizzaDAO fdao = new PizzaDAO();
		ArrayList<Pizza> lista = fdao.listar();
		
		for (Pizza p : lista){
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Valor do Produto: " + p.getPreco());
			System.out.println("Código do Fornecedor: " + p.getFornecedores().getCodigo());
			System.out.println("Descrição do Fornecedor: " + p.getFornecedores().getDescricao());
			
			System.out.println("");
		}
	}
	@Test
	@Ignore
	public void excluir() throws SQLException {
		Pizza p = new Pizza();
		p.setCodigo(3L);
		
		
		PizzaDAO dao = new PizzaDAO();
		dao.excluir(p);
		
		System.out.println("Codigo Produto: " + p.getCodigo() + " Descrição do Produto: "
		+ p.getDescricao() + " excluido com sucesso");
	}
	@Test
	public void editar()throws SQLException {
		
		Pizza p = new Pizza();
		p.setCodigo(4L);
		p.setDescricao("Cataflan ooooooo");
		p.setPreco(20.00);
		p.setQuantidade(20L);
		
		Sabores f = new Sabores();
		f.setCodigo(50L);
		p.setFornecedores(f);
		
		PizzaDAO dao = new PizzaDAO();
		dao.editar(p);
	}
	
}
