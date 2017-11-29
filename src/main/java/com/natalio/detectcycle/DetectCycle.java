package main.java.com.natalio.detectcycle;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    static class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        Node next = head;
        Set<Node> visitedNodes = new HashSet<>();

        while (next != null){
            if(visitedNodes.contains(next)){
                return true;
            }

            visitedNodes.add(next);
            next = next.next;
        }

        return false;
    }
}
