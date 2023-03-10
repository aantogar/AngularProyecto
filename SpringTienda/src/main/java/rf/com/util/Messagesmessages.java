package rf.com.util;

/* *****************************************************
 * NOMBRE: Messagesmessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Febrero 2023
 *  
 *  @author 	Andrea Antón
 *  
 *  *****************************************************/
public class Messagesmessages extends Exception{
	
	
		
	/**
	 * Codigo de producto
	 */
	public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	public final static String PROERR_004 = "La longitud no cumple con la longitud mínima";
	public final static String PROERR_005 = "La longitud no cumple con la longitud máxima";
	
	/**
	 *Campo  de rango double 
	 */
	public static final String PROERR_006="Número decimar erróneo, no está en el rango";
	
	/**
	 * Comprobación de campo de fecha correcta
	 */
	public static final String PROERR_007="La fecha indicada no puede ser inferior.";
	public static final String PROERR_008="La fecha indicada no puede ser superior.";
	public static final String PROERR_009="Formato introducido incorrecto o no es una fecha válida";
	
	/**
	 * Campo de comprobación alfanumérica
	 */
	public static final String PROERR_010="Formato introducido incorrecto, debe de ser alfanumérico";
	/**
	 * Campo de formato erróneo y longitud
	 */
	public static final String PROERR_011="El formato o la  longitud introducida, son incorrectos";
	
	/**
	 * Campo de formato erróneo.
	 */
	public static final String PROERR_012="El formato introducido no es correcto";
	
	/**
	 * Campo de Error para dominio Categoria isValidinsert/isValidUpdate
	 */
	public static final String PROERR_013="ERROR. No se puede insertar";
	/**
	 * Campos de error para Dao
	 * 
	 */
	public static final String PROERR_014="ERROR. No se ha podido modificar el registro";
	public static final String PROERR_015="ERROR. No se ha podido recuperar ningún registro";
	public static final String PROERR_016="ERROR. No se ha podido guardar el registro";
	public static final String PROERR_017="ERROR. No se ha podido eliminar el registro";
	public static final String PROERR_018="ERROR. No se ha podido recuperar el registro";

	/**
	 * Campos de Error para Categoria Controller
	 */
	public static final String []PROERR_019={"ERROR 400: No existe registro solicitado."};
	public static final String[] PROERR_020={"ERROR 500: Error de formato."};
	public static final String[] PROERR_O21= {"STATUS 200: Registro eliminado"};
	public static final String[] PROERR_O22={"ERROR 400: Error en formato de registro"};
	public static final String PROERR_O23="STATUS 200: Acceso al registro.";
	public static final String PROERR_O24="STATUS 200: Acceso todos los registros.";
	public static final String[] PROERR_025={"STATUS 200: Registro actualizado"};
	public static final String[] PROERR_026={"ERROR 500: No se ha podido acutalizar el registro"};
	public static final String[] PROERR_027={"STATUS 200: Registro Guardado"};
	public static final String[] PROERR_028={"ERROR 500: No se ha podido guardar el registro"};
	public static final String[] PROERR_029={"ERROR 700: El nombre no cumple la longitud"};
	}