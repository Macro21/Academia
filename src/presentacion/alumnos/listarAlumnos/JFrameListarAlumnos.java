/**
 * 
 */
package presentacion.alumnos.listarAlumnos;

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
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.alumnos.TransferAlumno;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ricardo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class JFrameListarAlumnos extends JFrame {
	private JTable tabla;

	private JPanel panelAux0;

	private JPanel panelAux1;

	private JButton btnContinuar;

	private JButton btnCancelar;
	
	private JTextArea jTextArea;
	
	private JTextField id;
	
	private DefaultTableModel modelo;
	
	private JScrollPane scroll;
	
	private ArrayList list2;

	private List<TransferAlumno> list;
	private JPanel panelAux2;

	private JPanel panelAux3;

	private JLabel nombre;

	private JLabel ap1;
	
	private JLabel ap2;
	
	private JLabel DNI;
	
	private JLabel domicilio;
	
	private JLabel fecha;
	
	private JLabel telefono;

	private JLabel ID;

	private JLabel estado;

	private JPanel infoAlumno;

	private JLabel mensajeId;
	
	public JFrameListarAlumnos() {
		initGUI();
		ventana();
	}

	private void ventana() {
		this.setTitle("Alumnos");
		this.setSize(590, 490);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initGUI() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.X_AXIS));
		JPanel panelInferior = new JPanel(new BorderLayout());
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));

		this.panelAux0 = new JPanel();
		this.panelAux1 = new JPanel();
		this.panelAux2 = new JPanel();
		this.panelAux3 = new JPanel();
		this.btnContinuar = new JButton("Buscar");
		this.btnCancelar = new JButton("Salir");

		introduceId();
		

		//Panel 1 Botones
		this.panelAux1.setLayout(new GridLayout(1, 2));
		this.panelAux1.add(this.btnContinuar);
		this.panelAux1.add(this.btnCancelar);
		this.panelAux1.setMaximumSize(new Dimension(400, 25));

		creacionTabla();

		//Panel 2 Tabla
		this.panelAux2.setLayout(new GridLayout(1, 2));
		this.panelAux2.add(this.scroll);
		//Panel 3 Imagen
		this.panelAux3
				.setLayout(new BoxLayout(this.panelAux3, BoxLayout.X_AXIS));

		ImageIcon icon = new ImageIcon("Imagenes/prueba.jpg");
		JLabel label = new JLabel(icon);

		this.panelAux3.add(label);

		JPanel panelIntermedio = new JPanel();
		panelIntermedio.setLayout(new BoxLayout(panelIntermedio,
				BoxLayout.Y_AXIS));
		panelIntermedio.add(this.panelAux0);
		panelIntermedio.add(this.panelAux1);

		this.infoAlumno = new JPanel();
		infoAlumno.setLayout(new GridLayout(4, 2));
		JLabel nombre = new JLabel("Nombre Alumno: ");
		nombre.setFont(new Font("Tahoma", 0, 15));
		nombre.setForeground(Color.blue);

		JLabel ap1 = new JLabel("Primer Apellido: ");
		ap1.setFont(new Font("Tahoma", 0, 15));
		ap1.setForeground(Color.blue);
		
		JLabel ap2 = new JLabel("Segundo Apellido: ");
		ap2.setFont(new Font("Tahoma", 0, 15));
		ap2.setForeground(Color.blue);
		
		JLabel DNI = new JLabel("DNI: ");
		DNI.setFont(new Font("Tahoma", 0, 15));
		DNI.setForeground(Color.blue);
		
		JLabel domicilio = new JLabel("Domicilio: ");
		domicilio.setFont(new Font("Tahoma", 0, 15));
		domicilio.setForeground(Color.blue);
		
		JLabel fecha = new JLabel("Fecha: ");
		fecha.setFont(new Font("Tahoma", 0, 15));
		fecha.setForeground(Color.blue);
		
		JLabel telefono = new JLabel("Telefono: ");
		telefono.setFont(new Font("Tahoma", 0, 15));
		telefono.setForeground(Color.blue);

		JLabel id = new JLabel("Id: ");
		id.setFont(new Font("Tahoma", 0, 15));
		id.setForeground(Color.blue);

		JLabel estado = new JLabel("Estado: ");
		estado.setFont(new Font("Tahoma", 0, 15));
		estado.setForeground(Color.blue);

		this.nombre = new JLabel();
		this.ap1 = new JLabel();
		this.ap2 = new JLabel();
		this.DNI = new JLabel();
		this.domicilio = new JLabel();
		this.fecha = new JLabel();
		this.telefono = new JLabel();
		
		this.ID = new JLabel();
		this.estado = new JLabel();

		infoAlumno.add(nombre);
		infoAlumno.add(this.nombre);
		infoAlumno.add(ap1);
		infoAlumno.add(this.ap1);
		infoAlumno.add(ap2);
		infoAlumno.add(this.ap2);
		infoAlumno.add(DNI);
		infoAlumno.add(this.DNI);
		infoAlumno.add(domicilio);
		infoAlumno.add(this.domicilio);
		infoAlumno.add(fecha);
		infoAlumno.add(this.fecha);
		infoAlumno.add(telefono);
		infoAlumno.add(this.telefono);
		infoAlumno.add(id);
		infoAlumno.add(this.ID);
		infoAlumno.add(estado);
		infoAlumno.add(this.estado);

		panelSuperior.add(this.panelAux3);
		panelSuperior.add(infoAlumno);

		panelInferior.add(this.scroll);

		actionListener();

		actionListenerX();

		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.add(panelSuperior);
		this.add(panelIntermedio);
		this.add(panelInferior);
		this.pack();
	}
	private void introducirDatos(String nombre, String id, String capacidad,
			String estado,String ap1,String ap2, String DNI, String domicilio, String fecha, String telefono ) {
		this.nombre.setText(nombre);
		this.ap1.setText(ap1);
		this.ap2.setText(ap2);
		this.DNI.setText(DNI);
		this.domicilio.setText(domicilio);
		this.fecha.setText(fecha);
		this.telefono.setText(telefono);
		
		this.ID.setText(id);
		this.estado.setText(estado);
		infoAlumno.updateUI();

	}
	private void introduceId() {
		//Panel 0
		this.mensajeId = new JLabel("Introduce id del alumno para ver detalles");
		this.id = new JTextField();
		this.mensajeId.setSize(new Dimension(200, 200));
		this.mensajeId.setFont(new Font("Tahoma", 0, 15));
		this.id.setSize(new Dimension(100, 100));
		this.panelAux0.setMaximumSize(new Dimension(300, 400));
		this.panelAux0
				.setLayout(new BoxLayout(this.panelAux0, BoxLayout.X_AXIS));
		this.panelAux0.add(this.mensajeId);
		this.panelAux0.add(this.id);


	}
	private void creacionTabla() {
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

	}
	private int parseInt(String dato) {

		int resultado = -1;
		try {
			resultado = Integer.parseInt(dato);
		} catch (NumberFormatException e) {
		}
		return resultado;

	}
	private void actionListener() {
		// begin-user-code
/*
		this.btnContinuar.addActionListener(new ActionListenerListarAlumnos() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TransferAlumno tAlumno = mostrarAlumno(parseInt(JFrameListarAlumnos.this.id
						.getText()));
				if (tAlumno != null) {
					if (tAlumno.getEstado())
						introducirDatos(tAlumno.getNombreAlumno(),
								Integer.toString(tAlumno.getId()),
								Integer.toString(tAlumno.getCapacidad()),
								"ACTIVO");
					else
						introducirDatos(tAlumno.getNombreAula(),
								Integer.toString(tAlumno.getId()),
								Integer.toString(tAlumno.getCapacidad()),
								"INACTIVO");
				} else
					JOptionPane.showMessageDialog(new JFrame(),
							"Id incorrecto!", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		this.btnCancelar.addActionListener(new ActionListenerListarAlumno() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrameListarAlumnos.this.dispose();
			}
		});*/
		// end-user-code
	}
	private void actionListenerX() {
		// begin-user-code

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				JFrameListarAlumnos.this
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
		// end-user-code
	}
	private TransferAlumno mostrarAlumno(int id) {
		// begin-user-code
		TransferAlumno resultado = null;
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
	public void actualizarAlumnos(ArrayList<TransferAlumno> list) {
		this.list = list;//preg,
		for (int i = 0; i < list.size(); i++) {
			String[] datos = { list.get(i).getNombreAlumno(),
					Integer.toString(list.get(i).getId()) };
			this.modelo.addRow(datos);
		}
		this.modelo.fireTableDataChanged();
	}
}