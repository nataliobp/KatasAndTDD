package test.java.com.natalio.supermarketqueue;

import main.java.com.natalio.supermarketqueue.SuperMarketQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class SuperMarketQueueTest {

    @Test
    public void testOneClientOneTillEqualsTheClientTime() throws Exception {
        assertEquals(5, SuperMarketQueue.solveSuperMarketQueue(new int[]{5}, 1));
    }

    @Test
    public void testTwoClientsOneTillEqualsTheClientAddedTime() throws Exception {
        assertEquals(12, SuperMarketQueue.solveSuperMarketQueue(new int[]{5, 7}, 1));
    }

    @Test
    public void testTwoClientsTwoTillEqualsTheBiggerClientTime() throws Exception {
        assertEquals(7, SuperMarketQueue.solveSuperMarketQueue(new int[]{5, 7}, 2));
    }

    @Test
    public void testClientsEqualsTillsThenTheBiggerClientTim1e() throws Exception {
        assertEquals(12, SuperMarketQueue.solveSuperMarketQueue(new int[]{5, 7, 12, 1, 6}, 5));
    }

    @Test
    public void testWhenMoreClientsThanTills() throws Exception {
        assertEquals(11, SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 5, 9}, 2));
        assertEquals(12, SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 5, 9, 7}, 2));
        assertEquals(9, SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 5, 9, 7}, 3));
    }

    @Test
    public void when2TillsEndAtSameTime() throws Exception {
        assertEquals(16, SuperMarketQueue.solveSuperMarketQueue(new int[]{2, 11, 9, 5}, 2));
    }
    @Test
    public void testNormalCondition() {
        assertEquals(9, SuperMarketQueue.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, SuperMarketQueue.solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, SuperMarketQueue.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

}
