/**
 * 
 */
package presentacion.aulas.modificar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Scrollbar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import java.lang.reflect.Constructor;
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
public class JPanelModificarAula extends JPanel {

	private JButton btnCancelar;
	private JButton btnContinuar;

	private JLabel mensajeId;
	private JLabel mensajeNombre;
	private JLabel mensajeCapacidad;

	private JTextField id ;
	private JTextField nombre ;
	private JTextField capacidad;

	private JTable tabla;
	
	private JPanel panelModificar;

	private DefaultTableModel modelo;

	private JScrollPane scroll;

	
	public JPanelModificarAula() {
		// begin-user-code
		initGUI();
		ventana();
		// end-user-code
	}
	
	private void ventana() {
		// begin-user-code
		this.panelModificar.setSize(300, 400);
		this.panelModificar.setVisible(true);
		this.panelModificar.setOpaque(false);
		// end-user-code
	}

	private void initGUI() {
		// begin-user-code
		//Creo todos los componentes
		this.panelModificar = new JPanel();
		JPanel panelAux0 = new JPanel();
		panelAux0.setOpaque(false);
		JPanel panelAux1 = new JPanel();
		panelAux1.setOpaque(false);
		JPanel panelAux2 = new JPanel();
		panelAux2.setOpaque(false);
		JPanel panelAux3 = new JPanel();
		panelAux3.setOpaque(false);
		JPanel panelAux4 = new JPanel();
		panelAux4.setOpaque(false);

		creacionTabla();

		this.btnCancelar = new JButton("Cancelar");
		this.btnContinuar = new JButton("Continuar");
		this.mensajeId = new JLabel("ID aula a modificar");
		this.mensajeNombre = new JLabel("Nuevo nombre        ");
		this.mensajeCapacidad = new JLabel("Nueva capacidad  ");
		this.id = new JTextField();
		this.nombre = new JTextField();
		this.capacidad = new JTextField();

		//Panel 0
		panelAux0.setLayout(new GridLayout(1, 2));
		panelAux0.add(this.mensajeNombre);
		panelAux0.add(this.nombre);
		//Panel 1
		panelAux1.setLayout(new GridLayout(1, 2));
		panelAux1.add(this.mensajeCapacidad);
		panelAux1.add(this.capacidad);
		//Panel 2
		panelAux2.setLayout(new GridLayout(1, 2));
		panelAux2.add(this.mensajeId);
		panelAux2.add(this.id);
		//Panel 3
		panelAux3.setLayout(new GridLayout(1, 2));
		panelAux3.add(this.btnContinuar);
		panelAux3.add(this.btnCancelar);
		//Panel 4
		panelAux4.setLayout(new BorderLayout());
		panelAux4.add(this.scroll, BorderLayout.CENTER);
		//panelAux4.setMaximumSize(new Dimension(300,200));
		//this.tabla.setMaximumSize(panelAux4.getSize());

		//Añado todo al panel principal
		this.panelModificar.setLayout(new BoxLayout(this.panelModificar,
				BoxLayout.Y_AXIS));
		this.panelModificar.add(panelAux2);
		this.panelModificar.add(panelAux0);
		this.panelModificar.add(panelAux1);
		this.panelModificar.add(panelAux3);
		this.panelModificar.add(panelAux4);
		
		actionListener();
		// end-user-code
	}

	private void actionListener() {
		// begin-user-code

		this.btnCancelar.addActionListener(new ActionListenerModificarAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelModificar.setVisible(false);
			}
			
		});

		this.btnContinuar.addActionListener(new ActionListenerModificarAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TransferAula tAula = null;
				String nombre = JPanelModificarAula.this.nombre.getText();
				int capacidad = parseInt(JPanelModificarAula.this.capacidad
						.getText());
				int id = parseInt(JPanelModificarAula.this.id.getText());
				tAula = new TransferAula(nombre, capacidad, id, false);
				Controlador.getInstance().accion(EventoNegocio.MODIFICAR_AULA,
						tAula);
				Controlador.getInstance().accion(EventoNegocio.MOSTRAR_AULAS,
						null);
			}
		});
		// end-user-code
	}

	private int parseInt(String dato) {
		int resultado = -1;
		try {
			resultado = Integer.parseInt(dato);
		} catch (NumberFormatException e) {
		}
		return resultado;
	}

	private void creacionTabla() {
		//Tabla
		String[] colsName = { "Aula", "Id" };
		this.modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colsName);
		this.tabla = new JTable(modelo);
		this.scroll = new JScrollPane(this.tabla);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.tabla.setMaximumSize(new Dimension(200, 100));
		this.tabla.setEnabled(false);
	}

	public void actualizarMostrarAulaId(List<TransferAula> list) {
		for (int i = 0; i < list.size(); i++) {
			String[] datos = { list.get(i).getNombreAula(),
					Integer.toString(list.get(i).getId()) };
			this.modelo.addRow(datos);
		}
		this.modelo.fireTableDataChanged();

	}

	private void clearTable() {
		for (int i = 0; i < this.modelo.getRowCount(); i++) {
			this.modelo.setValueAt("", i, 0);
			this.modelo.setValueAt("", i, 1);
		}
	}

	public JPanel getPanel() {
		// begin-user-code
		return this.panelModificar;
		// end-user-code
	}
}