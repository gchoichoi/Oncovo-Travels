package br.com.connectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.connectionDB.model.Passagem;

public class PassagemDAO {

	public void listarPassagens() {
		String sql = "SELECT * FROM PASSAGEM";
		
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
	
	public void salvaPassagem(Passagem passagem) {
		String sql = "INSERT INTO PASSAGEM VALUES(?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    inserir(pstm, passagem);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void removePassagem(Passagem passagem) {
		String sql = "DELETE FROM PASSAGEM WHERE ID_DESTINO = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    remover(pstm, passagem);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void alterarPassagem(Passagem passagem) {
		String sql = "UPDATE PASSAGEM SET DATA_IDA = ?, DATA_VOLTA = ?, VALOR_PASSAGEM = ? WHERE ID_DESTINO = ?";
		Connection connection = null; 
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    atualizar(pstm, passagem);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	private void listar(ResultSet result) throws SQLException{
		while(result.next()) { 
			System.out.println(String.format("id %s", result.getInt("ID_PASSAGEM"))); 
			System.out.println(String.format("data_ida %s", result.getDate("DATA_IDA")));
			System.out.println(String.format("data_volta %s", result.getDate("DATA_VOLTA")));
			System.out.println(String.format("valor_passagem %s", result.getDouble("VALOR_PASSAGEM")));
			System.out.println(String.format("id_pessoa %s", result.getInt("ID_PESSOA"))); 
			System.out.println(String.format("id_destino %s", result.getInt("ID_DESTINO")) + "\n"); 
		}
	}
	
	private void inserir(PreparedStatement pstm, Passagem passagem) throws SQLException {
		pstm.setInt(1, passagem.getId());
		pstm.setDate(2, passagem.getData_ida());
		pstm.setDate(3, passagem.getData_volta());
		pstm.setDouble(4, passagem.getValor_passagem());
		pstm.setInt(5, passagem.getId_pessoa());
		pstm.setInt(3, passagem.getId_destino());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Passagem salva com sucesso!");
	}
	
	private void remover(PreparedStatement pstm, Passagem passagem) throws SQLException {
		pstm.setInt(1, passagem.getId());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Passagem removida com sucesso!");
	}
	
	private void atualizar(PreparedStatement pstm, Passagem passagem) throws SQLException {
		pstm.setInt(1, passagem.getId());
		pstm.setDate(2, passagem.getData_ida());
		pstm.setDate(3, passagem.getData_volta());
		pstm.setDouble(4, passagem.getValor_passagem());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Passagem atualizada com sucesso!");
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