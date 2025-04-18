package main;

import java.awt.EventQueue;
import model.*;

import views.*;
import listeners.*;
import model.Personaje;
import model.Usuario;

public class MenuMain {
    
    // Inicializamos la ventana principal y la ventana del Home
    static Menu menu;
    static Home home;
    static Listener list;
    
    // Instanciamos el modelo e iniciamos sesión
    static Model mysql = new Model();
    static { mysql.get_connection(); }
    
    static Usuario user;
    static Personaje personaje;
    static CrearPersonaje cPersonaje;

    // Ventanas de creación y edición de partidas
    static CrearPartida cPartida;
    static EditarPartida ePartida;

    // Listeners para ver partidas
    static VerPartidaMasterListener vPartidasMasterListener;
    static VerPartidasMaster vPartidasMaster;

    static VerPartidaListener vPartidasListener;
    static VerPartidas vPartidas;
    
    static PartidaIniciadaListener pIniciadaListener;
    static PartidaIniciada pIniciada;

    // Ventanas y listeners de personajes
    static EditarPersonaje ePersonaje;
    static VerPersonajes vPersonajes;

    static EditarPersonajesListener ePersonajesListener;
    static VerPersonajesListener vPersonajesListener;

    static CrearPersonajeListener cPersonajeListener;

    // Ventana de login
    static VentanaPrincipalLogin login;
    static RegistroMiembro registro;

    public static void main( String[] args ) {
        EventQueue.invokeLater( new Runnable() {

            @Override
            public void run() {
                // Inicializamos solo lo necesario para el login
                user = new Usuario();
                login = new VentanaPrincipalLogin( user );
                registro = new RegistroMiembro(login);
                
                // Configuramos el listener para el login
                LoginListener login_listener = new LoginListener( login, registro );
                login.setListener( login_listener );
                RegistroListener registro_listener = new RegistroListener(registro, login);
                registro.setListener(registro_listener);

                // Hacemos visible el login
                login.make_visible();
                registro.dispose();
            }
        });
    }

    /**
     * Método que inicializa la ventana principal (Menu) este se encarga de decir al menu si es game master o no.
     * Se llama desde el loginlistener para que cuando se cierre el login se ejecuten estas sentencias y se actualice
     * correctamente el menu
     * @param esMaster Recibe true or false dependiendo del checkbox de login
     * @return Devuelve Menu ventanaPpal para asignar todos los listeners a la ventana creada
     */
    public static Menu boot( boolean esMaster ) {
        // Creamos la ventana principal y el Home
        menu = new Menu( esMaster ? "AdraKode Master" : "AdraKode", esMaster );
        home = new Home();
        list = new Listener( menu, home, mysql );
        personaje = new Personaje( user );
        cPersonaje = new CrearPersonaje( menu );

        // Ventanas de creación y edición de partidas
        cPartida = new CrearPartida( user );
        ePartida = new EditarPartida();

        // Listeners para ver partidas
        pIniciadaListener = new PartidaIniciadaListener( menu, home, mysql, user );
        pIniciada = new PartidaIniciada( user );
        
        vPartidasMaster = new VerPartidasMaster();
        vPartidasMasterListener = new VerPartidaMasterListener( vPartidasMaster, ePartida, menu, home, mysql, user );

        vPartidasListener = new VerPartidaListener( menu, home, mysql );
        vPartidas = new VerPartidas( user );

        // Ventanas y listeners de personajes
        ePersonaje = new EditarPersonaje(esMaster);
        vPersonajes = new VerPersonajes( user, esMaster );
        
        vPersonajesListener = new VerPersonajesListener( ePersonaje, menu, home, mysql, user, cPersonaje, vPersonajes, personaje, esMaster );
        ePersonajesListener = new EditarPersonajesListener( menu, home, mysql, ePersonaje, vPersonajes, user );
        cPersonajeListener = new CrearPersonajeListener( menu, home, mysql, cPersonaje, user, vPersonajes );

        // Creamos la ventana y cargamos el panel
        menu.setGameMaster( esMaster );
        cPersonaje.inicializarComponentes();
        menu.crearMenu();
        menu.cargarPanel( home );
        
        // Creamos el listener del menú
        PMenuListener listener = new PMenuListener(
        		menu
            , 	home
            ,	cPersonaje
            ,	ePersonaje
            ,	vPersonajes
            ,	cPartida
            ,	ePartida
            ,	vPartidas
            ,	vPartidasMaster
            ,	login
        );

        // Dependiendo de que el usuario inicie sesión como Game Master, mostramos un menú diferente
        if ( esMaster ) {
            CrearPartidaListener cPartidaListener = new CrearPartidaListener( menu, home, mysql, cPartida, esMaster, user );
            EditarPartidaListener ePartidaListener = new EditarPartidaListener( menu, home, mysql, user, ePartida );

            // Vinculación de listeners
            cPartida.setListener( cPartidaListener );
            ePartida.setListener( ePartidaListener );
            vPartidasMaster.setListener( vPartidasMasterListener );
        } else {
            VerPartidaListener ver_partidas_listener = new VerPartidaListener( menu, home, mysql, pIniciada, vPartidas, user );
            vPartidas.setListener( ver_partidas_listener );
        }

        // Vinculación de Listeners
        cPersonaje.setListener( cPersonajeListener );
        ePersonaje.setListener( ePersonajesListener );
        vPersonajes.setListener( vPersonajesListener );

        // Vinculamos el listener de la ventana principal a su ventana
        menu.setListener( listener );

        return menu;
    }
}