package Ventanas;

// Librerías
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListaPartidas extends JFrame {
    
	// Creamos la ventana
    public ListaPartidas() {
    	
    	// Adecuamos la ventana al OS
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Especificaciones de la ventana
        setTitle( "Lista Partidas" );
        setSize( 600, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // Añadimos un título
        JLabel title_label = new JLabel( "VER PARTIDAS", SwingConstants.CENTER );
        title_label.setFont( new Font( "Arial", Font.BOLD, 24 ) );

        // Designamos el nombre de las columnas de la tabla
        String[] columns = {
        		"ID"
        	,	"Anfitrión"
        	, 	"Jugadores"
        	, 	"Duración"
        	, 	"Fecha"
        	, 	"Estado"
        	,	""
        };

        // Insertamos los datos de la tabla
        Object[][] data = {
        		{"Partida 1", "Usuario 1", 4, "30'", "13-04 16:00 pm", "En curso", "Seleccionar"}
            , 	{"Partida 2", "Usuario 2", 3, "15'", "16-04 15:00 pm", "En espera", "Seleccionar"}
            ,	{"Partida 3", "Usuario 5", 2, "25'", "12-04 11:00 am", "Finalizada", "Seleccionar"}
        };

        // Creamos una plantilla para la tabla
        DefaultTableModel template = new DefaultTableModel( data, columns );
        JTable table = new JTable();
        table.setModel( template );
        
        // Contenedor
        JScrollPane scroll_pane = new JScrollPane( table );
        scroll_pane.setBorder( BorderFactory.createEmptyBorder( 20, 20, 20, 20 ) );

        // Añadimos los componentes a la ventana
        add( title_label, BorderLayout.NORTH );
        add( scroll_pane, BorderLayout.CENTER );
    }
    
    // Ejecutamos la ventana
    public static void main(String[] args) {
    	
    	// Evitamos el Event Dispatch
		java.awt.EventQueue.invokeLater( new Runnable() {
			
			public void run() {
				
				// Abrimos la ventana
	            ListaPartidas window = new ListaPartidas();
	    		window.setLocationRelativeTo(null);
	            window.setVisible(true);
			}
        });
    }
}
