/**
 * 
 */
package integracion.factoriaDAOs;

import integracion.alumnos.DAOAlumno;
import integracion.alumnos.DAOAlumnoImp;
import integracion.cursos.DAOCurso;
import integracion.cursos.DAOCursoImp;
import integracion.profesores.DAOProfesores;
import integracion.profesores.DAOProfesoresImp;
import integracion.aulas.DAOAula;
import integracion.aulas.DAOAulaImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOsImp extends FactoriaDAOs {

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAOs#generarDAOAula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public DAOAula generarDAOAula() {
		// begin-user-code
		return new DAOAulaImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAOs#generarDAOAlumnos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public DAOAlumno generarDAOAlumnos() {
		// begin-user-code
		return new DAOAlumnoImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAOs#generarDAOCursos()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public DAOCurso generarDAOCursos() {
		// begin-user-code
		return new DAOCursoImp();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAOs#generarDAOMatricula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public void generarDAOMatricula() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see FactoriaDAOs#generarDAOProfesores()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public DAOProfesores generarDAOProfesores() {
		// begin-user-code
		return new DAOProfesoresImp();
		// end-user-code
	}
}