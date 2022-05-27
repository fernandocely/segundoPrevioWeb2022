package co.empresa.bbva.modelo;

import java.io.Serializable;

import co.empresa.bbva.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //metodos get y set
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor completo

public class Usuario implements Serializable{

	private Integer id;
	private String username;
	private String pass;
	private String email;
	
	public Usuario(String username, String pass, String email) {
		this.username = username;
		this.pass = pass;
		this.email = email;
		
	}
	
}
