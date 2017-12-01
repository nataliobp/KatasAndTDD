package test.java.com.natalio.fibonacci;

import main.java.com.natalio.fibonacci.Fibonacci;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FibonacciTest {
    @Test
    public void test0() throws Exception {
        assertEquals(0, Fibonacci.fibonacci(0));
    }

    @Test
    public void test1() throws Exception {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(1, Fibonacci.fibonacci(2));
    }
}
