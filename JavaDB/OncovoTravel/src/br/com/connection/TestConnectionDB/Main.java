package br.com.connection.TestConnectionDB;

import br.com.connectionDB.PessoaDAO;
import br.com.connectionDB.DestinoDAO;
import br.com.connectionDB.PassagemDAO;

public class Main {

	public static void main(String[] args) {
		PessoaDAO dao = new PessoaDAO();
		dao.listarPessoas();
		
		DestinoDAO dao1 = new DestinoDAO();
		dao1.listarDestino();
		
		PassagemDAO dao2 = new PassagemDAO();
		dao2.listarPassagens();
		
		
	}
}