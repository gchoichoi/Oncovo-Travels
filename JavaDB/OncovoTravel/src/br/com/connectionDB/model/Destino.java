package br.com.connectionDB.model;

public class Destino {

	private int id;
	private String cidade;
	private String estado;
	
	public Destino(int id, String cidade, String estado) {
		this.id = id;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	@Override
	public String toString() {
		return "{ id: " + this.id +
				" cidade: " + this.cidade +
				"estado:" + this.estado ;
	}

	
}
