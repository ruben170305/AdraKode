package model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelTest {
    private Model model;
    private Connection conn;

    @BeforeEach
    public void setUp() {
        model = new Model();
        conn = model.get_connection();
    }

    @AfterEach
    public void tearDown() {
        model.close_connection(conn);
    }

    @Test
    public void testObtenerConexion() {
        assertNotNull(conn, "La conexión no debería ser nula");
    }

    @Test
    public void testCerrarConexion() {
        model.close_connection(conn);
        assertThrows(SQLException.class, () -> {
            conn.createStatement().executeQuery("SELECT 1");
        }, "La conexión debería estar cerrada");
    }

    @Test
    public void testConsultaModelo() {
        String query = "SELECT 1";
        try {
            ResultSet rs = model.Model_query(query);
            assertTrue(rs.next(), "El ResultSet debería tener al menos una fila");
            assertEquals(1, rs.getInt(1), "El resultado de 'SELECT 1' debería ser 1");
        } catch (SQLException e) {
            fail("No debería lanzarse SQLException: " + e.getMessage());
        }
    }
}
