

package rf.com.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.Resource;
import rf.com.dominio.Categoria;
import rf.com.exception.ControllerException;
import rf.com.exception.DAOException;
import rf.com.exception.DomainException;
import rf.com.repository.ICategoriaRepo;
import rf.com.services.IServicioCategoria;
import rf.com.util.Messagesmessages;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/categorias")
public class CategoriaController {
	private final IServicioCategoria serviceC;

	@Autowired 
	 public CategoriaController( IServicioCategoria serviceC) {
        this.serviceC = serviceC;
    }
	@GetMapping("/{id}")
	public ResponseEntity leerUno(@PathVariable("id")String id)throws ControllerException  {
		return serviceC.readOne(id);
	}
	
	@GetMapping()
	public ResponseEntity leerTodos()throws DAOException, ControllerException {
		return serviceC.readAll();
	}
	
	@PutMapping
	public ResponseEntity updateCategoria(@RequestBody Categoria category) throws DAOException,DomainException {
		return serviceC.updateRegistro(category);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity borrarCategoria(@PathVariable("id") int id) throws ControllerException{
		return serviceC.deleteById(id);
	}	
	
	
	@PostMapping
	public ResponseEntity insertarRegistro( @RequestBody  Categoria c) throws DAOException,DomainException{
		return serviceC.insertRegistro(c);
	}

		
	
	
}
