/**
 * 
 */
package presentacion.aulas.listarAulas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.lang.reflect.Constructor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.aulas.TransferAula;
import presentacion.aulas.baja.ActionListenerBajaAula;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@SuppressWarnings("serial")
public class JPanelListarAulas extends JPanel {

	
	private JTextField id;

	private JTable tabla;

	private JButton btnContinuar;

	private JButton btnCancelar;

	private DefaultTableModel modelo;

	private JScrollPane scroll;

	private ArrayList list2;

	private List<TransferAula> list;
	
	private JPanel panelAux0;
	private JPanel panelAux1;
	private JPanel panelAux2;
	private JPanel panelListar;
	private JPanel infoAula;
	
	private JLabel nombre;
	private JLabel capacidad;
	private JLabel ID;
	private JLabel estado;
	private JLabel mensajeId;

	
	public JPanelListarAulas() {
		initGUI();
		ventana();
	}

	private void ventana() {
		// begin-user-code
		this.panelListar.setSize(new Dimension(400, 300));
		this.panelListar.setVisible(true);
		this.panelListar.setOpaque(false);
		// end-user-code
	}

	private void initGUI() {
		// begin-user-code
		panelListar = new JPanel();
		panelListar.setLayout(new GridLayout(1,1));
		JPanel panelSuperior = new JPanel();
		panelSuperior.setOpaque(false);
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
		JPanel panelInferior = new JPanel(new BorderLayout());
		panelInferior.setOpaque(false);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		this.panelAux0 = new JPanel();
		this.panelAux0.setOpaque(false);
		this.panelAux1 = new JPanel();
		this.panelAux1.setOpaque(false);
		this.panelAux2 = new JPanel();
		this.panelAux2.setOpaque(false);
		this.btnContinuar = new JButton("Buscar");
		this.btnCancelar = new JButton("Salir");

		introduceId();

		//Panel 1 Botones
		this.panelAux1.setLayout(new GridLayout(1, 2));
		this.panelAux1.add(this.btnContinuar);
		this.panelAux1.add(this.btnCancelar);
		this.panelAux1.setPreferredSize(new Dimension(400, 50));

		creacionTabla();

		//Panel 2 Tabla
		this.panelAux2.setLayout(new GridLayout(1, 2));
		this.panelAux2.add(this.scroll);
		JPanel panelIntermedio = new JPanel();
		panelIntermedio.setOpaque(false);
		panelIntermedio.setMaximumSize(new Dimension(400,150));
		panelIntermedio.setLayout(new BoxLayout(panelIntermedio, BoxLayout.Y_AXIS));
		panelIntermedio.add(this.panelAux0);
		panelIntermedio.add(this.panelAux1);

		this.infoAula = new JPanel();
		this.infoAula.setOpaque(false);
		infoAula.setLayout(new GridLayout(4, 2));
		this.infoAula.setMaximumSize(new Dimension(300,100));
		JLabel nombre = new JLabel("Nombre Aula: ");
		nombre.setFont(new Font("Tahoma", 0, 15));
		nombre.setForeground(Color.blue);

		JLabel capacidad = new JLabel("Capacidad: ");
		capacidad.setFont(new Font("Tahoma", 0, 15));
		capacidad.setForeground(Color.blue);

		JLabel id = new JLabel("Id: ");
		id.setFont(new Font("Tahoma", 0, 15));
		id.setForeground(Color.blue);

		JLabel estado = new JLabel("Estado: ");
		estado.setFont(new Font("Tahoma", 0, 15));
		estado.setForeground(Color.blue);

		this.nombre = new JLabel();
		this.capacidad = new JLabel();
		this.ID = new JLabel();
		this.estado = new JLabel();

		infoAula.add(nombre);
		infoAula.add(this.nombre);
		infoAula.add(capacidad);
		infoAula.add(this.capacidad);
		infoAula.add(id);
		infoAula.add(this.ID);
		infoAula.add(estado);
		infoAula.add(this.estado);
		panelSuperior.add(panelIntermedio);
		panelSuperior.add(infoAula);
		panelIntermedio.add(this.scroll);

		actionListener();
		this.panelListar.add(panelSuperior);

		// end-user-code
	}

	private void introducirDatos(String nombre, String id, String capacidad,
			String estado) {
		// begin-user-code
		this.nombre.setText(nombre);
		this.capacidad.setText(capacidad);
		this.ID.setText(id);
		this.estado.setText(estado);
		infoAula.updateUI();
		// end-user-code
	}

	private void introduceId() {
		// begin-user-code
		//Panel 0
		this.mensajeId = new JLabel("Introduce id del aula para ver detalles");
		this.id = new JTextField();
		this.mensajeId.setMaximumSize(new Dimension(400, 50));
		this.mensajeId.setFont(new Font("Tahoma", 0, 15));
		this.id.setSize(new Dimension(100, 100));
		this.panelAux0.setMaximumSize(new Dimension(500, 50));
		this.panelAux0.setLayout(new GridLayout(2,1));
		this.panelAux0.add(this.mensajeId);
		this.panelAux0.add(this.id);

		// end-user-code
	}

	private void creacionTabla() {
		// begin-user-code
		//Tabla
		String[] colsName = { "Nombre", "Id" };
		this.modelo = new DefaultTableModel();//15/2
		modelo.setColumnIdentifiers(colsName);
		this.tabla = new JTable(modelo);
		this.scroll = new JScrollPane(this.tabla);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.tabla.setMaximumSize(new Dimension(200, 300));
		this.tabla.setEnabled(false);
		// end-user-code
	}

	private int parseInt(String dato) {
		// begin-user-code
		int resultado = -1;
		try {
			resultado = Integer.parseInt(dato);
		} catch (NumberFormatException e) {
		}
		return resultado;
		// end-user-code
	}

	private void actionListener() {
		// begin-user-code

		this.btnContinuar.addActionListener(new ActionListenerListarAulas() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TransferAula tAula = mostrarAula(parseInt(JPanelListarAulas.this.id
						.getText()));
				if (tAula != null) {
					if (tAula.getEstado())
						introducirDatos(tAula.getNombreAula(),
								Integer.toString(tAula.getId()),
								Integer.toString(tAula.getCapacidad()),
								"ACTIVO");
					else
						introducirDatos(tAula.getNombreAula(),
								Integer.toString(tAula.getId()),
								Integer.toString(tAula.getCapacidad()),
								"INACTIVO");
				} else
					JOptionPane.showMessageDialog(new JFrame(),
							"Id incorrecto!", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		this.btnCancelar.addActionListener(new ActionListenerBajaAula() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//JFrameListarAulas.this.dispose();
				panelListar.setVisible(false);
			}
		});
		// end-user-code
	}

	private TransferAula mostrarAula(int id) {
		// begin-user-code
		TransferAula resultado = null;
		int cont = 0;
		while (resultado == null && cont < list.size()) {
			if (this.list.get(cont).getId() == id) {
				resultado = this.list.get(cont);
			}
			cont++;
		}
		return resultado;
		// end-user-code
	}

	public void actualizar(ArrayList list) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	public void actualizarAulas(ArrayList<TransferAula> list) {
		this.list = list;//preg,
		for (int i = 0; i < list.size(); i++) {
			String[] datos = { list.get(i).getNombreAula(),
					Integer.toString(list.get(i).getId()) };
			this.modelo.addRow(datos);
		}
		this.modelo.fireTableDataChanged();
	}
	
	public JPanel getPanel() {
		// begin-user-code
		return this.panelListar;
		// end-user-code
	}
}