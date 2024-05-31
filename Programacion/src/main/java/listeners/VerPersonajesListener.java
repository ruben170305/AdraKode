package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;

import model.Model;
import model.Personaje;
import model.Usuario;
import views.*;

public class VerPersonajesListener extends Listener implements ActionListener {

	private EditarPersonaje ep;
	private Usuario user;
	private VerPersonajes vp;
	private boolean esMaster;

	// Constructor del Listener
	public VerPersonajesListener(Menu menu, Home home, Model mysql, Usuario user, VerPersonajes vp) {
		super( menu, home, mysql );
		this.user = user;
		this.vp = vp;
	}

	// Constructor del Listener
	public VerPersonajesListener(EditarPersonaje ep, Menu menu, Home home, Model mysql, Usuario user, CrearPersonaje cPersonaje,
			VerPersonajes vp, Personaje personaje, boolean esMaster) {
		super( menu, home, mysql );
		this.ep = ep;
		this.user = user;
		this.vp = vp;
		this.esMaster = esMaster;
	}

	/**
	 * Listener del botón de editar personaje. Redigirimos a la ventana dependiendo
	 * del boton
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();

		if (source instanceof JButton) {
			JButton sourceButton = (JButton) source;
			String buttonName = sourceButton.getName();

			// Dependiendo del texto del botón realizamos una acción u otra
			if (ae.getActionCommand().equals("SELECCIONAR") || ae.getActionCommand().equals("VOLVER")) {
				menu.cargarPanel(home);
			} else if (buttonName.equals("EDITAR")) {
				mysql.editar_personaje( Integer.parseInt( vp.getIdLbl().getText() ), user, ep, esMaster, menu );
			} else if (buttonName.equals("BORRAR")) {
				if (menu.mostrarMensajeConfirmborrado()) {
					mysql.borrar_personaje( user, vp );
					menu.cargarPanel(home);
				}
			}

		} else if (source instanceof JComboBox) {

			// Capturamos el ComboBox y el Item seleccionado
			JComboBox<?> comboBox = (JComboBox<?>) source;
			String selected_index = (String) comboBox.getSelectedItem();

			if (selected_index != null) {

				// Capturamos los datos de la DB
				ResultSet rs = mysql.get_personajes( user );

				try {
					while (rs.next()) {

						String nombre = rs.getString("nombre");
						if (selected_index.equals(nombre)) {

							vp.getLblClase().setText(rs.getString("clase"));
							vp.getLblRaza().setText(rs.getString("raza"));
							vp.getIdLbl().setText(String.valueOf( rs.getInt( "cod" ) ));
							vp.getPbExp().setValue(rs.getInt("expe"));
							vp.getPbFuerza().setValue(rs.getInt("fuerza"));
							vp.getPbDestreza().setValue(rs.getInt("destreza"));
							vp.getPbConstitucion().setValue(rs.getInt("constitucion"));
							vp.getPbInteligencia().setValue(rs.getInt("inteligencia"));
							vp.getPbSabiduria().setValue(rs.getInt("sabiduria"));
							vp.getPbCarisma().setValue(rs.getInt("carisma"));

							// Sale del bucle una vez que se encuentra el ítem
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metodo que asigna el listener
	 * 
	 * @param listener Recibe el listener con el que quieres asignar los objetos
	 */

	public void cargarDatosEnComboBox() {
		vp.getComboBoxSeleccionar().removeAllItems();
		ResultSet rs = null;
		if (esMaster) {
			rs = mysql.get_personajes_all();
		} else {
			rs = mysql.get_personajes( user );
		}
		
		try {
			while (rs.next()) {
				vp.getIdLbl().setText( String.valueOf( rs.getInt( "cod" ) ) );
				vp.getComboBoxSeleccionar().addItem(rs.getString("nombre"));
				
				break;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}