package co.ao.heldermaven.projetocampo.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5433/servicocampo","postgres","postgres");
		} catch (SQLException e) {
			//relan;anco
			throw new RuntimeException(e);
		}
	}

}
