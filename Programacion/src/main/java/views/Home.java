package views;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Home extends JPanel {
	public Home() {
		setBounds(new Rectangle(0, 0, 0, 19));
		setBackground(new Color(242, 242, 242));
		initialize_components();
		//make_visible();
	}
	/**
	 * Método que inicializa la ventana y los componentes
	 */
	public void initialize_components() {
		// Adaptar la apariencia del SO donde se ejecuta
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// layout absoluto
		setLayout(null);

		// Tamaño y posicion de ventana
		setSize(800, 600);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/img/imagenLogin.png")));
		lblNewLabel.setBounds(332, 218, 125, 140);
		add(lblNewLabel);
		// setLocation(null);
		
		
	}

}
