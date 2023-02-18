package rf.com.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rf.com.dominio.Categoria;
import rf.com.exception.ControllerException;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;

@Service
public interface IServicioCategoria{
	public ResponseEntity insertRegistro(Categoria c)throws DAOException,DomainException ;
	public ResponseEntity updateRegistro(Categoria c)throws DAOException,DomainException;
	public ResponseEntity deleteById(int id)throws ControllerException;
	public ResponseEntity readAll()throws ControllerException;
	public ResponseEntity readOne(String id)throws ControllerException;
	

}