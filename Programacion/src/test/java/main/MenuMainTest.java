package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import views.Menu;

public class MenuMainTest {

    @Test
    public void testBoot() {
        Menu menu = MenuMain.boot(true);  // Iniciar menu
        assertNotNull(menu, "El menú no debería ser nulo");
        assertTrue(menu.isGameMaster(), "El menú debería estar inicializado");
    }

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> {
            String[] args = {};
            MenuMain.main(args);
        }, "El método main debería ejecutarse sin lanzar excepciones");
    }
}
