package test.java.com.natalio.bankkata;

import main.java.com.natalio.bankkata.Fixer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FixerTest {

    @Test
    public void testWithOneSolution() throws Exception {
        assertEquals("711111111", Fixer.fix("" +
            "                           \n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "  |  |  |  |  |  |  |  |  |\n"));

        assertEquals("777777177", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            "  |  |  |  |  |  |  |  |  |\n" +
            "  |  |  |  |  |  |  |  |  |\n"));

        assertEquals("200800000", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            " _|| || || || || || || || |\n" +
            "|_ |_||_||_||_||_||_||_||_|\n"));

        assertEquals("333393333", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            " _| _| _| _| _| _| _| _| _|\n" +
            " _| _| _| _| _| _| _| _| _|\n"));
    }

    @Test
    public void testWithSeveralSolutions() throws Exception {
        assertEquals("888888888 AMB ['888886888', '888888880', '888888988']", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            "|_||_||_||_||_||_||_||_||_|\n"));

        assertEquals("555555555 AMB ['559555555', '555655555']", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
            " _| _| _| _| _| _| _| _| _|\n"));

        assertEquals("666666666 AMB ['686666666', '666566666']", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
            "|_||_||_||_||_||_||_||_||_|"));

        assertEquals("999999999 AMB ['993999999', '999959999', '899999999']", Fixer.fix("" +
            " _  _  _  _  _  _  _  _  _ \n" +
            "|_||_||_||_||_||_||_||_||_|\n" +
            " _| _| _| _| _| _| _| _| _|\n"));

    }
}
