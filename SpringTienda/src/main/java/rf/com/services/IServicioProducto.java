package rf.com.services;

import org.springframework.stereotype.Service;
import rf.com.dominio.Categoria;
import rf.com.dominio.Producto;
import rf.com.exception.DomainException;


@Service
public interface IServicioProducto {
		public String[] insertRegistro(Producto p)throws DomainException;
		public String[] updateRegistro(Producto p)throws DomainException;
		public String[] deleteById(String id);
		public String[] readAll();
		public String[] readOne(String id);

}
