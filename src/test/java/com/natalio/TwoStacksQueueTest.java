package test.java.com.natalio;

import main.java.com.natalio.TwoStacksQueue.MyQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TwoStacksQueueTest {
    @Test
    public void lastElementShouldBe14() throws Exception {
        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(42);
        q.dequeue();
        q.enqueue(14);
        int peek1 = q.peek();
        q.enqueue(28);
        int peek2 = q.peek();
        q.enqueue(60);
        q.enqueue(78);
        q.dequeue();
        q.dequeue();

        assertEquals(14, peek1);
        assertEquals(14, peek2);
    }
}
