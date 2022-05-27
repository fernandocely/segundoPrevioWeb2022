package co.empresa.bbva.dao;

public class UsuarioDaoFactory {
	
	public static UsuarioDao getUsuarioDao(String type) {
		switch (type) {
			
		case "postgresql":
		return (UsuarioDao) new UsuarioDaoPostgreSQL();
		
		default:
			return (UsuarioDao) new UsuarioDaoPostgreSQL();
			
		}
	}

}

