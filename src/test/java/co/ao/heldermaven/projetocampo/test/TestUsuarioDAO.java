package co.ao.heldermaven.projetocampo.test;

import co.ao.heldermaven.projetocampo.entidade.Usuario;
import co.ao.heldermaven.projetocampo.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		//testAlterar();
		testExcluir();
	}
		
	public static void testCadastrar() {
		Usuario uso = new Usuario();
		
		uso.setNome("Helder");
		uso.setLogin("h123");
		uso.setSenha("123");
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		usoDAO.cadastrar(uso);
		
		System.out.println("Cadastrado com sucesso!");

	}
	public static void testAlterar() {
		Usuario uso = new Usuario();
		uso.setId(3);
		uso.setNome("Helder Costa");
		uso.setLogin("h123hg");
		uso.setSenha("123kj");
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		usoDAO.alterar(uso);
		
		System.out.println("Alterado com sucesso!");

	}
	public static void testExcluir() {
		Usuario uso = new Usuario();
		uso.setId(3);
			
		UsuarioDAO usoDAO = new UsuarioDAO();
		usoDAO.excluir(uso);
		
		System.out.println("Excluido com sucesso!");

	}
}
