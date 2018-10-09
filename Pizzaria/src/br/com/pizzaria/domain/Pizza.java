package br.com.pizzaria.domain;

public class Pizza {
	
	private Long codigo;
	private String descricao;
	private Long quantidade;
	private Double preco;
	private Sabores sabores = new Sabores();
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Sabores getFornecedores() {
		return sabores;
	}
	public void setFornecedores(Sabores sabores) {
		this.sabores = sabores;
	}
	
	
}
