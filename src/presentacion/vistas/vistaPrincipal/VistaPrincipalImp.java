package presentacion.vistas.vistaPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaPrincipalImp extends VistaPrincipal {
	private JFrame framePpal;
	private JPanel panelCentral;

	public VistaPrincipalImp() {
		initGUI();
		ventanaPpal();
	}

	/** 
	 * (sin Javadoc)
	 * @see VistaPrincipal#ventanaPpal()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void ventanaPpal() {
		// begin-user-code
		this.framePpal.setTitle("Menu Principal");
		this.framePpal.setPreferredSize(new Dimension(727, 500));
		this.framePpal.setVisible(true);
		this.framePpal.setLocation(270, 20);
		this.framePpal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.framePpal.setResizable(false);
		this.framePpal.pack();
		// end-user-code
	}

	private void initGUI() {
		this.framePpal = new JFrame();
		this.framePpal.setLayout(new BorderLayout());
		//Panel superior
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new GridLayout(1, 1));
		panelSup.setPreferredSize(new Dimension(1000, 180));
		//Imagen superior
		ImageIcon icon = new ImageIcon("Imagenes/logo.jpg");
		JLabel label = new JLabel(icon);
		panelSup.add(label);		

		//Panel izquierdo
		JPanel panelIz = new JPanel();
		panelIz.setBackground(Color.white);
		panelIz.setLayout(new BoxLayout(panelIz, BoxLayout.Y_AXIS));
		//Botones
		ImageIcon aulaIcon = new ImageIcon("Imagenes/aulas.PNG");
		JButton aulas = new JButton(aulaIcon);
		aulas.setBackground(Color.white);

		ImageIcon cursosIcon = new ImageIcon("Imagenes/cursos.PNG");
		JButton cursos = new JButton(cursosIcon);
		cursos.setBackground(Color.white);

		ImageIcon alumnosIcon = new ImageIcon("Imagenes/alumnos.PNG");
		JButton alumnos = new JButton(alumnosIcon);
		alumnos.setBackground(Color.white);

		ImageIcon profesoresIcon = new ImageIcon("Imagenes/profesores.PNG");
		JButton profesores = new JButton(profesoresIcon);
		profesores.setBackground(Color.white);

		ImageIcon matriculaIcon = new ImageIcon("Imagenes/matricula.PNG");
		JButton matricula = new JButton(matriculaIcon);
		matricula.setBackground(Color.white);

		ImageIcon salirIcon = new ImageIcon("Imagenes/salir.PNG");
		JButton salir = new JButton(salirIcon);
		salir.setBackground(Color.white);

		//A�adir al panel Izquierdo
		panelIz.add(aulas);
		panelIz.add(cursos);
		panelIz.add(alumnos);
		panelIz.add(profesores);
		panelIz.add(matricula);
		panelIz.add(salir);

		// Panel Central
		this.panelCentral = new JPanel();
		this.panelCentral.setBackground(Color.white);
		this.framePpal.add(this.panelCentral, BorderLayout.CENTER);

		//A�adir al panel principal
		this.framePpal.add(panelSup, BorderLayout.NORTH);
		this.framePpal.add(panelIz, BorderLayout.WEST);
		//this.framePpal.add(panelCentral, BorderLayout.CENTER);

		aulas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_AULAS, null);
			}
		});

		cursos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_CURSOS, null);
			}

		});
		alumnos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_ALUMNOS, null);
			}
		});

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
	}

	/** 
	 * (sin Javadoc)
	 * @see VistaPrincipal#addPanelCentral(Component c)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void addPanelCentral(Component c) {
		// begin-user-code
		this.panelCentral.add(c);
		this.panelCentral.updateUI();
		// end-user-code
	}
}
