package br.com.pizzaria.domain;

public class Sabores {
	
	private Long codigo;
	private String descricao;
	private String ingredientes;
	
	
	
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String saida = codigo + " - " + descricao;
		return saida;
	}
	

}
