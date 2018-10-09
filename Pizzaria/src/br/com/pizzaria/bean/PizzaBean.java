package br.com.pizzaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pizzaria.DAO.SaboresDAO;
import br.com.pizzaria.DAO.PizzaDAO;
import br.com.pizzaria.domain.Sabores;
import br.com.pizzaria.domain.Pizza;
import br.com.pizzaria.util.JSFUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class PizzaBean {

	private Pizza pizza;
	private ArrayList<Pizza> itens;
	private ArrayList<Pizza> itensFiltrados;

	private ArrayList<Sabores> comboFornecedores;

	public ArrayList<Sabores> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Sabores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	public Pizza getProdutos() {
		return pizza;
	}

	public void setProdutos(Pizza pizza) {
		this.pizza = pizza;
	}

	public ArrayList<Pizza> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Pizza> itens) {
		this.itens = itens;
	}

	public ArrayList<Pizza> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Pizza> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		PizzaDAO pdao = new PizzaDAO();
		try {
			itens = pdao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getmessage()");
			e.printStackTrace();
		}

	}
	public void prepararNovo() {
		pizza = new Pizza();
		
		SaboresDAO dao = new SaboresDAO();
		
		try {
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getmessage()");
			e.printStackTrace();
		}
	}
	public void novo() {
		try {
			PizzaDAO fdao = new PizzaDAO();
			fdao.salvar(pizza);
			
			itens = fdao.listar();
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void excluir(){
		try {
			PizzaDAO fdao = new PizzaDAO();
			fdao.excluir(pizza);
			
			itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void editar(){
		try {
			PizzaDAO fdao = new PizzaDAO();
			fdao.editar(pizza);
			
			itens = fdao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.adicionarMensagemErro("Selecione um fornecedor.");
			e.printStackTrace();
		}
	}
	public void prepararEditar() {
		pizza = new Pizza();
		
		SaboresDAO dao = new SaboresDAO();
		
		try {
			comboFornecedores = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getmessage()");
			e.printStackTrace();
		}
	}
}
