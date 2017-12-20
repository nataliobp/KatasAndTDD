package test.java.com.natalio;

import main.java.com.natalio.MergeSortCountInversions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class MergeSortCountInversionsTest {
    @Test
    public void sort2ElementSorted() throws Exception {
        assertTrue(Arrays.equals(new int[]{10,25}, MergeSortCountInversions.mergesort(new int[]{10,25})));
    }

    @Test
    public void sort2ElementsUnsorted() throws Exception {
        assertTrue(Arrays.equals(new int[]{10,25}, MergeSortCountInversions.mergesort(new int[]{25,10})));
    }

    @Test
    public void sort3Elements() throws Exception {
        assertTrue(Arrays.equals(new int[]{5,10,25}, MergeSortCountInversions.mergesort(new int[]{25,5,10})));
    }

    @Test
    public void sort5Elements() throws Exception {
        assertTrue(Arrays.equals(new int[]{1,1,2,2,3}, MergeSortCountInversions.mergesort(new int[]{2,1,3,1,2})));
    }

    @Test
    public void count0Inversions() throws Exception {
        assertEquals(0L, MergeSortCountInversions.countInversions(new int[]{1,1,1,2,2}));
    }

    @Test
    public void count4Inversions() throws Exception {
        assertEquals(4L, MergeSortCountInversions.countInversions(new int[]{2,1,3,1,2}));
    }
}
