package co.ao.heldermaven.projetocampo.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

}
