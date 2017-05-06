/**
 * 
 */
package negocio.alumnos;

import integracion.alumnos.DAOAlumno;
import integracion.factoriaDAOs.FactoriaDAOs;

import java.util.ArrayList;

import negocio.Notificaciones;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAAlumnoImp implements SAAlumno {
	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#alta(TransferAlumno tAlumno)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int alta(TransferAlumno tAlumno) {
		// begin-user-code
		int resultado = Notificaciones.DATOS_ERRONEOS;
		DAOAlumno d = FactoriaDAOs.getInstancia().generarDAOAlumnos();
		if (!tAlumno.getDNIAlumno().equals("")) {
			TransferAlumno tRespuesta = d.leerPorDni(tAlumno.getDNIAlumno());
			if (tRespuesta != null) {
				if (!tRespuesta.getEstado()) {
					tRespuesta.setEstado(true);
					d.escribir(tRespuesta);
					resultado = Notificaciones.EXITO_ALTA_EXISTENTE;
				} else
					resultado = Notificaciones.ERROR_ALTA;
			} 
			else {
				if (datosCorrectos(tAlumno)) {/////////DAO
					String id = d.ultimoID();
					if (id.equals(""))
						tAlumno.setId(0);
					else {
						try {
							int x = Integer.parseInt(id);
							x++;
							tAlumno.setId(x);
						} catch (Exception e) {
						}
					}
					d.escribir(tAlumno);
					resultado = Notificaciones.EXITO_ALTA;
				} else
					resultado = Notificaciones.DATOS_ERRONEOS;
			}
		}
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#baja(TransferAlumno tAlumno)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int baja(TransferAlumno tAlumno) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int resultado;
		DAOAlumno d = FactoriaDAOs.getInstancia().generarDAOAlumnos();
		TransferAlumno tRespuesta = d.leer(Integer.toString(tAlumno.getId()));
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

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#modificar(TransferAlumno tAlumno)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificar(TransferAlumno tAlumno) {
		return 0;
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		/*int resultado;
		DAOAlumno d = FactoriaDAOs.getInstancia().generarDAOAlumnos();
		int id = tAlumno.getId();
		TransferAlumno tRespuesta = d.leer(Integer.toString(id));
		
		String DNI = tAlumno.getDNIAlumno();
		TransferAlumno tBaseDatos = null;
		if (DNI != null){
			tBaseDatos = d.leerPorDni(DNI);
		}
		if (tBaseDatos != null)
			return Notificaciones.DNI_EXISTENTE;
		if (tRespuesta != null) {			
			if (tAlumno.getNombreAlumno().equals("") && tAlumno.getCapacidad() == -1) {
				return Notificaciones.NO_MODIFICACION;
			}
			if (tAlumno.getNombreAlumno().equals("")) {
				tAlumno.setNombre(tRespuesta.getNombreAlumno());
			}
			if (tAlumno.getCapacidad() == -1) {
				tAlumno.setCapacidad(tRespuesta.getCapacidad());
			}
			if (tRespuesta.getEstado())
				tAlumno.setEstado(true);
			else
				tAlumno.setEstado(false);
			d.escribir(tAlumno);
			resultado = Notificaciones.MODIFICACION_CORRECTA;
		} else
			resultado = Notificaciones.DATOS_ERRONEOS;
		return resultado;*/
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see SAAlumno#listarAlumnos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList listarAlumnos() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return null;
		// end-user-code
	}

	//comprobar datos
	//NOTA RICARDO: CORREGIR
	private boolean datosCorrectos(TransferAlumno datos) {
		Boolean resultado = true;
		char[] Dni = new char[8];

		String dni = datos.getDNIAlumno();
		int digitos = contarDigitos(datos.getTelefono());
		String fecha = datos.getFecha();
		if (dni.length() > 9)
			resultado = false;
		else {
			for (int i = 0; i < 8; i++) {
				Dni[i] = dni.charAt(i);
				try {
					Integer.parseInt("" + Dni[i]);
				} catch (NumberFormatException e) {
					return false;
				}
			}
			if (digitos > 9 || digitos == 0)
				resultado = false;
			else {
				String[] f = fecha.split("/");
				for (int i = 0; i < 3; i++) {
					try {
						Integer.parseInt(f[i]);
					} catch (NumberFormatException e) {
						return false;
					}
				}
			}
		}

		return resultado;
	}

	private int contarDigitos(int telefono) {
		int resultado = 0;
		while (telefono != 0) {
			telefono = telefono / 10;
			resultado++;
		}
		return resultado;
	}

	@Override
	public ArrayList<TransferAlumno> mostrarAlumnosId() {
		ArrayList<TransferAlumno> alumnos = new ArrayList<TransferAlumno>();
		DAOAlumno d = FactoriaDAOs.getInstancia().generarDAOAlumnos();
		int nrAlumnos = 0;
		try {
			nrAlumnos = Integer.parseInt(d.ultimoID());
		} catch (Exception e) {
			return null;
		}
		int cont = 0;
		while (cont <= nrAlumnos) {
			TransferAlumno tRespuesta = d.leer(Integer.toString(cont));
			cont++;
			if (tRespuesta != null)
				//	if(tRespuesta.getEstado())
				alumnos.add(tRespuesta);
		}
		return alumnos;
	}
}