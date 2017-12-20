package main.java.com.natalio;

import java.io.*;
import java.util.*;

public class BubbleSort {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i =0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        int numSwaps = bubbleSort(arr);
        System.out.printf("Array is sorted in %s swaps.\n", numSwaps);
        System.out.printf("First Element: %s\n", arr[0]);
        System.out.printf("Last Element: %s\n", arr[size-1]);
    }

    private static int bubbleSort(int[] arr){
        int totalSwaps = 0;
        boolean sorted = false;

        for (int lastSorted = arr.length-1; !sorted; lastSorted--){
            sorted = true;
            for(int j = 0; j < lastSorted; j++){
                if(arr[j]> arr[j+1]){
                    swap(arr, j, j+1);
                    totalSwaps++;
                    sorted = false;
                }
            }
        }

        return totalSwaps;
    }

    private static void swap(int[] arr, int i, int j){
        int aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }
}