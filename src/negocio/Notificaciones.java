package negocio;

public class Notificaciones {
	
	// Alta correcta. Sin problemas.
	public static final int EXITO_ALTA =0;
	//Alta correcta pero ya existente. No se cambian los datos, solo se activa
	public static final int EXITO_ALTA_EXISTENTE =1;
	//No se da de alta porque ya estaba dado de alta
	public static final int ERROR_ALTA = 2;
	//No se da de alta/baja porque los datos estan mal.
	public static final int DATOS_ERRONEOS = 3;
	//Se da de baja sin poblemas
	public static final int BAJA_CORRECTA = 4;
	//Ya estaba dado de baja
	public static final int ERROR_BAJA = 5;
	//Cuando se quiere modificar y no se introducen datos
	public static final int NO_MODIFICACION =6;
	//
	public static final int MODIFICACION_CORRECTA = 7;
	public static final int NOMBRE_EXISTENTE = 8;
	public static final int DNI_EXISTENTE = 9;
	
}
