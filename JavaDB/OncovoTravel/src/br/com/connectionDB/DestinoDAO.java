package br.com.connectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.connectionDB.model.Destino;

public class DestinoDAO {

	public void listarDestino() {
		String sql = "SELECT * FROM DESTINO";
		
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
	
	public void salvaDestino(Destino destino) {
		String sql = "INSERT INTO DESTINO VALUES(?, ?)";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    inserir(pstm, destino);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void removeDestino(Destino destino) {
		String sql = "DELETE FROM DESTINO WHERE ID_DESTINO = ?";
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    remover(pstm, destino);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	public void alterarDestino(Destino destino) {
		String sql = "UPDATE DESTINO SET CIDADE_DESTINO = ?, ESTADO_DESTINO = ? WHERE ID_DESTINO = ?";
		Connection connection = null; 
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnection();
		    pstm = connection.prepareStatement(sql);
		    
		    atualizar(pstm, destino);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
				fecharConexao(connection, pstm);
		}
	}
	
	private void listar(ResultSet result) throws SQLException{
		while(result.next()) { 
			System.out.println(String.format("id %s", result.getInt("ID_DESTINO"))); 
			System.out.println(String.format("cidade %s", result.getString("CIDADE_DESTINO")));
			System.out.println(String.format("destino %s", result.getString("ESTADO_DESTINO")) + "\n");
		}
	}
	
	private void inserir(PreparedStatement pstm, Destino destino) throws SQLException {
		pstm.setInt(1, destino.getId());
		pstm.setString(2, destino.getCidade());
		pstm.setString(3, destino.getEstado());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Destino salvo com sucesso!");
	}
	
	private void remover(PreparedStatement pstm, Destino destino) throws SQLException {
		pstm.setInt(1, destino.getId());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Destino removido com sucesso!");
	}
	
	private void atualizar(PreparedStatement pstm, Destino destino) throws SQLException {
		pstm.setInt(1, destino.getId());
		pstm.setString(2, destino.getCidade());
		pstm.setString(3, destino.getEstado());
		boolean deuErro = pstm.execute();
		if(!deuErro) System.out.println("Destino atualizado com sucesso!");
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