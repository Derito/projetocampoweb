package co.ao.heldermaven.projetocampo.test;

import java.util.List;

import co.ao.heldermaven.projetocampo.entidade.Usuario;
import co.ao.heldermaven.projetocampo.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		//testAlterar();
		//testExcluir();
		//testSalvar();
		//testBuscaPorId();
		testBuscaTodos();
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
	public static void testSalvar() {
		Usuario uso = new Usuario();
		uso.setId(7);
		uso.setNome("Manuel ftu");
		uso.setLogin("re3");
		uso.setSenha("1234");
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		usoDAO.salvar(uso);
		
		System.out.println("Salvo com sucesso!");
	}
	public static void testBuscaPorId() {
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		Usuario uso = usoDAO.buscaPorId(2);
		System.out.println(uso);
		
	}
	public static void testBuscaTodos() {
		
		UsuarioDAO usoDAO = new UsuarioDAO();
		List<Usuario> lista = usoDAO.buscaTodos();
		for(Usuario u: lista) {
					
		System.out.println(u);
		}
	}
}
