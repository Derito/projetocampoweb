package co.ao.heldermaven.projetocampo.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.ao.heldermaven.projetocampo.entidade.Usuario;;
public class UsuarioDAO {
	
	private Connection con = FabricaConexao.getConnection();

	public void cadastrar(Usuario uso) {
		
		String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
		
		try(PreparedStatement prepara = con.prepareStatement(sql)){
		
		prepara.setString(1, uso.getNome());
		prepara.setString(2, uso.getLogin());
		prepara.setString(3, uso.getSenha());
		
		prepara.execute();
					
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
	}

	public void alterar(Usuario uso) {
		
	String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		try(PreparedStatement prepara = con.prepareStatement(sql)){
		
		prepara.setString(1, uso.getNome());
		prepara.setString(2, uso.getLogin());
		prepara.setString(3, uso.getSenha());
		prepara.setInt(4, uso.getId());
		
		prepara.execute();
					
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
	}

	public void excluir(Usuario uso) {
		
		String sql = "delete from usuario where id=?";
		
		try(PreparedStatement prepara = con.prepareStatement(sql)){
	
		prepara.setInt(1, uso.getId());
		
		prepara.execute();
					
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	public void salvar(Usuario uso) {
		if(uso.getId() != null) {
			alterar(uso);
		}else {
		cadastrar(uso);
		}
	}
	/**
	 * O metodo faz a busca de um registo no BD pelo id
	 * @param id é um inteiro que representa o numero do id do usuario a ser buscado
	 * @return Ele retorna um objecto usuario quando encontra e nulo quando não encontra
	 */
	public Usuario buscaPorId(Integer id) {
		
		String sql = "select * from usuario where id=?";
		
		try(PreparedStatement prepara = con.prepareStatement(sql)){
	
			prepara.setInt(1, id);
		//EXECUTEQUERY RETORNA RESULTSET
			ResultSet resultado = prepara.executeQuery();
			//posiciona o cursor no 1 registo
			if(resultado.next()) {
				Usuario uso = new Usuario();
				uso.setId(resultado.getInt("id"));
				uso.setNome(resultado.getString("nome"));
				uso.setLogin(resultado.getString("login"));
				uso.setSenha(resultado.getString("senha"));
				
				return uso;
			}
								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * O metodo faz a busca de todos os registos no BD
	 * @param  usuario a ser buscado
	 * @return Ele retorna uma lista de objectos usuarios contendo 0 quando não encontra ou n elementos quando encontra
	 */
	public List<Usuario> buscaTodos() {
		
		String sql = "select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		try(PreparedStatement prepara = con.prepareStatement(sql)){
	
			//EXECUTEQUERY RETORNA RESULTSET
			ResultSet resultado = prepara.executeQuery();
			//posiciona o cursor no 1 registo
			while(resultado.next()) {
				Usuario uso = new Usuario();
				uso.setId(resultado.getInt("id"));
				uso.setNome(resultado.getString("nome"));
				uso.setLogin(resultado.getString("login"));
				uso.setSenha(resultado.getString("senha"));
				//adicionando na lista
				lista.add(uso);
			}
								
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return lista;
	}

}
