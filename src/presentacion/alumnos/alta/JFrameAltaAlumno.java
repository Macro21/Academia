/**
 * 
 */
package presentacion.alumnos.alta;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import negocio.alumnos.TransferAlumno;
import presentacion.aulas.alta.ActionListenerAltaAula;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class JFrameAltaAlumno extends JFrame {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JButton[] jButton = new JButton[2];

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JLabel[] jLabel = new JLabel[7];

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTextField[] jTextField = new JTextField[7];

	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JLabel lblDNI;
	private JLabel lblDomicilio;
	private JLabel lblFecha;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField DNI;
	private JTextField domicilio;
	private JTextField fecha;

	private JPanel panelAlta;

	private JLabel lblNombre;

	private JButton buttonContinuar;

	private JButton buttonCancelar;

	private JLabel lblTelefono;

	private JTextField nombre;

	private JTextField telefono;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void initGUIAltaAlumno() {
		// begin-user-code
		this.panelAlta = new JPanel();
		this.panelAlta.setBackground(Color.gray);

		this.buttonContinuar = new JButton("Dar de Alta");
		this.buttonCancelar = new JButton("Salir");

		this.lblNombre = new JLabel("Nombre del Alumno: ");
		this.lblApellido1 = new JLabel("Primer apellido: ");
		this.lblApellido2 = new JLabel("Segundo apellido: ");
		this.lblDNI = new JLabel("DNI: ");
		this.lblDomicilio = new JLabel("Domicilio: ");
		this.lblFecha = new JLabel("Fecha: ");
		this.lblTelefono = new JLabel("Telefono: ");

		this.lblNombre.setFont(new Font("Tahoma", 0, 15));
		this.lblApellido1.setFont(new Font("Tahoma", 0, 15));
		this.lblApellido2.setFont(new Font("Tahoma", 0, 15));
		this.lblDNI.setFont(new Font("Tahoma", 0, 15));
		this.lblDomicilio.setFont(new Font("Tahoma", 0, 15));
		this.lblFecha.setFont(new Font("Tahoma", 0, 15));
		this.lblTelefono.setFont(new Font("Tahoma", 0, 15));

		Border border = LineBorder.createBlackLineBorder();

		this.lblNombre.setBorder(border);
		this.lblApellido1.setBorder(border);
		this.lblApellido2.setBorder(border);
		this.lblDNI.setBorder(border);
		this.lblDomicilio.setBorder(border);
		this.lblFecha.setBorder(border);
		this.lblTelefono.setBorder(border);

		this.lblNombre.setForeground(Color.BLACK);
		this.lblApellido1.setForeground(Color.BLACK);
		this.lblApellido2.setForeground(Color.BLACK);
		this.lblDNI.setForeground(Color.BLACK);
		this.lblDomicilio.setForeground(Color.BLACK);
		this.lblFecha.setForeground(Color.BLACK);
		this.lblTelefono.setForeground(Color.BLACK);

		this.nombre = new JTextField();
		this.apellido1 = new JTextField();
		this.apellido2 = new JTextField();
		this.DNI = new JTextField();
		this.domicilio = new JTextField();
		this.fecha = new JTextField();
		this.telefono = new JTextField();

		this.buttonContinuar.addActionListener(new ActionListenerAltaAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = JFrameAltaAlumno.this.nombre.getText();
				@SuppressWarnings("unused")
				TransferAlumno tAlumno = null;
				try {
					String apellido1 = JFrameAltaAlumno.this.apellido1
							.getText();
					String apellido2 = JFrameAltaAlumno.this.apellido2
							.getText();
					String DNI = JFrameAltaAlumno.this.DNI.getText();
					String domicilio = JFrameAltaAlumno.this.domicilio
							.getText();
					String fecha = JFrameAltaAlumno.this.fecha.getText();
					int telefono = Integer
							.parseInt(JFrameAltaAlumno.this.telefono.getText());

					tAlumno = new TransferAlumno(nombre, apellido1, apellido2,
							DNI, domicilio, fecha, telefono, -1, true);
				} catch (Exception e) {
					tAlumno = new TransferAlumno(nombre, null, null, null,
							null, null, -1, -1, true);
				} finally {
					Controlador.getInstance().accion(EventoNegocio.ALTA_ALUMNO,
							tAlumno);
				}
			}
		});

		this.buttonCancelar.addActionListener(new ActionListenerAltaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrameAltaAlumno.this.dispose();
			}
		});

		panelAlta.setLayout(new GridLayout(8, 2));
		//Se ańaden los componentes al panel
		panelAlta.add(this.lblNombre);
		panelAlta.add(this.nombre);

		panelAlta.add(this.lblApellido1);
		panelAlta.add(this.apellido1);

		panelAlta.add(this.lblApellido2);
		panelAlta.add(this.apellido2);

		panelAlta.add(this.lblDNI);
		panelAlta.add(this.DNI);

		panelAlta.add(this.lblDomicilio);
		panelAlta.add(this.domicilio);

		panelAlta.add(this.lblFecha);
		panelAlta.add(this.fecha);

		panelAlta.add(this.lblTelefono);
		panelAlta.add(this.telefono);

		panelAlta.add(this.buttonContinuar);
		panelAlta.add(this.buttonCancelar);
		//panelAlta.setVisible(true);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void windowClosing(WindowEvent e) {
				JFrameAltaAlumno.this
						.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Apéndice de método generado automáticamente

			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Apéndice de método generado automáticamente

			}
		});
		this.add(this.panelAlta);

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void ventana() {
		// begin-user-code
		this.setTitle("Alta Alumno");
		this.setSize(300, 300);///////ver
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public JFrameAltaAlumno() {
		// begin-user-code
		super();
		ventana();
		initGUIAltaAlumno();
		// end-user-code
	}
}