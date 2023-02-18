package rf.com.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;


@CrossOrigin
@ControllerAdvice
public class ControllerExceptionHadler {

	String MI_RUTA = "rf.com";
	int MI_RUTA_LENGTH = MI_RUTA.length();

	@ExceptionHandler(value = { DomainException.class, DAOException.class, ControllerException.class,
			IllegalArgumentException.class, IllegalStateException.class,
			org.springframework.dao.DuplicateKeyException.class,
			org.springframework.web.HttpRequestMethodNotSupportedException.class,
			org.springframework.web.bind.MethodArgumentNotValidException.class,
			org.springframework.web.bind.MissingRequestHeaderException.class,
			org.springframework.web.bind.MissingServletRequestParameterException.class,
			org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
			org.springframework.http.converter.HttpMessageNotReadableException.class })
	@ResponseBody
	public Map<String, Object> handleConflict(Exception ex) {
		String mensaje = ex.getClass().getSimpleName() + "-" + ex.getMessage();
		System.out.println(mensaje);
		return montaError(ex, mensaje, HttpStatus.BAD_REQUEST);
	}


	private Map<String, Object> montaError(Exception ex, String mensaje, HttpStatus conflict) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String miPaquete = this.getClass().getPackageName();
		System.out.println(miPaquete);
		/* *************************************************************************
		 * obtener paquete base de spring.....
		 */
		map.clear();
		map.put("status", 0);
		map.put("message", mensaje);
		// getStackTrace se deberia filtrar por "className": "es.rf.tienda.
		// Array de objetos
		StackTraceElement[] ste = ex.getStackTrace();
		StackTraceElement[] stack = Arrays.stream(ste)
				.peek(s->System.out.println(s.getClassName()))
				.filter(s ->  s.getClassName().length() < MI_RUTA_LENGTH ? false :  s.getClassName().substring(0, MI_RUTA_LENGTH).equals(MI_RUTA))
				.toArray(StackTraceElement[]::new);
		map.put("stacktrace", stack);
		return map;
	}
}
