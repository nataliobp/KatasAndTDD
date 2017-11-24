package test.java.com.natalio.missingletter;

import main.java.com.natalio.missingletter.MissingLetter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingLetterTest {
    @Test
    public void missingB(){
        assertEquals('B', MissingLetter.findMissingLetter(new char[]{'A', 'C'}));
    }

    @Test
    public void missingM(){
        assertEquals('M', MissingLetter.findMissingLetter(new char[]{'K', 'L', 'N', 'O', 'P'}));
    }
}
