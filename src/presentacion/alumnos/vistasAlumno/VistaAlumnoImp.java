/**
 * 
 */
package presentacion.alumnos.vistasAlumno;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.alumnos.TransferAlumno;
import presentacion.alumnos.alta.ActionListenerAltaAlumno;
import presentacion.alumnos.alta.JFrameAltaAlumno;
import presentacion.alumnos.baja.ActionListenerBajaAlumno;
import presentacion.alumnos.baja.JFrameBajaAlumno;
import presentacion.alumnos.listarAlumnos.ActionListenerListarAlumnos;
import presentacion.alumnos.listarAlumnos.JFrameListarAlumnos;
import presentacion.alumnos.modificar.ActionListenerModificarAlumno;
import presentacion.alumnos.modificar.JFrameModificarAlumno;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaAlumnoImp extends VistasAlumno {

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Object panelPpal;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JFrameAltaAlumno jFrameAltaAlumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JFrameBajaAlumno jFrameBajaAlumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JFrameModificarAlumno jFrameModificarAlumno;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JFrameListarAlumnos jFrameListarAlumnos;

	private JFrame frameAlumnos;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaAlumnoImp() {
		// begin-user-code
		initGUI();
		ventana();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see VistasAlumno#ventana()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void ventana() {
		// begin-user-code
		this.frameAlumnos.setTitle("Menu Alumnos");
		this.frameAlumnos.setSize(300, 300);
		this.frameAlumnos.setVisible(true);
		this.frameAlumnos.setLocation(500, 200);
		this.frameAlumnos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUI() {
		// begin-user-code
		this.frameAlumnos = new JFrame();
		this.frameAlumnos.setLayout(new GridLayout(3, 2));

		JButton alta = new JButton("Alta Alumno");
		JButton baja = new JButton("Baja Alumno");
		JButton modificar = new JButton("Modificar Alumno");
		JButton mostrarAlumnos = new JButton("Mostrar Alumno");
		JButton volver = new JButton("Volver");

		this.frameAlumnos.add(alta);
		this.frameAlumnos.add(baja);
		this.frameAlumnos.add(modificar);
		this.frameAlumnos.add(mostrarAlumnos);
		this.frameAlumnos.add(volver);

		actionListener(alta, baja, modificar, mostrarAlumnos, volver);
		ventana();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see VistasAlumno#actualizar(String msg)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizar(String msg) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		JOptionPane.showMessageDialog(this.frameAlumnos, msg);
		// end-user-code
	}

	private void actionListener(JButton alta, JButton baja, JButton modificar,
			JButton listarAlumnos, JButton volver) {

		alta.addActionListener(new ActionListenerAltaAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VistaAlumnoImp.this.jFrameAltaAlumno = new JFrameAltaAlumno();
				/*VistaAlumnoImp.this.panelInf.add(VistaAulaImp.this.panelAltaAula
						.getPanel());*/
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_ALUMNOS, null);
			}
		});
		baja.addActionListener(new ActionListenerBajaAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VistaAlumnoImp.this.jFrameBajaAlumno = new JFrameBajaAlumno();
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_ALUMNOS,
						null);
			}
		});
		modificar.addActionListener(new ActionListenerModificarAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VistaAlumnoImp.this.jFrameModificarAlumno = new JFrameModificarAlumno();
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_ALUMNOS,
						null);
			}
		});
		listarAlumnos.addActionListener(new ActionListenerListarAlumnos() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/*VistaAlumnoImp.this.jFrameMostrarAlumnos = new JFrameListarAlumnos();
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_ALUMNOS,
						null);*/

			}
		});

		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaAlumnoImp.this.frameAlumnos.dispose();
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_PRINCIPAL, null);
			}
		});

	}

	public void mostrarAlumnoId(ArrayList<TransferAlumno> list) {
		if (list != null) {
			if (this.jFrameBajaAlumno != null)
				this.jFrameBajaAlumno.actualizarMostrarAlumnoId(list);
			if (this.jFrameModificarAlumno != null)
		//		this.jFrameModificarAlumno.actualizarMostrarAlumnoId(list);
			if (this.jFrameListarAlumnos != null)
				this.jFrameListarAlumnos.actualizarAlumnos(list);
		}
	}
/*	public JPanel getPanelAlumno(){
		return this.panelAlumnos;
	}
*/
}