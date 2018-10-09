package br.com.pizzaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;

import org.primefaces.util.Jsf22Helper;

import br.com.pizzaria.DAO.SaboresDAO;
import br.com.pizzaria.domain.Sabores;
import br.com.pizzaria.util.JSFUtil;

@ManagedBean(name = "MBSabores")
@ViewScoped
public class SaboresBean {

	private Sabores sabores;
	private ArrayList<Sabores> itens;
	private ArrayList<Sabores> itensFiltrados;

	public void setItens(ArrayList<Sabores> itens) {
		this.itens = itens;
	}

	public ArrayList<Sabores> getItens() {
		return itens;
	}

	public void setItensFiltrados(ArrayList<Sabores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Sabores> getItensFiltrados() {
		return itensFiltrados;
	}

	public Sabores getSabores() {
		return sabores;
	}

	public void setSabores(Sabores sabores) {
		this.sabores = sabores;
	}

	/*
	 * private ListDataModel<Sabores> itens;
	 * 
	 * public ListDataModel<Sabores> getItens() { return itens; }
	 * 
	 * public void setItens(ListDataModel<Sabores> itens) { this.itens =
	 * itens; }
	 */

	@PostConstruct
	public void prepararPesquisa() {
		

		try {
			SaboresDAO fdao = new SaboresDAO();
			itens = fdao.listar();
			
		// mudança de Lista da model para Array list	itens = new ListDataModel<Sabores>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();

		}
	}

	public void prepararNovo() {
		sabores = new Sabores();

	}
	

	public void novo() {

		try {
			SaboresDAO fdao = new SaboresDAO();
			fdao.salvar(sabores);
			
			JSFUtil.adicionarMensagemSucesso("Sabor Salvo com Sucesso!");
			System.out.println("Sabor Salvo com Sucesso!");
			
			itens = fdao.listar();
			//ArrayList<Sabores> lista = fdao.listar();
			//itens = new ListDataModel<Sabores>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
/*
	public void prepararExcluir() {
	//	sabores = itens.getRowData();
	}*/

	public void excluir() {

		try {
			SaboresDAO fdao = new SaboresDAO();
			fdao.excluir(sabores);
			
			itens = fdao.listar();

			//ArrayList<Sabores> lista = fdao.listar();
			//itens = new ListDataModel<Sabores>(lista);

			JSFUtil.adicionarMensagemSucesso("Sabor excluido com sucesso");

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			JSFUtil.adicionarMensagemErro("Não é possivel EXCLUIR um Sabor que tenha um produto associado!");
			JSFUtil.adicionarMensagemErro("ex.getMessage");
			e.printStackTrace();
		}
	}
/*
	public void prepararEditar() {
//		sabores = itens.getRowData();
	}*/

	public void editar() {
		try {
			SaboresDAO fdao = new SaboresDAO();
			fdao.editar(sabores);
			
			itens = fdao.listar();

			//ArrayList<Sabores> lista = fdao.listar();
			//itens = new ListDataModel<Sabores>(lista);

			JSFUtil.adicionarMensagemSucesso("Sabor editado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			JSFUtil.adicionarMensagemErro("ex.getMessage");
		}
	}

}
