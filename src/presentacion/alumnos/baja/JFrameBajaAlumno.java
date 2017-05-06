/**
 * 
 */
package presentacion.alumnos.baja;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.alumnos.TransferAlumno;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class JFrameBajaAlumno extends JFrame {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static long serialVersionUID;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JButton jButton;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JLabel jLabel;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private JTextField jTextField;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	private JButton btnContinuar;

	private JButton btnCancelar;

	private JLabel mensajeId;

	private JTextField id;

	private JPanel panelBaja;

	private JTable table;

	private DefaultTableModel modelo;

	private JTextArea infoBaja;

	private JScrollPane scroll;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public JFrameBajaAlumno() {
		// begin-user-code
		initGUIBajaAlumno();
		ventana();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUIBajaAlumno() {
		// begin-user-code
		//Creacion de componentes
		this.panelBaja = new JPanel();
		this.btnContinuar = new JButton("Continuar");
		this.btnCancelar = new JButton("Cerrar");
		this.mensajeId = new JLabel("Id del Alumno: ");
		this.id = new JTextField();

		mensajeInicial();

		panelesAuxiliares();

		actionListener();

		actionListenerX();

		this.add(this.panelBaja);
		// end-user-code
	}

	private void panelesAuxiliares() {
		//Creacion paneles
		JPanel panelAux0 = new JPanel();
		JPanel panelAux1 = new JPanel();
		JPanel panelAux2 = new JPanel();
		JPanel panelAux3 = new JPanel();

		crecionTabla();

		//PanelAux0
		panelAux0.setLayout(new FlowLayout());
		panelAux0.setMaximumSize(new Dimension(270, 350));
		panelAux0.add(infoBaja);
		//PanelAux1
		panelAux1.setLayout(new BoxLayout(panelAux1, BoxLayout.X_AXIS));
		panelAux1.add(this.mensajeId);
		panelAux1.add(this.id);
		panelAux1.setMaximumSize(new Dimension(250, 300));
		//PanelAux2
		panelAux2.setLayout(new BoxLayout(panelAux2, BoxLayout.X_AXIS));
		this.btnContinuar.setMaximumSize(new Dimension(200, 150));
		this.btnCancelar.setMaximumSize(new Dimension(200, 150));
		panelAux2.add(this.btnContinuar);
		panelAux2.add(this.btnCancelar);

		//PanelAux3
		panelAux3.setLayout(new GridLayout(1, 1));
		panelAux3.setMaximumSize(new Dimension(270, 225));
		panelAux3.add(scroll);

		//Añado los panelesAux al panelBaja
		this.panelBaja.setLayout(new BoxLayout(this.panelBaja, BoxLayout.Y_AXIS));
		this.panelBaja.add(panelAux0);
		this.panelBaja.add(panelAux1);
		this.panelBaja.add(panelAux2);
		this.panelBaja.add(panelAux3);

	}

	private void actionListener() {

		this.btnContinuar.addActionListener(new ActionListenerBajaAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = parseInt(JFrameBajaAlumno.this.id.getText());
					TransferAlumno tAlumno = new TransferAlumno("", "", "",
							"", "", "", -1, id, false);
					Controlador.getInstance().accion(
							EventoNegocio.LEER_ALUMNOID, null);
					Controlador.getInstance().accion(EventoNegocio.BAJA_ALUMNO,
							tAlumno);
				} catch (Exception e) {
				}
			}

			private int parseInt(String dato) {
				int resultado = -1;
				try {
					resultado = Integer.parseInt(dato);
				} catch (NumberFormatException e) {
				}
				return resultado;
			}

		});
		this.btnCancelar.addActionListener(new ActionListenerBajaAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrameBajaAlumno.this.dispose();
			}

		});
	}

	private void crecionTabla() {
		//Tabla
		String[] colsName = { "Alumno", "Id" };
		this.modelo = new DefaultTableModel(15, 2);
		modelo.setColumnIdentifiers(colsName);
		this.table = new JTable(modelo);
		this.scroll = new JScrollPane(this.table);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.table.setMaximumSize(new Dimension(200, 300));
		this.table.setEnabled(false);
	}

	private void actionListenerX() {

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				JFrameBajaAlumno.this
						.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
	}

	private void mensajeInicial() {
		//Panel 0 mensaje con info
		this.infoBaja = new JTextArea();
		infoBaja.setLineWrap(true);
		infoBaja.setWrapStyleWord(true);
		infoBaja.setForeground(Color.BLACK);
		infoBaja.setSize(new Dimension(270, 350));
		infoBaja.setText("Para dar de baja un alumno, introduzca el  "
				+ "identificador y despues pulse continuar.");
		infoBaja.setEditable(false);
	}

	public void actualizarMostrarAlumnoId(List<TransferAlumno> list) {
		limpiarTabla();
		for (int i = 0; i < list.size(); i++) {
			this.modelo.setValueAt(list.get(i).getNombreAlumno(), i, 0);
			this.modelo.setValueAt(list.get(i).getId(), i, 1);
		}
		this.modelo.fireTableDataChanged();

	}

	private void limpiarTabla() {
		for (int i = 0; i < this.modelo.getRowCount(); i++) {
			this.modelo.setValueAt("", i, 0);
			this.modelo.setValueAt("", i, 1);
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void ventana() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		this.setTitle("Baja Alumno");
		this.setSize(300, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// end-user-code
	}
}