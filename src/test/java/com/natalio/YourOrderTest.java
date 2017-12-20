package test.java.com.natalio;

import main.java.com.natalio.YourOrder;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class YourOrderTest {
    @Test
    public void itReturnsThisIsTest(){
        assertEquals("Thi1s is2 3a T4est", YourOrder.order("is2 Thi1s T4est 3a"));
    }

    @Test
    public void itReturnsEmpty(){
        assertEquals("", YourOrder.order(""));
    }
}
