package main;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Main {

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param args
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void main(String[] args) {
		// begin-user-code
		Controlador.getInstance().accion(
				EventoNegocio.ACTUALIZAR_VISTA_PRINCIPAL, null);
		// end-user-code
	}

}
