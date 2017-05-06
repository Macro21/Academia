/**
 * 
 */
package negocio.aulas;

import integracion.aulas.DAOAula;
import integracion.factoriaDAOs.FactoriaDAOs;

import java.util.ArrayList;

import negocio.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAAulaImp implements SAAula {

	/** 
	 * (sin Javadoc)
	 * @see SAAula#alta(TransferAula datos)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TransferAula datos) {
		// begin-user-code
		int resultado = Notificaciones.DATOS_ERRONEOS;
		DAOAula d = FactoriaDAOs.getInstancia().generarDAOAula();
		if (!datos.getNombreAula().equals("")) {
			String nombre = datos.getNombreAula();
			TransferAula tRespuesta = d.leerPorNombre(nombre);
			if (tRespuesta != null) {
				if (!tRespuesta.getEstado()) {
					tRespuesta.setEstado(true);
					d.escribir(tRespuesta);
					resultado = Notificaciones.EXITO_ALTA_EXISTENTE;
				} else
					resultado = Notificaciones.ERROR_ALTA;
			} else {
				if (datosCorrectos(datos)) {
					String id = d.ultimoID();
					if (id.equals(""))
						datos.setID(0);
					else {
						try {
							int x = Integer.parseInt(id);
							x++;
							datos.setID(x);
						} catch (Exception e) {
						}
					}
					d.escribir(datos);
					resultado = Notificaciones.EXITO_ALTA;
				} else
					resultado = Notificaciones.DATOS_ERRONEOS;
			}
		}
		return resultado;
		// end-user-code
	}

	private boolean datosCorrectos(TransferAula datos) {
		Boolean resultado = false;
		int x = datos.getCapacidad();
		if (x > 0)
			resultado = true;
		return resultado;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAula#modificar(TransferAula tAula)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificar(TransferAula tAula) {
		// begin-user-code
		int resultado;
		DAOAula d = FactoriaDAOs.getInstancia().generarDAOAula();
		int id = tAula.getId();
		TransferAula tRespuesta = d.leer(Integer.toString(id));
		
		String nombre = tAula.getNombreAula();
		TransferAula tBaseDatos = null;
		if (nombre != null){
			tBaseDatos = d.leerPorNombre(nombre);
		}
		if (tBaseDatos != null)
			return Notificaciones.NOMBRE_EXISTENTE;
		if (tRespuesta != null) {			
			if (tAula.getNombreAula().equals("") && tAula.getCapacidad() == -1) {
				return Notificaciones.NO_MODIFICACION;
			}
			if (tAula.getNombreAula().equals("")) {
				tAula.setNombre(tRespuesta.getNombreAula());
			}
			if (tAula.getCapacidad() == -1) {
				tAula.setCapacidad(tRespuesta.getCapacidad());
			}
			if (tRespuesta.getEstado())
				tAula.setEstado(true);
			else
				tAula.setEstado(false);
			d.escribir(tAula);
			resultado = Notificaciones.MODIFICACION_CORRECTA;
		} else
			resultado = Notificaciones.DATOS_ERRONEOS;
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAula#listarAulas(ArrayList list)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void listarAulas(ArrayList list) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAula#baja(TransferAula tAula)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int baja(TransferAula tAula) {
		// begin-user-code
		int resultado;
		DAOAula d = FactoriaDAOs.getInstancia().generarDAOAula();
		TransferAula tRespuesta = d.leer(Integer.toString(tAula.getId()));
		if (tRespuesta != null) {
			if (tRespuesta.getEstado()) {
				d.baja(tRespuesta);
				resultado = Notificaciones.BAJA_CORRECTA;
			} else
				resultado = Notificaciones.ERROR_BAJA;
		} else
			resultado = Notificaciones.DATOS_ERRONEOS;

		return resultado;
		// end-user-code
	}

	@Override
	public ArrayList<TransferAula> mostrarAulaId() {
		ArrayList<TransferAula> aulas = new ArrayList<TransferAula>();
		DAOAula d = FactoriaDAOs.getInstancia().generarDAOAula();
		int nrAulas = 0;
		try {
			nrAulas = Integer.parseInt(d.ultimoID());
		} catch (Exception e) {
			return null;
		}
		int cont = 0;
		while (cont <= nrAulas) {
			TransferAula tRespuesta = d.leer(Integer.toString(cont));
			cont++;
			if (tRespuesta != null)
				//	if(tRespuesta.getEstado())
				aulas.add(tRespuesta);
		}
		return aulas;
	}
}