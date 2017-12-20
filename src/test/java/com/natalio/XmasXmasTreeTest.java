package test.java.com.natalio;

import main.java.com.natalio.XmasTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XmasXmasTreeTest {


    @Test
    public void testOneLine(){
        assertEquals(".\n", XmasTree.treeBuilder(1));
    }

    @Test
    public void testTwoLines(){
        assertEquals(" .\n...\n", XmasTree.treeBuilder(2));
    }

    @Test
    public void testThreeLines(){
        assertEquals("  .\n ...\n.....\n", XmasTree.treeBuilder(3));
    }
}
