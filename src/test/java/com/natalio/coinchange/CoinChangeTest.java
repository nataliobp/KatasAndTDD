package test.java.com.natalio.coinchange;


import main.java.com.natalio.coinchange.CoinChange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CoinChangeTest {
    @Test
    public void testOneCoin() throws Exception {
        assertEquals(1, CoinChange.calculateCombinations(new int[]{1}, 1));
    }

    @Test
    public void testTwoCoins() throws Exception {
        assertEquals(3, CoinChange.calculateCombinations(new int[]{10,20}, 40));
    }

    @Test
    public void testThreeCoins() throws Exception {
        assertEquals(4, CoinChange.calculateCombinations(new int[]{1,2,3}, 4));
    }

    @Test
    public void testFourCoins() throws Exception {
        assertEquals(5, CoinChange.calculateCombinations(new int[]{2,5,3,6}, 10));
    }
}
