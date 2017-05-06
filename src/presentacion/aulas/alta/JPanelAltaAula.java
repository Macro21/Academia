/**
 * 
 */
package presentacion.aulas.alta;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.reflect.Constructor;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import negocio.aulas.TransferAula;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class JPanelAltaAula extends JPanel {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelAlta;
	private JButton buttonContinuar;
	private JButton buttonCancelar;
	private JLabel lblNombre;
	private JLabel lblCapacidad;
	private JTextField nombre;
	private JTextField capacidad;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public JPanelAltaAula() {
		// begin-user-code
		super();
		initGUIAltaAula();
		ventana();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUIAltaAula() {
		// begin-user-code

		//Creacion de los componentes
		this.panelAlta = new JPanel();
		this.panelAlta.setBackground(Color.gray);

		this.buttonContinuar = new JButton("Dar de Alta");
		this.buttonCancelar = new JButton("Cerrar");

		this.lblNombre = new JLabel("Nombre del aula: ");
		this.lblCapacidad = new JLabel("Capacidad: ");
		this.lblNombre.setFont(new Font("Tahoma", 0, 15));
		this.lblCapacidad.setFont(new Font("Tahoma", 0, 15));
		Border border = LineBorder.createBlackLineBorder();
		this.lblNombre.setBorder(border);
		this.lblCapacidad.setBorder(border);
		this.lblNombre.setForeground(Color.BLACK);
		this.lblCapacidad.setForeground(Color.BLACK);

		this.nombre = new JTextField();
		this.capacidad = new JTextField();

		this.buttonContinuar.addActionListener(new ActionListenerAltaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre = JPanelAltaAula.this.nombre.getText();
				TransferAula tAula = null;
				try {
					int capacidad = Integer
							.parseInt(JPanelAltaAula.this.capacidad.getText());
					tAula = new TransferAula(nombre, capacidad, -1, true);
				} catch (Exception e) {
					tAula = new TransferAula(nombre, -1, -1, true);
				} finally {
					Controlador.getInstance().accion(EventoNegocio.ALTA_AULA,
							tAula);
				}
			}
		});

		this.buttonCancelar.addActionListener(new ActionListenerAltaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelAlta.setVisible(false);
			}
		});

		panelAlta.setLayout(new GridLayout(3, 2));
		//Se añaden los componentes al panel
		panelAlta.add(this.lblNombre);
		panelAlta.add(this.nombre);

		panelAlta.add(this.lblCapacidad);
		panelAlta.add(this.capacidad);

		panelAlta.add(this.buttonContinuar);
		panelAlta.add(this.buttonCancelar);
		//panelAlta.setVisible(true);


		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void ventana() {
		// begin-user-code
		this.panelAlta.setSize(new Dimension(250,200));
		this.panelAlta.setVisible(true);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public JPanel getPanel() {
		// begin-user-code
		return this.panelAlta;
		// end-user-code
	}
}