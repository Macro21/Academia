/**
 * 
 */
package presentacion.aulas.baja;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Scrollbar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.aulas.TransferAula;
import presentacion.controlador.Controlador;
import presentacion.controlador.EventoNegocio;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public class JPanelBajaAula extends JPanel {

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static final long serialVersionUID = -4255372797323249786L;

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
	public JPanelBajaAula() {
		// begin-user-code
		super();
		initGUIBajaAula();
		ventana();

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void initGUIBajaAula() {
		// begin-user-code

		//Creacion de componentes
		this.panelBaja = new JPanel();
		this.btnContinuar = new JButton("Continuar");
		this.btnCancelar = new JButton("Cancelar");
		this.mensajeId = new JLabel("Id del Aula: ");
		this.id = new JTextField();

		panelesAuxiliares();

		actionListener();

		// end-user-code
	}

	private void panelesAuxiliares() {
		//Creacion paneles
		JPanel panelAux0 = new JPanel();
		panelAux0.setOpaque(false);
		JPanel panelAux1 = new JPanel();
		panelAux1.setOpaque(false);
		JPanel panelAux2 = new JPanel();
		panelAux2.setOpaque(false);
		JPanel panelAux3 = new JPanel();
		panelAux3.setOpaque(false);

		crecionTabla();

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
		this.panelBaja.add(panelAux1);
		this.panelBaja.add(panelAux2);
		this.panelBaja.add(panelAux3);

	}

	private void actionListener() {

		this.btnContinuar.addActionListener(new ActionListenerBajaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id = parseInt(JPanelBajaAula.this.id.getText());
					TransferAula tAula = new TransferAula(null, -1, id, false);
					Controlador.getInstance().accion(EventoNegocio.BAJA_AULA,
							tAula);
					Controlador.getInstance().accion(EventoNegocio.MOSTRAR_AULAS,
							null);
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
		this.btnCancelar.addActionListener(new ActionListenerBajaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelBaja.setVisible(false);
			}

		});
	}

	private void crecionTabla() {
		//Tabla
		String[] colsName = { "Aula", "Id" };
		this.modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colsName);
		this.table = new JTable(modelo);
		this.scroll = new JScrollPane(this.table);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.table.setMaximumSize(new Dimension(200, 300));
		this.table.setEnabled(false);
	}

	public void actualizarMostrarAulaId(List<TransferAula> list) {
		for (int i = 0; i < list.size(); i++) {
			String[] datos = { list.get(i).getNombreAula(),
					Integer.toString(list.get(i).getId()) };
			this.modelo.addRow(datos);
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
		this.panelBaja.setSize(new Dimension(300,600));
		//this.panelBaja.setMaximumSize(new Dimension(250,250));
		this.panelBaja.setVisible(true);
		this.panelBaja.setOpaque(false);
		// end-user-code
	}
	
	public JPanel getPanel() {
		// begin-user-code
		return this.panelBaja;
		// end-user-code
	}
}