package br.com.sigcar.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Correcao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private /*@ spec_public*/ int id;
	
	private /*@ spec_public*/ String texto;

	public /*@ pure*/int getId() {
		return id;
	}
	/*@ requires id > 0;
	  @ assignable this.id;
	  @ ensures this.id == id;
	 @*/
	public void setId(int id) {
		this.id = id;
	}

	public /*@ pure*/ String getTexto() {
		return texto;
	}
	/*@ requires texto != "";
	  @ assignable this.texto;
	  @ ensures this.texto.equals(texto); 
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
