package test.java.com.natalio;

import main.java.com.natalio.StairCaseJump;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StairCaseJumpTest {
    @Test
    public void threeStepsStair() throws Exception {
        assertEquals(4, StairCaseJump.calculateJumps(3));
    }

    @Test
    public void oneStepStair() throws Exception {
        assertEquals(1, StairCaseJump.calculateJumps(1));
    }

    @Test
    public void sevenStepStair() throws Exception {
        assertEquals(44, StairCaseJump.calculateJumps(7));
    }
}
