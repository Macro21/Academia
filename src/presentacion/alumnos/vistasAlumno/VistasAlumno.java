/**
 * 
 */
package presentacion.alumnos.vistasAlumno;

import java.util.ArrayList;

import javax.swing.JPanel;

import negocio.alumnos.TransferAlumno;
import negocio.aulas.TransferAula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class VistasAlumno {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static VistasAlumno vistasAlumno;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static VistasAlumno getInstance() {
		// begin-user-code
		if (vistasAlumno == null)
			vistasAlumno = new VistaAlumnoImp();
		return vistasAlumno;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param msg
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void actualizar(String msg);

	public abstract void mostrarAlumnoId(ArrayList<TransferAlumno> list);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void ventana();
	//public abstract JPanel getPanelAlumno();
}