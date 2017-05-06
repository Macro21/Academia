/**
 * 
 */
package presentacion.controlador;

import java.util.ArrayList;

import negocio.Notificaciones;
import negocio.alumnos.SAAlumno;
import negocio.alumnos.TransferAlumno;
import negocio.aulas.SAAula;
import negocio.aulas.TransferAula;
import negocio.factoriaSAaplicaciones.FactoriaSAplicaciones;
import presentacion.alumnos.vistasAlumno.VistasAlumno;
import presentacion.aulas.vistasAula.VistasAula;
import presentacion.vistas.vistaPrincipal.VistaPrincipal;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorImp extends Controlador {

	/** 
	 * (sin Javadoc)
	 * @see Controlador#accion(int evento, Object datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accion(int evento, Object datos) {
		// begin-user-code

		if (EventoNegocio.ACTUALIZAR_VISTA_PRINCIPAL == evento) {
			VistaPrincipal.getInstance().ventanaPpal();
		}
		moduloAulas(evento, (TransferAula) datos);
		//moduloAlumnos(evento, (TransferAlumno) datos);
		// end-user-code
	}

	private void moduloAlumnos(int evento, TransferAlumno datos) {
		SAAlumno alumnos = FactoriaSAplicaciones.getInstance()
				.generarSAAlumnos();
		int x = -1;
		switch (evento) {
		case EventoNegocio.ALTA_ALUMNO: {
			x = alumnos.alta(datos);
			VistasAlumno.getInstance().actualizar(comprobarNotificacionesAlta(x));
		}
			break;
		case EventoNegocio.BAJA_ALUMNO: {
			x = alumnos.baja(datos);
			VistasAula.getInstance().actualizar(comprobarNotificacionesBaja(x));
		}
			break;
		case EventoNegocio.MODIFICAR_ALUMNO: {
			x = alumnos.modificar(datos);
			VistasAlumno.getInstance().actualizar(comprobarNotificacionesModificar(x));
		}
			break;
		case EventoNegocio.ACTUALIZAR_VISTA_ALUMNOS: {
			VistasAlumno.getInstance().ventana();
		}
			break;
		case EventoNegocio.MOSTRAR_ALUMNOS: {
			ArrayList<TransferAlumno> list = alumnos.mostrarAlumnosId();
			VistasAlumno.getInstance().mostrarAlumnoId(list);
		}
			break;
		}
	}

	private void moduloAulas(int evento, TransferAula datos) {

		SAAula aulas = FactoriaSAplicaciones.getInstance().generarSAAulas();
		int x = -1;
		switch (evento) {
		case EventoNegocio.ALTA_AULA: {
			x = aulas.alta(datos);
			VistasAula.getInstance().actualizar(comprobarNotificacionesAlta(x)); //Pasarle aula para concretar mensajes
		}
			break;
		case EventoNegocio.BAJA_AULA: {
			x = aulas.baja(datos);
			VistasAula.getInstance().actualizar(comprobarNotificacionesBaja(x));
		}
			break;
		case EventoNegocio.MODIFICAR_AULA: {
			x = aulas.modificar(datos);
			VistasAula.getInstance().actualizar(comprobarNotificacionesModificar(x));
		}
			break;
		case EventoNegocio.MOSTRAR_AULAS: {
			ArrayList<TransferAula> list = aulas.mostrarAulaId();
			VistasAula.getInstance().mostrarAulaId(list);
		}
			break;
		case EventoNegocio.ACTUALIZAR_VISTA_AULAS: {
			VistaPrincipal.getInstance().addPanelCentral(VistasAula.getInstance().getPanelAula());
		}
			break;
		}
	}

	private String comprobarNotificacionesModificar(int x) {
		String msg = null;
		switch (x) {
		case Notificaciones.MODIFICACION_CORRECTA: {
			msg = "Éxito al modificar.";
		}
			break;
		case Notificaciones.NO_MODIFICACION: {
			msg = "Error. No has introducido datos nuevos.";
		}
			break;
		case Notificaciones.DATOS_ERRONEOS: {
			msg = "Error. Los datos introducidos son incorrectos.";
		}
			break;
		case Notificaciones.NOMBRE_EXISTENTE: {
			msg = "Error. El nombre introducido ya existía en la base de datos.";
		}
			break;
		case Notificaciones.DNI_EXISTENTE: {
			msg = "Error. El DNI introducido ya existía en la base de datos.";
		}
			break;
		}
		return msg;
	}

	private String comprobarNotificacionesBaja(int x) {
		String msg = null;
		switch (x) {
		case Notificaciones.BAJA_CORRECTA: {
			msg = "Éxito al dar de baja.";
		}
			break;
		case Notificaciones.ERROR_BAJA: {
			msg = "Error. Ya se encontraba dado de baja.";
		}
			break;
		case Notificaciones.DATOS_ERRONEOS: {
			msg = "Error. Los datos introducidos son incorrectos.";
		}
			break;
		}
		return msg;
	}

	private String comprobarNotificacionesAlta(int x) {
		String msg = null;
		switch (x) {
		case Notificaciones.EXITO_ALTA: {
			msg = "Éxito al dar de alta.";
		}
			break;
		case Notificaciones.EXITO_ALTA_EXISTENTE: {
			msg = "Éxito al dar de alta."
					+ "\n"
					+ "ATENCION ya existia en la base de datos."
					+ "Se ha dado de alta pero no se han alterado los datos.  \n"
					+ "Para modificar las caracteristicas utilice la funcion de modificar.";
		}
			break;
		case Notificaciones.ERROR_ALTA: {
			msg = "Error. Ya se encuentra activo en la base de datos.";
		}
			break;
		case Notificaciones.DATOS_ERRONEOS: {
			msg = "Error. Los datos introducidos son incorrectos.";
		}
			break;
		}
		return msg;
	}

}