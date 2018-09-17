import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void multiplicationTest() {
        int[] testData = {2, 2, -2, 2, 2, -2, -2, -2, 0, 2, 2, 0, 0, 0};
        int[] testResult = {4, -4, -4, 4, 0, 0, 0};
        for (int i = 0; i < testResult.length; i++) {
            assertEquals(testResult[i], Main.multiplication(testData[i * 2], testData[i * 2 + 1]));
        }
    }
}