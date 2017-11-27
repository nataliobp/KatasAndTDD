package test.java.com.natalio.arraysleftrotation;

import main.java.com.natalio.arraysleftrotation.ArraysLeftRotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ArraysLeftRotationTest {
    @Test
    public void testRotateOneElement() throws Exception {
        assertEquals("2 3 1", ArraysLeftRotation.rotate(new int[]{1,2,3}, 1));
        assertEquals("2 3 4 5 6 7 1", ArraysLeftRotation.rotate(new int[]{1,2,3,4,5,6,7}, 1));
    }

    @Test
    public void testRotateTwoElements() throws Exception {
        assertEquals("3 1 2", ArraysLeftRotation.rotate(new int[]{1,2,3}, 2));
        assertEquals("3 4 5 1 2", ArraysLeftRotation.rotate(new int[]{1,2,3,4,5}, 2));
    }
}
