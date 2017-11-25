package test.java.com.natalio.xmastree;

import main.java.com.natalio.xmastree.XmasTree;
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
