package test.java.com.natalio.icecreamparlor;

import main.java.com.natalio.icecreamparlor.IceCreamParlor;
import main.java.com.natalio.icecreamparlor.IceCreamParlor.Flavour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class IceCreamParlorTest {
    @Test
    public void aTripWithMoneyEquals4() throws Exception {
        int[] input = new int[]{1,4,5,3,2};
        Flavour[] allFlavours = IntStream.range(0, input.length)
            .mapToObj(i -> new Flavour(i+1, input[i]))
            .toArray(Flavour[]::new);

        Integer[] result = Arrays.stream(IceCreamParlor.getFlavours(4, allFlavours))
            .map(f -> f.key)
            .toArray(Integer[]::new);

        assertTrue(Arrays.equals(new Integer[]{1,4}, result));
    }
}
