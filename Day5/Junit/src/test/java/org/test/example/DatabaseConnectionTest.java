package org.test.example;
import org.example.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DatabaseConnectionTest {
    private DatabaseConnection dbConnection;
    @BeforeEach
    void setup() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }
    @AfterEach
    void teardown() {
        dbConnection.disconnect();
    }
    @Test
    void testCod() {
        assertTrue(dbConnection.isConnected());
    }
    @Test
    void testConnectionBehavior() {
        assertTrue(dbConnection.isConnected());
    }
}

