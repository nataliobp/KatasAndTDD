package test.java.com.natalio.isabst;

import main.java.com.natalio.isabst.IsABST;
import main.java.com.natalio.isabst.IsABST.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class IsABSTTest {
    private Node eight;
    private Node twelve;
    private Node ten;
    private Node six;
    private Node nine;
    private Node eleven;
    private Node thirteen;
    private Node four;
    private Node two;
    private Node one;
    private Node three;
    private Node five;
    private Node seven;

    @Before
    public void setUp() throws Exception {
        eight = new Node(8);
        eight.data = 8;

        twelve = new Node(12);
        twelve.data = 12;

        ten = new Node(10);
        ten.data = 10;

        six = new Node(6);
        six.data = 6;

        nine = new Node(9);
        nine.data = 9;

        eleven = new Node(11);
        eleven.data=11;

        thirteen = new Node(13);
        thirteen.data = 13;

        four = new Node(4);
        four.data = 4;

        two = new Node(2);
        two.data = 2;

        one = new Node(1);
        one.data = 1;

        three = new Node(3);
        three.data = 3;

        five = new Node(5);
        five.data = 5;

        seven = new Node(7);
        seven.data = 7;
    }

    @Test
    public void threeNodesTreeThatAreABST() throws Exception {
        ten.left = eight;
        ten.right = twelve;
        assertTrue(new IsABST().checkBST(ten));
    }

    @Test
    public void threeNodesTreeThatAreNotIsABST() throws Exception {
        ten.right = eight;
        ten.left = twelve;
        assertFalse(new IsABST().checkBST(ten));
    }

    @Test
    public void sevenNodesTreeThatAreABST() throws Exception {
        three.left=two;
        three.right = six;

        two.left = one;
        two.right = four;

        six.left = five;
        six.right = seven;

        assertFalse(new IsABST().checkBST(three));
    }

}
