package org.test.example;
import org.example.Exception;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class ExceptionTest {
    private Exception excep;
    @BeforeEach
    void setup(){
        excep = new Exception();
    }
    @Test
    @DisplayName("Divided by the value")
    void divide(){
        assertEquals(2,excep.div(10,5));
    }
    @Test
    @DisplayName("Divided by the 0")
    void dividedbyzero(){
        assertThrows(ArithmeticException.class,()-> excep.div(10,0));
    }
}
