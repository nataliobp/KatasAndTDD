package main.java.com.natalio;

import java.util.*;

public class MergeSortCountInversions {
    private static Long total = 0L;

    public static int[] mergesort(int[] input) {
        if(input.length == 1){
            return input;
        }

        return merge(
            mergesort(Arrays.copyOfRange(input, 0 , input.length/2)),
            mergesort(Arrays.copyOfRange(input, input.length/2 , input.length))
        );
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i =0, j = 0, k=0;

        while (i < left.length && j < right.length){
            if(left[i] <= right[j]){
                result[k++] = left[i++];
            } else {
                total+= left.length-i;
                result[k++] = right[j++];
            }
        }

        while (i < left.length){
            result[k++] = left[i++];
        }

        while (j < right.length){
            result[k++] = right[j++];
        }

        return result;
    }

    public static long countInversions(int[] arr) {
        total = 0L;
        if (arr.length < 2){
            return total;
        }

        mergesort(arr);

        return total;
    }

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
