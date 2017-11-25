package test.java.com.natalio.bankkata;

import main.java.com.natalio.bankkata.Checker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class CheckerTest {

    @Test
    public void testSumOfAccountNumbers() throws Exception {
        assertEquals(45, Checker.calculateSum("111111111"));
        assertEquals(231, Checker.calculateSum("345882865"));
    }

    @Test
    public void testValidChecksum() throws Exception {
        assertTrue(Checker.checkSum("" +
            " _  _  _  _  _  _  _  _    \n" +
            "| || || || || || || ||_   |\n" +
            "|_||_||_||_||_||_||_| _|  |\n"));

        assertFalse(Checker.checkSum("" +
            "                           \n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "  |  |  |  |  |  |  |  |  |\n"));
    }
}
