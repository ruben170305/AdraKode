package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	public VerPersonajesListener(Menu menu, Home home, Model mysql, Usuario user, EditarPersonaje ep, VerPersonajes vp) {
		super( menu, home, mysql );
		this.user = user;
		this.vp = vp;
		this.ep = ep;
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
	            mysql.editar_personaje(Integer.parseInt(vp.getIdLbl().getText()), user, ep, esMaster, menu);
	        } else if (buttonName.equals("BORRAR")) {
	            if (menu.mostrarMensajeConfirmborrado()) {
	                mysql.borrar_personaje(user, vp);
	                menu.cargarPanel(home);
	            }
	        }

	    } else if (source instanceof JComboBox) {
	        // Capturamos el ComboBox y el Item seleccionado
	        JComboBox<?> comboBox = (JComboBox<?>) source;
	        String selected_index = (String) comboBox.getSelectedItem();

	        if (selected_index != null) {
	            // Capturamos los datos de la DB
	            ArrayList<Personaje> personajes = mysql.get_personajes(user);

	            for (Personaje personaje : personajes) {
	                String nombre = personaje.getNombre();
	                if (selected_index.equals(nombre)) {
	                    vp.getLblClase().setText(personaje.getClase());
	                    vp.getLblRaza().setText(personaje.getRaza());
	                    vp.getIdLbl().setText(String.valueOf(personaje.getCod()));
	                    vp.getPbExp().setValue(personaje.getExpe());
	                    vp.getPbFuerza().setValue(personaje.getFuerza());
	                    vp.getPbDestreza().setValue(personaje.getDestreza());
	                    vp.getPbConstitucion().setValue(personaje.getConstitucion());
	                    vp.getPbInteligencia().setValue(personaje.getInteligencia());
	                    vp.getPbSabiduria().setValue(personaje.getSabiduria());
	                    vp.getPbCarisma().setValue(personaje.getCarisma());

	                    // Sale del bucle una vez que se encuentra el ítem
	                    break;
	                }
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
	    ArrayList<Personaje> personajes;
	    
	    if (esMaster) {
	        personajes = mysql.get_personajes_all();
	    } else {
	        personajes = mysql.get_personajes(user);
	    }
	    
	    for (Personaje personaje : personajes) {
	        vp.getIdLbl().setText(String.valueOf(personaje.getCod()));
	        vp.getComboBoxSeleccionar().addItem(personaje.getNombre());
	    }
	}


}