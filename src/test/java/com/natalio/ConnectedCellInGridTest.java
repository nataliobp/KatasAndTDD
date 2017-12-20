package test.java.com.natalio;

import main.java.com.natalio.ConnectedCellInGrid.Grid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ConnectedCellInGridTest {
    @Test
    public void gridOf4x4Returns5() throws Exception {
        int[][] input = new int[][]{{1,1,0,0}, {0,1,1,0}, {0,0,1,0}, {1,0,0,0}};
        Grid grid = new Grid(4, 4, input);

        assertEquals(5, grid.numCellsInLargestRegion());
    }
}
