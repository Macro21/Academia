/**
 * 
 */
package negocio.factoriaSAaplicaciones;

import negocio.alumnos.SAAlumno;
import negocio.alumnos.SAAlumnoImp;
import negocio.profesores.SAProfesores;
import negocio.profesores.SAProfesoresImp;
import negocio.cursos.SACurso;
import negocio.cursos.SACursoImp;
import negocio.aulas.SAAula;
import negocio.aulas.SAAulaImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaSAplicacionesImp extends FactoriaSAplicaciones {

	/** 
	 * (sin Javadoc)
	 * @see FactoriaSAplicaciones#generarSAAlumnos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAAlumno generarSAAlumnos() {
		// begin-user-code
		return new SAAlumnoImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaSAplicaciones#generarSAProfesores()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAProfesores generarSAProfesores() {
		// begin-user-code
		return new SAProfesoresImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaSAplicaciones#generarSACursos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SACurso generarSACursos() {
		// begin-user-code
		return new SACursoImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaSAplicaciones#generarSAAulas()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAAula generarSAAulas() {
		// begin-user-code
		return new SAAulaImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaSAplicaciones#generarSAMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void generarSAMatricula() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}
}