package br.com.connectionDB.model;

import java.sql.Date;

public class Pessoa {

	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private Date dt_nascimento;
	private int cpf;
	
	public Pessoa(int id, String nome, String telefone, String email, String endereco, Date dt_nascimento, int cpf) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.dt_nascimento = dt_nascimento;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Date getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "{ id: " + this.id +
				" nome: " + this.nome +
				"telefone:" + this.telefone +
				"email" + this.email +
				"endereco" + this.endereco + 
				"dt_nascimento" + this.dt_nascimento +
				" cpf: " + this.cpf;
	}

	
}

