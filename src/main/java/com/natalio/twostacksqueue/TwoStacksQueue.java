package main.java.com.natalio.twostacksqueue;

import java.util.*;

public class TwoStacksQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<T> {
        private final Deque<T> stackedOrder = new ArrayDeque<>();
        private final Deque<T> queuedOrder = new ArrayDeque<>();
        private T oldestElement;

        public void enqueue(T element) {
            transferBetweenStacks(queuedOrder, stackedOrder);
            stackedOrder.push(element);
            oldestElement = oldestElement == null ? element : oldestElement;
        }

        public void dequeue() {
            transferBetweenStacks(stackedOrder, queuedOrder);
            queuedOrder.pop();
            oldestElement = queuedOrder.isEmpty() ? null : queuedOrder.peek();
        }

        public T peek() {
            return oldestElement;
        }

        private void transferBetweenStacks(Deque<T> original, Deque<T> target) {
            while (!original.isEmpty()){
                target.push(original.pop());
            }
        }
    }
}

