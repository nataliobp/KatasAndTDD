package test.java.com.natalio.bankkata;

import main.java.com.natalio.bankkata.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ValidatorTest {

    @Test
    public void testSumOfAccountNumbers() throws Exception {
        assertEquals(45, Validator.calculateSum("111111111"));
        assertEquals(231, Validator.calculateSum("345882865"));
    }

    @Test
    public void testValidChecksum() throws Exception {
        assertTrue(Validator.validate("345882865"));
        assertFalse(Validator.validate("111111111"));
    }
}
