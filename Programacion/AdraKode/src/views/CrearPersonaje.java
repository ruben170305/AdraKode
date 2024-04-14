package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CrearPersonaje extends JPanel {
	private JTextField experienciaTxt;
	private JTextField fuerzaTxt;
	private JTextField destrezaTxt;
	private JTextField constitucionTxt;
	private JTextField inteligenciaTxt;
	private JTextField sabiduriaTxt;
	private JTextField carismaTxt;
	private JTextField nombreTxt;
	
	public CrearPersonaje(String titulo) {
		//super(titulo);
		//getContentPane().setBackground(new Color(242, 242, 242));
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);
		setLayout(null);
		setSize(770, 530);
		
		JLabel txtTitulo = new JLabel("Crear Personaje");
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTitulo.setBounds(202, 11, 168, 31);
		add(txtTitulo);
		
		JLabel crearPersonajeTxt = new JLabel("Nombre del personaje:");
		crearPersonajeTxt.setBounds(173, 53, 119, 14);
		add(crearPersonajeTxt);
		
		nombreTxt = new JTextField();
		nombreTxt.setBounds(302, 50, 105, 20);
		add(nombreTxt);
		nombreTxt.setColumns(10);
		
		String[] opcionesComboBox = {"Jugador 1", "Jugador 2", "Jugador 3", "Jugador 4"};
		
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
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(245, 327, 89, 23);
		add(btnCrear);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
}
