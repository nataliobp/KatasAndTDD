package main.java.com.natalio;

//For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:
//
//    The data value of every node in a node's left subtree is less than the data value of that node.
//    The data value of every node in a node's right subtree is greater than the data value of that node.
//    Given the root node of a binary tree, can you determine if it's also a binary search tree?
//
//    Complete the function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.
//
//    Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.

import java.util.HashSet;
import java.util.Set;

public class IsABST {

    public static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int element){
            if(element < data){
                if(left == null){
                    left = new Node(element);
                }else{
                    left.insert(element);
                }
            }else{
                if(right == null){
                    right = new Node(element);
                }else{
                    right.insert(element);
                }
            }
        }

        public void insertArray(int[] elements){
            for(int element: elements){
                insert(element);
            }
        }
    }

    public boolean checkBST(Node root) {

        return check(root, new HashSet<>());
    }

    private boolean check(Node root, Set<Integer> contains) {
        if(root == null){
            return true;
        }

        if(contains.contains(root.data)){
            return false;
        }

        if(root.left != null && maxValue(root.left) > root.data){
            return false;
        }

        if(root.right != null &&  minValue(root.right) < root.data){
            return false;
        }

        contains.add(root.data);

        return check(root.left, contains) && check(root.right, contains);
    }

    private int minValue(Node root) {
        return getMin(root, root.data);
    }

    private int maxValue(Node root) {
        return getMax(root, root.data);
    }

    private int getMax(Node root, int max) {
        if(root == null){
            return max;
        }

        if(max < root.data){
            max = root.data;
        }


        int leftMax = getMax(root.left, max);
        int rightMax = getMax(root.right, max);

        return leftMax > rightMax ? leftMax : rightMax;
    }

    private int getMin(Node root, int min) {
        if(root == null){
            return min;
        }

        if(min > root.data){
            min = root.data;
        }

        int leftMin = getMin(root.left, min);
        int rightMin = getMin(root.right, min);

        return leftMin < rightMin ? leftMin : rightMin;
    }
}
