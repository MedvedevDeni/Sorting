import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void multiplicationTest() {
        assertEquals(4, Main.multiplication(2, 2));
        assertEquals(-4, Main.multiplication(-2, 2));
        assertEquals(-4, Main.multiplication(2, -2));
        assertEquals(4, Main.multiplication(-2, -2));
        assertEquals(0, Main.multiplication(0, 2));
        assertEquals(0, Main.multiplication(2, 0));
        assertEquals(0, Main.multiplication(0, 0));
    }
}