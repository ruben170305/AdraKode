package views;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class EditarPersonaje extends JPanel {
	private JTextField experienciaTxt;
	private JTextField fuerzaTxt;
	private JTextField destrezaTxt;
	private JTextField constitucionTxt;
	private JTextField inteligenciaTxt;
	private JTextField sabiduriaTxt;
	private JTextField carismaTxt;
	
	
	public EditarPersonaje(String titulo) {
		//super(titulo);
		//setBackground(new Color(242, 242, 242));
		inicializarComponentes();
		hacerVisible();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		
		JLabel txtTitulo = new JLabel("Editar Personaje");
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitulo.setBounds(202, 11, 168, 31);
		add(txtTitulo);
		
		JLabel seleccionarPersonajeTxt = new JLabel("Seleccione personaje:");
		seleccionarPersonajeTxt.setBounds(173, 53, 119, 14);
		add(seleccionarPersonajeTxt);
		
		String[] opcionesComboBox = {"Jugador 1", "Jugador 2", "Jugador 3", "Jugador 4"};
		JComboBox<String> comboBoxSeleccionar = new JComboBox<String>(opcionesComboBox);
		comboBoxSeleccionar.setBounds(302, 49, 105, 22);
		
		add(comboBoxSeleccionar);
		
		JLabel personajeTxtSeleccion = new JLabel("Personaje");
		personajeTxtSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		personajeTxtSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		personajeTxtSeleccion.setBounds(247, 96, 83, 22);
		add(personajeTxtSeleccion);
		
		JLabel experienciaLbl = new JLabel("Experiencia:");
		experienciaLbl.setBounds(202, 146, 83, 14);
		add(experienciaLbl);
		
		experienciaTxt = new JTextField();
		experienciaTxt.setBounds(284, 143, 86, 20);
		add(experienciaTxt);
		experienciaTxt.setColumns(10);
		
		JLabel fuerzaLbl = new JLabel("Fuerza:");
		fuerzaLbl.setBounds(202, 174, 83, 14);
		add(fuerzaLbl);
		
		fuerzaTxt = new JTextField();
		fuerzaTxt.setColumns(10);
		fuerzaTxt.setBounds(284, 171, 86, 20);
		add(fuerzaTxt);
		
		JLabel destrezaLbl = new JLabel("Destreza:");
		destrezaLbl.setBounds(202, 199, 83, 14);
		add(destrezaLbl);
		
		destrezaTxt = new JTextField();
		destrezaTxt.setColumns(10);
		destrezaTxt.setBounds(284, 196, 86, 20);
		add(destrezaTxt);
		
		JLabel lblConstitucion = new JLabel("Constitución:");
		lblConstitucion.setBounds(202, 224, 83, 14);
		add(lblConstitucion);
		
		constitucionTxt = new JTextField();
		constitucionTxt.setColumns(10);
		constitucionTxt.setBounds(284, 221, 86, 20);
		add(constitucionTxt);
		
		JLabel lblInteligencia = new JLabel("Inteligencia:");
		lblInteligencia.setBounds(202, 249, 83, 14);
		add(lblInteligencia);
		
		inteligenciaTxt = new JTextField();
		inteligenciaTxt.setColumns(10);
		inteligenciaTxt.setBounds(284, 246, 86, 20);
		add(inteligenciaTxt);
		
		JLabel lblSabiduria = new JLabel("Sabiduria:");
		lblSabiduria.setBounds(202, 274, 83, 14);
		add(lblSabiduria);
		
		sabiduriaTxt = new JTextField();
		sabiduriaTxt.setColumns(10);
		sabiduriaTxt.setBounds(284, 271, 86, 20);
		add(sabiduriaTxt);
		
		JLabel lblCarisma = new JLabel("Carisma:");
		lblCarisma.setBounds(202, 299, 83, 14);
		add(lblCarisma);
		
		carismaTxt = new JTextField();
		carismaTxt.setColumns(10);
		carismaTxt.setBounds(284, 296, 86, 20);
		add(carismaTxt);
		
		JButton btnEditar = new JButton("Editar");
		/*btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				experienciaTxt.setEditable(false);
				fuerzaTxt.setEditable(true);
				destrezaTxt.setEditable(true);
				constitucionTxt.setEditable(true);
				inteligenciaTxt.setEditable(true);
				sabiduriaTxt.setEditable(true);
				carismaTxt.setEditable(true);
			}
		});*/
		btnEditar.setBounds(173, 327, 89, 23);
		add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(318, 327, 89, 23);
		add(btnEliminar);
		
		setSize(600, 400);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
