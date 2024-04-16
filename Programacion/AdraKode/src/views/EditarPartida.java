package views;

// Librerías
import javax.swing.*;
import java.awt.*;

public class EditarPartida extends JPanel {
    
	public EditarPartida() {
		inicializarComponentes();
	}
	
	// Creamos la ventana
    public void inicializarComponentes() {
    	
    	/*/ Adecuamos la ventana al OS
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));

        // Añadimos un título
        JLabel title_label = new JLabel( "EDITAR PARTIDA", SwingConstants.CENTER );
        title_label.setBounds(0, 28, 584, 28);
        title_label.setFont( new Font( "Arial", Font.BOLD, 24 ) );        
        
        // -------------------------------------------------------------------------------------
        // Datos de la partida
        // -------------------------------------------------------------------------------------

        // Título
        JLabel partida_label = new JLabel( "PARTIDA 1", SwingConstants.CENTER );
        partida_label.setFont( new Font( "Arial", Font.BOLD, 18 ) );
        
        // Anfitrión
        JLabel anfitrion_label = new JLabel( "Anfitrión" );
        anfitrion_label.setBounds(170, 122, 60, 18);
        
        JLabel anfitrion_value = new JLabel( "Usuario 1" );
        anfitrion_value.setForeground(new Color(0, 128, 255));
        anfitrion_value.setBounds(260, 122, 60, 18);
        
        JButton anfitrion_button = new JButton( "Editar" );
        anfitrion_button.setLocation(350, 122);
        anfitrion_button.setSize(70, 18);
        
        // Jugadores
        JLabel jugadores_label = new JLabel( "Jugadores" );
        jugadores_label.setBounds(170, 140, 60, 18);
        
        JLabel jugadores_value = new JLabel( "3" );
        jugadores_value.setForeground(new Color(0, 128, 255));
        jugadores_value.setBounds(260, 140, 60, 18);
        
        JButton jugadores_button = new JButton( "Editar" );
        jugadores_button.setLocation(350, 140);
        jugadores_button.setSize(70, 18);
        
        // Duración
        JLabel duracion_label = new JLabel( "Duración" );
        duracion_label.setBounds(170, 158, 60, 18);
        
        JLabel duracion_value = new JLabel( "15'" );
        duracion_value.setForeground(new Color(0, 128, 255));
        duracion_value.setBounds(260, 158, 60, 18);
        
        JButton duracion_button = new JButton( "Editar" );
        duracion_button.setLocation(350, 158);
        duracion_button.setSize(70, 18);
        
        // Fecha
        JLabel fecha_label = new JLabel( "Fecha" );
        fecha_label.setBounds(170, 176, 60, 18);
        
        JLabel fecha_value = new JLabel( "16-04 | 15.00 pm" );
        fecha_value.setForeground(new Color(0, 128, 255));
        fecha_value.setBounds(260, 176, 60, 18);
        
        JButton fecha_button = new JButton( "Editar" );
        fecha_button.setLocation(350, 176);
        fecha_button.setSize(70, 18);
        
        // Estado
        JLabel estado_label = new JLabel( "Estado" );
        estado_label.setBounds(170, 194, 60, 18);
        
        JLabel estado_value = new JLabel( "En espera" );
        estado_value.setForeground(new Color(0, 128, 255));
        estado_value.setBounds(260, 194, 60, 18);
        
        JButton estado_button = new JButton( "Editar" );
        estado_button.setLocation(350, 194);
        estado_button.setSize(70, 18);
        
        // -------------------------------------------------------------------------------------
        // Añadimos los componentes
        // -------------------------------------------------------------------------------------
        	
        // Título
       add( title_label );
        
        // Separador
        JSeparator separator = new JSeparator();
        separator.setBounds(170, 55, 240, 18);
       add( separator );
        
	    // Select
	    String[] options = {"Partida 1", "Partida 2", "Partida 3"};
	    JComboBox<String> comboBox = new JComboBox<>(options);
	    comboBox.setBounds(240, 70, 100, 18);
       add(comboBox);
        
        //add( anfitrion_icon );
       add( anfitrion_button );
       add( anfitrion_label );
       add( anfitrion_value );
        
       add( jugadores_button );
       add( jugadores_label );
       add( jugadores_value );

       add( duracion_button );
       add( duracion_label );
       add( duracion_value );
        
       add( fecha_button );
       add( fecha_label );
       add( fecha_value );
        
       add( estado_button );
       add( estado_label );
       add( estado_value );
    }
    
    // Ejecutamos la ventana
    public static void main(String[] args) {
    	
    	// Evitamos el Event Dispatch
		java.awt.EventQueue.invokeLater( new Runnable() {
			
			public void run() {
				// Abrimos la ventana
		        JFrame frame = new JFrame( "Editar Partida" );
		        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		        frame.add( new EditarPartida() );
		        frame.pack();
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
			}
        });
    }
}
