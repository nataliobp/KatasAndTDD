package test.java.com.natalio.bankkata;

import main.java.com.natalio.bankkata.ValidationPrinter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ValidationPrinterTest {
    @Test
    public void whenTheNumberIsRightPrintOnlyTheNumber() throws Exception {
        assertEquals("000000051", ValidationPrinter.printResultOf("" +
            " _  _  _  _  _  _  _  _    \n" +
            "| || || || || || || ||_   |\n" +
            "|_||_||_||_||_||_||_| _|  |\n"));
    }

    @Test
    public void whenNumberIsWrongPrintNumberAndERR() throws Exception {
        assertEquals("111111111 ERR", ValidationPrinter.printResultOf("" +
            "                           \n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "  |  |  |  |  |  |  |  |  |\n"));
    }

    @Test
    public void whenADigitIsIllegiblePrintILL() throws Exception {
        assertEquals("49006771? ILL", ValidationPrinter.printResultOf("" +
            "    _  _  _  _  _  _     _ \n" +
            "|_||_|| || ||_   |  |  | _ \n" +
            "  | _||_||_||_|  |  |  | _|\n"));

        assertEquals("1234?678? ILL", ValidationPrinter.printResultOf("" +
            "    _  _     _  _  _  _  _ \n" +
            "  | _| _||_| _ |_   ||_||_|\n" +
            "  ||_  _|  | _||_|  ||_| _ \n"));
    }
}
