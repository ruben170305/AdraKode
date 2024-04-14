package Ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class CrearPartida extends JPanel {
	private JTextField jugadores_txt;
	private JTextField duracion_txt;
	private JTextField fecha_txt;
	private JTextField estado_txt;
	
	public CrearPartida() {
		//super(titulo);
		//getContentPane().setBackground(new Color(242, 242, 242));
		inicializarComponentes();
	}
	
	private void inicializarComponentes() {
    	// Adecuamos la ventana al OS
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setLayout(null);
        setPreferredSize(new Dimension(600, 400));
        
        // Añadimos un título
        JLabel title_label = new JLabel( "CREAR PARTIDA", SwingConstants.CENTER );
        title_label.setBounds(0, 28, 584, 28);
        title_label.setFont( new Font( "Arial", Font.BOLD, 24 ) ); 
		add(title_label);
		
		JLabel jugadores_label = new JLabel("Jugadores:");
		jugadores_label.setBounds(202, 146, 83, 14);
		add(jugadores_label);
		
		jugadores_txt = new JTextField();
		jugadores_txt.setBounds(284, 143, 86, 20);
		add(jugadores_txt);
		jugadores_txt.setColumns(10);
		
		JLabel duracion_label = new JLabel("Duración:");
		duracion_label.setBounds(202, 174, 83, 14);
		add(duracion_label);
		
		duracion_txt = new JTextField();
		duracion_txt.setColumns(10);
		duracion_txt.setBounds(284, 171, 86, 20);
		add(duracion_txt);
		
		JLabel fecha_label = new JLabel("Fecha:");
		fecha_label.setBounds(202, 199, 83, 14);
		add(fecha_label);
		
		fecha_txt = new JTextField();
		fecha_txt.setColumns(10);
		fecha_txt.setBounds(284, 196, 86, 20);
		add(fecha_txt);
		
		JLabel estado_label = new JLabel("Estado:");
		estado_label.setBounds(202, 224, 83, 14);
		add(estado_label);
		
		estado_txt = new JTextField();
		estado_txt.setColumns(10);
		estado_txt.setBounds(284, 221, 86, 20);
		add(estado_txt);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(245, 327, 89, 23);
		add(btnCrear);
		
	}
	
    // Ejecutamos la ventana
    public static void main(String[] args) {
    	
    	// Evitamos el Event Dispatch
		java.awt.EventQueue.invokeLater( new Runnable() {
			
			public void run() {
				// Abrimos la ventana
		        JFrame frame = new JFrame( "Crear Partida" );
		        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		        frame.add( new CrearPartida() );
		        frame.pack();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
			}
        });
    }
}