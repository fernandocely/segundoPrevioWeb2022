package co.empresa.bbva.modelo;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data //metodos get y set
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor completort java.io.Serializable;

public class Movimientos implements Serializable{

	private Integer id;
	private Date date_bill;
	private Integer user_id;
	private Integer value;
	private Integer type;
	private String observation;
	
	public Movimientos(Date date_bill, Integer user_id, Integer value, Integer type, String observation) {
		this.date_bill = date_bill;
		this.user_id = user_id;
		this.value = value;
		this.type = type;
		this.observation = observation;
		
	}
}
