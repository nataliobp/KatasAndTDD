package main.java.com.natalio.arraysleftrotation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

//A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
//For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
//
//Given an array of n integers and a number, d, perform  left rotations on the array. Then print the
//updated array as a single line of space-separated integers.

public class ArraysLeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        System.out.println(rotate(a, k));
    }

    public static String rotate(int[] arr, int numRotations) {
        int[] result = new int[arr.length];

        for(int i = 0, j = arr.length-numRotations; i < numRotations; i++, j++){
            result[j] = arr[i];
        }

        for(int i = numRotations, j = 0; j < arr.length-numRotations; i++, j++){
            result[j] = arr[i];
        }

        return printResult(result);
    }

    private static String printResult(int[] arr) {
        return Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

    }
}
