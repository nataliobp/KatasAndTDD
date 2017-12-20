package main.java.com.natalio;

import java.util.Scanner;

public class FindRunningMedian {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MinHeap minHeap = new MinHeap(n);
        MaxHeap maxHeap = new MaxHeap(n);
        double median = 0;
        for (int a_i = 0; a_i < n; a_i++) {
            median = getMedian(in.nextInt(), median, minHeap, maxHeap);
            System.out.println(median);
        }
    }

    private static double getMedian(int value, double median, MinHeap minHeap, MaxHeap maxHeap) {

        if (value >= median) {
            minHeap.insert(value);
            if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.insert(minHeap.delMin());
            }
        } else {
            maxHeap.insert(value);
            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.insert(maxHeap.delMax());
            }
        }

        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2D;
        }

        return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : maxHeap.peek();
    }

    public static abstract class Heap {
        protected final int[] elements;
        protected int numElements = 0;

        public Heap(int size) {
            elements = new int[size + 1];
        }

        public void insert(int element) {
            elements[++numElements] = element;
            swim(element);
        }

        public int peek() {
            return elements[1];
        }

        protected void swap(int pos1, int pos2) {
            int aux = elements[pos1];
            elements[pos1] = elements[pos2];
            elements[pos2] = aux;
        }

        public int size() {
            return numElements;
        }

        protected int delTop() {
            int element = elements[1];
            elements[1] = elements[numElements--];
            elements[numElements + 1] = 0;
            sink(1);

            return element;
        }

        protected abstract void swim(int element);

        protected abstract void sink(int pos);
    }

    public static class MinHeap extends Heap {

        public MinHeap(int size) {
            super(size);
        }

        protected void swim(int element) {
            for (int pos = numElements; ((pos / 2) > 0) && (element < elements[pos / 2]); pos /= 2) {
                swap(pos, pos / 2);
            }
        }

        public int delMin() {
            return delTop();
        }

        protected void sink(int pos) {

            while (2 * pos <= numElements) {
                int children = 2 * pos;

                if (children < numElements && elements[children + 1] < elements[children]) {
                    children++;
                }

                if (elements[pos] < elements[children]) {
                    break;
                }

                swap(pos, children);
                pos = children;
            }

        }
    }

    public static class MaxHeap extends Heap {

        public MaxHeap(int size) {
            super(size);
        }

        protected void swim(int element) {
            for (int pos = numElements; ((pos / 2) > 0) && (element > elements[pos / 2]); pos /= 2) {
                swap(pos, pos / 2);
            }
        }

        public int delMax() {
            return delTop();
        }

        protected void sink(int pos) {

            while (2 * pos <= numElements) {
                int children = 2 * pos;

                if (children < numElements && elements[children + 1] > elements[children]) {
                    children++;
                }

                if (elements[pos] > elements[children]) {
                    break;
                }

                swap(pos, children);
                pos = children;
            }
        }
    }
}
