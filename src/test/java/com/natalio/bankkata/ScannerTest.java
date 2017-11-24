package test.java.com.natalio.bankkata;

import main.java.com.natalio.bankkata.Scanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ScannerTest {
    @Test
    public void scan1() throws Exception {
        assertEquals(1, Scanner.scanNumber("" +
            "   \n" +
            "  |\n" +
            "  |\n"));
    }

    @Test
    public void scan12() throws Exception {
        assertEquals(12, Scanner.scanNumber(
            "    _ \n" +
            "  | _|\n" +
            "  ||_ \n"
        ));
    }

    @Test
    public void scan123456789() throws Exception {
        assertEquals("1234560789", Scanner.scanNumber("" +
            "    _  _     _  _  _  _  _  _ \n" +
            "  | _| _||_||_ |_ | |  ||_||_|\n" +
            "  ||_  _|  | _||_||_|  ||_| _|\n"));
    }
}
