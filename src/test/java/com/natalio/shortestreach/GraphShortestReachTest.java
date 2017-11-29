package test.java.com.natalio.shortestreach;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import shortestreach.GraphShortestReach.Graph;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class GraphShortestReachTest {
    @Test
    public void testOneLevel() throws Exception {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        int[] result =  graph.shortestReach(0);

        assertTrue(Arrays.equals(new int[]{0,6,6},result));
    }

    @Test
    public void testTwoLevels() throws Exception {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        int[] result =  graph.shortestReach(0);

        assertTrue(Arrays.equals(new int[]{0,6,6,12,12},result));
    }

    @Test
    public void tesFourLevels() throws Exception {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(5, 7);
        int[] result =  graph.shortestReach(0);

        assertTrue(Arrays.equals(new int[]{0,6,6,12,12,18,18,24},result));
    }
}
