/**
 * 
 */
package presentacion.aulas.vistasAula;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

import presentacion.aulas.alta.ActionListenerAltaAula;
import presentacion.aulas.alta.JPanelAltaAula;
import presentacion.aulas.baja.ActionListenerBajaAula;
import presentacion.aulas.baja.JPanelBajaAula;
import presentacion.aulas.listarAulas.ActionListenerListarAulas;
import presentacion.aulas.listarAulas.JPanelListarAulas;
import presentacion.aulas.modificar.ActionListenerModificarAula;
import presentacion.aulas.modificar.JPanelModificarAula;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;
import presentacion.vistas.vistaPrincipal.PanelConFondo;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class VistaAulaImp extends VistasAula {

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("unused")
	private JPanelAltaAula panelAltaAula;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanelBajaAula panelBajaAula;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanelModificarAula panelModificarAula;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanelListarAulas panelListarAulas;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanel panelAulas;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JPanel panelInf;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public VistaAulaImp() {
		// begin-user-code
		initGUIAula();
		ventana();
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see VistasAula#ventana()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void ventana() {
		// begin-user-code
		//this.panelAulas.setPreferredSize(new Dimension(520, 473));
		this.panelAulas.setVisible(true);
		//this.panelAulas.setLocation(500, 200);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUIAula() {
		// begin-user-code

		//Para Imagen con Fondo
		//this.panelAulas = new PanelConFondo("/Imagenes/prueba.jpg");
		this.panelAulas = new PanelConFondo("Imagenes/fondo3.jpg");
		this.panelAulas.setBackground(Color.green);
		this.panelAulas.setPreferredSize(new Dimension(520, 273));
		this.panelAulas.setLayout(new BoxLayout(this.panelAulas, BoxLayout.Y_AXIS));
		//Panel superior
		JPanel panelSup = new JPanel();
		panelSup.setLayout(new BoxLayout(panelSup, BoxLayout.X_AXIS));
		this.panelAulas.add(panelSup);
		
		JButton alta = new JButton("Alta Aula");
		JButton baja = new JButton("Baja Aula");
		JButton modificar = new JButton("Modificar Aula");
		JButton mostrarAulas = new JButton("Mostrar Aulas");

		panelSup.add(alta);
		panelSup.add(baja);
		panelSup.add(modificar);
		panelSup.add(mostrarAulas);
		actionListener(alta, baja, modificar, mostrarAulas);
		//Panel inferior
		//Graphics g = null;
		//ImageIcon fondo = new ImageIcon(getClass().getResource("Imagenes/prueba.jpg"));
		this.panelInf = new JPanel();
		this.panelInf.setOpaque(false);
		//Dimension tam = this.panelInf.getSize();
		//g.drawImage(fondo.getImage(),0, 0, tam.width, tam.height, panelInf);
		this.panelInf.setLayout(new GridLayout(1,1));
		this.panelInf.setMaximumSize(new Dimension (520,247));
		this.panelInf.setBackground(Color.cyan);
		/*ImageIcon aulasIcon = new ImageIcon("Imagenes/prueba.jpg");
		JLabel imagen = new JLabel(aulasIcon);
		panelInf.add(imagen);
		panelInf.setPreferredSize(new Dimension(250,150));*/
		this.panelAulas.add(panelInf);
		// end-user-code
	}
	private void actionListener(JButton alta, JButton baja, JButton modificar,
			JButton mostrarAulas) {

		alta.addActionListener(new ActionListenerAltaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VistaAulaImp.this.panelAltaAula = new JPanelAltaAula();
				VistaAulaImp.this.panelInf.removeAll();
				Dimension tam = VistaAulaImp.this.panelAltaAula.getPanel().getSize();
				VistaAulaImp.this.panelInf.setMaximumSize(tam);
				VistaAulaImp.this.panelInf.add(VistaAulaImp.this.panelAltaAula.getPanel());
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_AULAS, null);
			}
		});
		baja.addActionListener(new ActionListenerBajaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VistaAulaImp.this.panelBajaAula = new JPanelBajaAula();
				VistaAulaImp.this.panelInf.removeAll();
				Dimension tam = VistaAulaImp.this.panelBajaAula.getPanel().getSize();
				VistaAulaImp.this.panelInf.setMaximumSize(tam);
				VistaAulaImp.this.panelInf.add(VistaAulaImp.this.panelBajaAula.getPanel());
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_AULAS,
						null);
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_AULAS, null);
			}
		});
		modificar.addActionListener(new ActionListenerModificarAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VistaAulaImp.this.panelModificarAula = new JPanelModificarAula();
				VistaAulaImp.this.panelInf.removeAll();
				Dimension tam = VistaAulaImp.this.panelModificarAula.getPanel().getSize();
				VistaAulaImp.this.panelInf.setMaximumSize(tam);
				VistaAulaImp.this.panelInf.add(VistaAulaImp.this.panelModificarAula.getPanel());
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_AULAS,
						null);
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_AULAS, null);
				
			}
		});
		mostrarAulas.addActionListener(new ActionListenerListarAulas() {
			@Override
			public void actionPerformed(ActionEvent e) {

				VistaAulaImp.this.panelListarAulas = new JPanelListarAulas();
				VistaAulaImp.this.panelInf.removeAll();
				Dimension tam = VistaAulaImp.this.panelListarAulas.getPanel().getSize();
				VistaAulaImp.this.panelInf.setMaximumSize(tam);
				VistaAulaImp.this.panelInf.add(VistaAulaImp.this.panelListarAulas.getPanel());
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_AULAS,
						null);
				Controlador.getInstance().accion(
						EventoNegocio.ACTUALIZAR_VISTA_AULAS, null);
			}
		});

	}

	/** 
	 * (sin Javadoc)
	 * @see VistasAula#actualizar(String msg)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizar(String msg) {
		// begin-user-code
		JOptionPane.showMessageDialog(this.panelAulas, msg);
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see VistasAula#mostrarAulaId(ArrayList list)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void mostrarAulaId(ArrayList list) {
		// begin-user-code

		if (list != null) {
			if (this.panelBajaAula != null)
				this.panelBajaAula.actualizarMostrarAulaId(list);
			if (this.panelModificarAula != null)
				this.panelModificarAula.actualizarMostrarAulaId(list);
			if (this.panelListarAulas != null)
				this.panelListarAulas.actualizarAulas(list);
		}
		// end-user-code
	}

	/** 
	 * (sin Javadoc)
	 * @see VistasAula#getPanelAula()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public JPanel getPanelAula() {
		// begin-user-code
		return this.panelAulas;
		// end-user-code
	}
	/*@Override
	public void mostrarAula(List<TransferAula> list) {
		if(list != null)
			this.jFrameMostrarAulas.mostrarAulas(list);
		else
			actualizar("No se ha encontrado un aula con ese id");
	}*/
}