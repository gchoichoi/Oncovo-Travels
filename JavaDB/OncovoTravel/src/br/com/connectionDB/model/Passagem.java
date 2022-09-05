package br.com.connectionDB.model;

import java.sql.Date;

public class Passagem {

	private int id;
	private Date data_ida;
	private Date data_volta;
	private double valor_passagem;
	private int id_pessoa;
	private int id_destino;
	
	public Passagem(int id, Date data_ida, Date data_volta, double valor_passagem, int id_pessoa, int id_destino) {
		this.id = id;
		this.data_ida = data_ida;
		this.data_volta = data_volta;
		this.valor_passagem = valor_passagem;
		this.id_pessoa = id_pessoa;
		this.id_destino = id_destino;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData_ida() {
		return data_ida;
	}
	public void setData_ida(Date data_ida) {
		this.data_ida = data_ida;
	}
	
	public Date getData_volta() {
		return data_volta;
	}
	public void setData_volta(Date data_volta) {
		this.data_volta = data_volta;
	}
	
	public double getValor_passagem() {
		return valor_passagem;
	}
	public void setValor_passagem(double valor_passagem) {
		this.valor_passagem = valor_passagem;
	}
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
	
	
	@Override
	public String toString() {
		return  "{ id: " + this.id +
				"data_ida: " + this.data_ida +
				"data_volta: " + this.data_volta +
				"valor_passagem: " + this.valor_passagem +
				"id_pessoa: " + this.id_pessoa + 
				"id_destino: " + this.id_destino;
	}

	
}