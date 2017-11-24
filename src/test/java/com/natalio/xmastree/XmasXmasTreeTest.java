package test.java.com.natalio.xmastree;

import main.java.com.natalio.xmastree.XmasTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class XmasXmasTreeTest {


    @Test
    public void oneShouldPrintOneDot(){
        assertEquals(".\n", XmasTree.treeWritter(1));
        assertEquals(" .\n...\n", XmasTree.treeWritter(2));
        assertEquals("  .\n ...\n.....\n", XmasTree.treeWritter(3));
    }
}
