package br.com.connectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.connectionDB.model.Pessoa;

public class PessoaDAO {

	public void listarPessoas() {
		String sql = "SELECT * FROM PESSOA";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    ResultSet result = pstm.executeQuery();
		    
			listar(result);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void salvaPessoa(Pessoa pessoa) {
		String sql = "INSERT INTO PESSOA VALUES(?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    inserir(pstm, pessoa);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void removePessoa(Pessoa pessoa) {
		String sql = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    remover(pstm, pessoa);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void alterarPessoa(Pessoa pessoa) {
		String sql = "UPDATE PESSOA SET NOME = ?, TELEFONE = ?, EMAIL = ?, ENDERECO = ?, DATA_NASCIMENTO = ? , CPF= ? WHERE ID_PESSOA = ?";
		Connection connection = null; 
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    atualizar(pstm, pessoa);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	private void listar(ResultSet result) throws SQLException{
		while(result.next()) { 
			System.out.println(String.format("id %s", result.getInt("ID_PESSOA"))); 
			System.out.println(String.format("nome %s", result.getString("NOME")));
			System.out.println(String.format("telefone %s", result.getString("TELEFONE")));
			System.out.println(String.format("email %s", result.getString("EMAIL")));
			System.out.println(String.format("endereco %s", result.getString("ENDERECO")));
			System.out.println(String.format("dt_nascimento %s", result.getDate("DATA_NASCIMENTO")));
			System.out.println(String.format("cpf %s", result.getInt("CPF")) + "\n"); 
		}
	}
	
	private void inserir(PreparedStatement pstm, Pessoa pessoa) throws SQLException {
		pstm.setInt(1, pessoa.getId());
		pstm.setString(2, pessoa.getNome());
		pstm.setString(3, pessoa.getTelefone());
		pstm.setString(4, pessoa.getEmail());
		pstm.setString(5, pessoa.getEndereco());
		pstm.setDate(6, pessoa.getDt_nascimento());
		pstm.setInt(7, pessoa.getCpf());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Pessoa salva com sucesso!");
	}
	
	private void remover(PreparedStatement pstm, Pessoa pessoa) throws SQLException {
		pstm.setInt(1, pessoa.getId());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Pessoa removida com sucesso!");
	}
	
	private void atualizar(PreparedStatement pstm, Pessoa pessoa) throws SQLException {
		pstm.setInt(1, pessoa.getId());
		pstm.setString(2, pessoa.getNome());
		pstm.setString(3, pessoa.getTelefone());
		pstm.setString(4, pessoa.getEmail());
		pstm.setString(5, pessoa.getEndereco());
		pstm.setDate(6, pessoa.getDt_nascimento());
		pstm.setInt(7, pessoa.getCpf());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Pessoa atualizada com sucesso!");
	}
	
	private void fecharConexao(Connection connection, PreparedStatement pstm) {
		try {
			if( connection != null ) connection.close();
			if( pstm != null ) pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
