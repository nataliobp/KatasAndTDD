package test.java.com.natalio.makinganagramas;

import main.java.com.natalio.makinganagrams.Anagrams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class AnagramsTest {
    @Test
    public void allLettersAreDifferent() throws Exception {
        assertEquals(4, Anagrams.numberNeeded("cde", "abc"));
    }

    @Test
    public void aLetterIsTwice() throws Exception {
        assertEquals(5, Anagrams.numberNeeded("cde", "abcc"));
    }
}
