package test.java.com.natalio;

import main.java.com.natalio.RansomNote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RansomNoteTest {
    @Test
    public void testDifferentWords() throws Exception {
        assertTrue(RansomNote.evaluate("give me one grand today night".split(""), "give one grand today".split("")));
    }

    @Test
    public void testRepeatedWords() throws Exception {
        assertTrue(RansomNote.evaluate("give me one grand today night one".split(""), "give one one grand today".split("")));
    }

    @Test
    public void anInvalidNote() throws Exception {
        assertFalse(RansomNote.evaluate("two times three is not four".split(""), "two times two is four".split("")));
    }
}
