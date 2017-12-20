package test.java.com.natalio;

import main.java.com.natalio.TheSalesman;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TheSalesmanTest {
    @Test
    public void name() {
        int[] values = new int[]{11,6,9};
        int result = TheSalesman.minimumTime(values);

        assertEquals(5, result);
    }
    @Test
    public void name3() {
        int[] values = new int[]{11};
        int result = TheSalesman.minimumTime(values);

        assertEquals(0, result);
    }

    @Test
    public void name4() {
        int[] values = new int[]{2,6,13,16,21,28};
        int result = TheSalesman.minimumTime(values);

        assertEquals(26, result);
    }

}