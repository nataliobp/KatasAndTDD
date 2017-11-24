package main.java.com.natalio.supermarketqueue;

import java.util.*;

// There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate
// the total time required for all the customers to check out!
//
// The function has two input variables:
//
// customers: an array (list in python) of positive integers representing the queue. Each integer represents
// a customer, and its value is the amount of time they require to check out.
// n: a positive integer, the number of checkout tills.
// The function should return an integer, the total time required.

public class SuperMarketQueue {
    public static int solveSuperMarketQueue(int[] customers, int n) {

        int[] tills = Arrays.copyOfRange(customers, 0, n);
        int time = 0;
        Deque<Integer> emptyTills = new ArrayDeque<>();

        for (int nextCostumer = tills.length; nextCostumer < customers.length;){

            while (emptyTills.isEmpty()){
                decreaseTills(tills, emptyTills);
                time++;
            }

            while (nextCostumer < customers.length && !emptyTills.isEmpty()){
                tills[emptyTills.pop()] = customers[nextCostumer++];
            }
        }

        return Arrays.stream(tills).max().orElse(0) + time;
    }

    private static void decreaseTills(int[] tills, Queue<Integer> emptyTills) {
        for(int i = 0; i < tills.length; i++){
            tills[i]--;

            if(tills[i] == 0){
                emptyTills.add(i);
            }
        }
    }
}