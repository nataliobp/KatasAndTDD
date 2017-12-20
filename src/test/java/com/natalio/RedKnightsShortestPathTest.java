package test.java.com.natalio;

import main.java.com.natalio.RedKnightsShortestPath;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RedKnightsShortestPathTest {

    @Test
    public void printShortestPath() {
        List<String> result = RedKnightsShortestPath.shortest(7,6,6,0,1);
        assertEquals(result.get(0), "UL");
        assertEquals(result.get(1), "UL");
        assertEquals(result.get(2), "UL");
        assertEquals(result.get(3), "L");
    }
}