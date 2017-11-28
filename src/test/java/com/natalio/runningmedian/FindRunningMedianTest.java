package test.java.com.natalio.runningmedian;

import main.java.com.natalio.runningmedian.FindRunningMedian.MinHeap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class FindRunningMedianTest {

    @Test
    public void whenPeekingThenInTheTopOfTheHeapIsAlwaysTheMin() throws Exception {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(25);
        assertEquals(25, minHeap.peek());
        minHeap.insert(78);
        assertEquals(25, minHeap.peek());
        minHeap.insert(50);
        assertEquals(25, minHeap.peek());
        minHeap.insert(10);
        assertEquals(10, minHeap.peek());
        minHeap.insert(2);
        assertEquals(2, minHeap.peek());
    }

    @Test
    public void whenDeletingThenInTheTopOfTheHeapIsAlwaysTheMin() throws Exception {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(25);
        minHeap.insert(78);
        minHeap.insert(50);
        minHeap.insert(10);
        minHeap.insert(2);

        assertEquals(2, minHeap.delMin());
        assertEquals(10, minHeap.delMin());
        assertEquals(25, minHeap.delMin());
        assertEquals(50, minHeap.delMin());
        assertEquals(78, minHeap.delMin());
    }
}
