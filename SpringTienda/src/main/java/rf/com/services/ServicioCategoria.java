package rf.com.services;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rf.com.dominio.Categoria;
import rf.com.exception.ControllerException;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.repository.ICategoriaRepo;
import rf.com.util.Messagesmessages;
import rf.com.util.Validator;


@Service
public class ServicioCategoria  implements IServicioCategoria{
	
	
	@Autowired 
	private ICategoriaRepo cDao;
	
	/**
	 * Método que comprueba si el id
	 * es valido y guarda el registro.
	 * @throws DomainException 
	 */
	@Override
	public ResponseEntity insertRegistro(Categoria c) throws  DAOException,DomainException {
		String resp="";
		Map<String,Object>map=new LinkedHashMap<String,Object>();
		try { 
			if(c.isValidInsert() ) {
				Categoria result=cDao.save(c);
				map.put("status", 200);
				map.put("data", result);
				return new ResponseEntity<>(map,HttpStatus.OK);
			}else{
				resp="Registro inválido";
				return new ResponseEntity<>(c,HttpStatus.BAD_REQUEST);}
		}catch(NumberFormatException e ) {
				resp="Error en el formato";}
		throw new DAOException(resp);
		
	}	
	/**
	 * Método que comprueba si el id
	 * es valido y guarda el registro.
	 * @throws DAOException 
	 * @throws DomainException 
	 */
	
	@Override
	public ResponseEntity updateRegistro(Categoria c) throws DAOException, DomainException  {
		String resp="";
		Map<String,Object>map=new LinkedHashMap<String,Object>();
		try{
			if(c.isValidUpdate()) { 
				if(cDao.existsById(c.getId_categoria())) { 
					cDao.save(c);
					map.put("status", 200);
					map.put("data", c);
					return new ResponseEntity<>(map,HttpStatus.OK);}
			}else {
				resp="No se encuentra el registro a actualizar";
				return new ResponseEntity<>(c,HttpStatus.NOT_FOUND);}
		}catch(DomainException e) {
			resp="El formato es incorrecto";
		}catch(NoSuchElementException e){
			resp="No se encuentra el elemento";}
		throw new DAOException(resp);
	}
	
	/**
	 * Método que borra el registro por id.
	 * @throws ControllerException 
	 */
	@Override
	public ResponseEntity deleteById(int id) throws ControllerException {
		String resp="";
		Map<String,Object>map=new LinkedHashMap<String,Object>();
			try {
				if(cDao.existsById(id)) {
					cDao.deleteById(id);
					map.put("status", 200);
					map.put("delete", id);
					 return new ResponseEntity<>(map,HttpStatus.OK);
				}else {
					resp="No existe el registro";}	
			}catch (NoSuchElementException e) {	
				resp="Error, no se encuentra";
			}catch(NumberFormatException e) {
				resp="Error en el formato";}
			throw new ControllerException(resp);
	}
	
	/**
	 * Método que lee todos los registros
	 */
	@Override
	public ResponseEntity readAll() throws ControllerException {
		String resp="";
		Map<String,Object>map=new LinkedHashMap<String,Object>();
		List<Categoria>repo=cDao.findAll();
			if(!repo.isEmpty()){
				map.put("status", 200);
				map.put("data", repo);
				return new ResponseEntity<>(map,HttpStatus.OK);
			}else {
				resp="No existen datos";
				throw new ControllerException(resp);
			}			
				
	}
	
	/**
	 * Método que lee un registro
	 * @throws ControllerException 
	 */
	@Override
	public ResponseEntity readOne(String id) throws ControllerException {
		String resp="";
		Map<String,Object>map=new LinkedHashMap<String,Object>();
		if(id!=null) {
			try {
				int idconver=Integer.parseInt(id);
				Categoria result=cDao.findById(idconver).get();
				if(result!=null) {
					map.put("status", 200);
					map.put("data", result);
					 return new ResponseEntity<>(map,HttpStatus.OK);
				}else {
					resp="No hay datos";}
			}catch(NoSuchElementException e) {
				resp="No se encuentra el elemento";
			}catch(NumberFormatException e) {
				resp="Error en el formato";
			}}		
		throw new ControllerException(resp);
	}
}