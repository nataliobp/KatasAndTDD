package test.java.com.natalio.balancedbrackets;

import main.java.com.natalio.balancedbrackets.BalancedBrackets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BalancedBracketsTest {
    @Test
    public void testBalanced() throws Exception {
        assertTrue(BalancedBrackets.isBalanced("{[()]}"));
        assertTrue(BalancedBrackets.isBalanced("{{[[(())]]}}"));
    }

    @Test
    public void testNotBalanced() throws Exception {
        assertFalse(BalancedBrackets.isBalanced("{[(])}"));
    }
}
