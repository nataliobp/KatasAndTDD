package test.java.com.natalio;

import main.java.com.natalio.Contacts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TriesContactsTest {
    @Test
    public void whenNoNameIsAddedContactIsEmpty() throws Exception {
        Contacts contacts = new Contacts();
        assertEquals(0, contacts.size());
    }

    @Test
    public void whenAddingpaulContactsSizeIs1() throws Exception {
        Contacts contacts = new Contacts();
        contacts.add("paul");
        assertEquals(1, contacts.size());
    }

    @Test
    public void whenAdding2NamesContactsSizeIs2() throws Exception {
        Contacts contacts = new Contacts();
        contacts.add("paul");
        contacts.add("natman");
        assertEquals(2, contacts.size());
    }

    @Test
    public void whenIsEmptyNoNameCanBeFound() throws Exception {
        Contacts contacts = new Contacts();
        assertFalse(contacts.contains("paul"));
    }

    @Test
    public void whenIsNotEmptyButNotContainsNameThenIsFalse() throws Exception {
        Contacts contacts = new Contacts();
        contacts.add("paul");
        contacts.add("natman");
        assertFalse(contacts.contains("michael"));
    }

    @Test
    public void whenIsNameExistThenNameIsFound() throws Exception {
        Contacts contacts = new Contacts();
        contacts.add("paul");
        contacts.add("natman");
        assertTrue(contacts.contains("natman"));
        assertFalse(contacts.contains("natma"));
    }

    @Test
    public void countPartials() throws Exception {
        Contacts contacts = new Contacts();
        contacts.add("paul");
        contacts.add("natman");
        assertEquals(1, contacts.countPartials("pa"));
    }

    @Test
    public void countPartialsS() throws Exception {
        Contacts contacts = new Contacts();
        contacts.add("s");
        assertEquals(1, contacts.countPartials("s"));
    }
}
