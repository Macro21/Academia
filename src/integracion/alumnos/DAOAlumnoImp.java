/**
 * 
 */
package integracion.alumnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import negocio.alumnos.TransferAlumno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOAlumnoImp implements DAOAlumno {

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private String contador = "contador.txt";
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Scanner scanner;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private File file;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private FileWriter fileWriter;

	public DAOAlumnoImp() {
		scanner = null;
		fileWriter = null;
		file = null;
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOAlumno#leer(String id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferAlumno leer(String id) {
		// begin-user-code

		TransferAlumno resultado = null;
		Boolean est = false;
		this.file = new File("Alumnos" + "\\" + id + ".txt");
		String nombre = null;
		String apellido1 = null;
		String apellido2 = null;
		String DNI = null;
		String domicilio = null;
		String fechaNacimiento = null;
		int telefono = -1;
		String estado = null;
		if (this.file.exists()) {
			try {
				this.scanner = new Scanner(this.file);
				DNI = this.scanner.nextLine();
				if (!id.equals("contador")) {//??
					nombre = this.scanner.nextLine();
					apellido1 = this.scanner.nextLine();
					apellido2 = this.scanner.nextLine();
					domicilio = this.scanner.nextLine();
					fechaNacimiento = this.scanner.nextLine();
					telefono = Integer.parseInt(this.scanner.nextLine());
					estado = this.scanner.nextLine();
					if (estado.equals("activo"))
						est = true;
				} else {
					id = DNI;
					DNI = null;
				}
				resultado = new TransferAlumno(nombre, apellido1, apellido2,
						DNI, domicilio, fechaNacimiento, telefono,
						Integer.parseInt(id), est);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOAlumno#escribir(TransferAlumno tAlumno)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void escribir(TransferAlumno tAlumno) {
		// begin-user-code
		String nombArch = tAlumno.getId() + ".txt";
		String nombDir = "Alumnos";
		TransferAlumno tRespuesta = leer("contador");

		try {
			this.file = new File(nombArch);
			File dir = new File(nombDir);
			File f = new File(dir + "\\" + contador);
			if (!dir.exists()) {
				dir.mkdir();
				this.fileWriter = new FileWriter(dir + "\\" + contador);
				this.fileWriter.write("0");
				this.fileWriter.close();
			} else if (!f.exists()) {
				this.fileWriter = new FileWriter(dir + "\\" + contador);
				this.fileWriter.write("0");
				this.fileWriter.close();
			} else if (tRespuesta.getId() < tAlumno.getId()) {
				this.fileWriter = new FileWriter(dir + "\\" + contador);
				this.fileWriter.write(Integer.toString(tAlumno.getId()));
				this.fileWriter.close();
			}
			this.fileWriter = new FileWriter(dir + "\\" + this.file);
			this.fileWriter.write(tAlumno.getDNIAlumno()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getNombreAlumno()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getApellido1()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getApellido2()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getDomicilio()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getFecha()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getTelefono()
					+ System.getProperty("line.separator"));
			if (tAlumno.getEstado())
				this.fileWriter.write("activo"
						+ System.getProperty("line.separator"));
			else
				this.fileWriter.write("inactivo"
						+ System.getProperty("line.separator"));

			this.fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOAlumno#leerPorDni(String dni)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferAlumno leerPorDni(String dni) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int cont = 0;
		TransferAlumno resultado = null;
		String nombDir = "Alumnos";
		try {
			file = new File(nombDir + "\\" + contador);
			boolean existe = this.file.exists();
			boolean encontrado = false;
			if (existe) { //Si existe el archivo contador leo, sino devuelvo null
				while(cont <= Integer.parseInt(ultimoID()) && !encontrado){
					file = new File(nombDir + "\\" + Integer.toString(cont)
							+ ".txt");
					this.scanner = new Scanner(file);
					String DNI = this.scanner.findInLine(dni);
					if (DNI != null) {
						try {
							Boolean est = false;
							String nombre = this.scanner.nextLine();
							String ap1 = this.scanner.nextLine();
							String ap2 = this.scanner.nextLine();
							String domicilio = this.scanner.nextLine();
							String fecha = this.scanner.nextLine();
							int telefono = Integer
									.parseInt(this.scanner.nextLine());
							String estado = this.scanner.nextLine();
							if (estado.equals("activo")) {
								est = true;
							}
							resultado = new TransferAlumno(nombre, ap1, ap2, DNI,
									domicilio, fecha, telefono, cont, est);
						} catch (Exception e) {}
						encontrado = true;
					} else
						cont++;
				}
			}
		} catch (Exception e) {
		}
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOAlumno#ultimoID()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public String ultimoID() {
		// begin-user-code
		String resultado = "";
		this.file = new File("Alumnos" + "\\" + contador);
		if (file.exists()) {
			try {
				this.scanner = new Scanner(this.file);
				resultado = this.scanner.nextLine();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return resultado;
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see DAOAlumno#baja(TransferAlumno tAlumno)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void baja(TransferAlumno tAlumno) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.file = new File("Alumnos" + "\\" + tAlumno.getId() + ".txt");
		try {
			this.fileWriter = new FileWriter(this.file);
			this.fileWriter.write(tAlumno.getDNIAlumno()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getNombreAlumno()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getApellido1()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getApellido2()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getDomicilio()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getFecha()
					+ System.getProperty("line.separator"));
			this.fileWriter.write(tAlumno.getTelefono()
					+ System.getProperty("line.separator"));

			this.fileWriter.write("inactivo"
					+ System.getProperty("line.separator"));
			this.fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// end-user-code
	}

}