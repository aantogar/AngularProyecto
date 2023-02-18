package rf.com.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Transient;
import rf.com.exception.DomainException;


public interface Auxiliar {
	/**
	 * 
	 * Interfaz auxiliar para implementar en los Dominios
	 * @throws NoDataFoundException 
	 */
	
	@Transient
	@JsonIgnore
	public boolean isValidInsert() throws DomainException;
	
	@Transient
	@JsonIgnore
	public boolean isValidUpdate() throws DomainException;
	

}
