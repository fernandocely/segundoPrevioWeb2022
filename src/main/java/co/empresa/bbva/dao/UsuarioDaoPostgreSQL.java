package co.empresa.bbva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.empresa.bbva.modelo.Movimientos;
import co.empresa.bbva.modelo.Usuario;

import co.empresa.bbva.util.ConexionPostgreSQL;

public class UsuarioDaoPostgreSQL implements UsuarioDao {
	
	private ConexionPostgreSQL conexion;
	private static final String INSERT_USUARIO_SQL = "INSERT INTO user (username, pass, email) VALUES (?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM user WHERE id = ?;";
	private static final String UPDATE_USUARIO_SQL = "UPDATE user SET username=?, pass=?, email=? WHERE id=?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM user WHERE id=?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM user;";

	public UsuarioDaoPostgreSQL() {
		this.conexion =  ConexionPostgreSQL.getConexion();
	
	}
	public void insert(Usuario usuario) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getUsername());
			preparedStatement.setString(2, usuario.getPass());
			preparedStatement.setString(3, usuario.getEmail());
			conexion.execute();
		}catch(SQLException e) {
			
		}
		
	}
	
	public void delete(int id) throws SQLException {
		try {
		PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(DELETE_USUARIO_SQL);
		preparedStatement.setInt(1, id);
		conexion.execute();
		}catch(SQLException e){
			
		}
	}
	
	public void update(Usuario usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement =(PreparedStatement)conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setString(1, usuario.getUsername());
			preparedStatement.setString(2, usuario.getPass());
			preparedStatement.setString(3, usuario.getEmail());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
		}catch(SQLException e) {
			
		}
		
	}
	
	//FALTA MODIFICAR ----------
	public List<Usuario> selectAll(){
		List <Usuario> usuarios = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			ResultSet rs = conexion.query();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				usuarios.add(new Usuario(id, nombre, email, pais));
				
			}
		}catch(SQLException e) {
			
		}
		
		return usuarios;
		
	}
	
	public Usuario select(int id){
		Usuario usuario = null;
		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()){
				
				String nombre = rs.getString("nombre");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				usuario = new Usuario(id, nombre, pass, email);
				
			}
		}catch(SQLException e) {
			
		}
		
		return usuario;
		
	}

}