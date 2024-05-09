package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import views.*;
import model.*;

public class VerPartidaListener implements ActionListener {
	private Menu menu;
	private Home home;
	
	
	public VerPartidaListener(Home home, Menu menu) {
		this.menu = menu;
		this.home = home;
	}


	public VerPartidaListener(EditarPersonaje ePersonaje, Menu ventanaPpal, Home home2) {
        //TODO Auto-generated constructor stub
    }


    @Override
	public void actionPerformed(ActionEvent ae) {
		if ( ae.getActionCommand().equals("JUGAR") ) {
            this.menu.cargarPanel(home);
            //this.ep.hacerVisible();
        }
	}

	public void get_data() {

		// Creamos una conexión con MySQL
		Model mysql = new Model();
		mysql.getConexion();

		try ( ResultSet rs = mysql.Model_query( "select * from miembro" ) ) {
			System.out.println( rs );
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

}
