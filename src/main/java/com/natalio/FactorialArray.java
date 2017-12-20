package main.java.com.natalio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FactorialArray {

    static Map<Long, Long> saved = new HashMap<>();


    public static long factorial(long n){
        if(saved.containsKey(n)){
            return saved.get(n);
        }

        if(n == 1){
            return 1;
        }

        saved.put(n, n * factorial(n-1));

        return saved.get(n);
    }



    private static void factorialSum(int l, int r, long[] values){
        long result = 0;
        for(int i = l; i <= r; i++){
            result += factorial(values[i]);
        }

        System.out.println(result%1000000000);
    }

    private static void plusOne(int l, int r, long[] values){

        for(int i = l; i <= r; i++){
            values[i] = values[i]+1;
        }
    }

    private static void set(int i, int v, long[] values){

        values[i] = v;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] A = new long[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < m; a0++){
           int op = in.nextInt();
           int l = in.nextInt();
           int r = in.nextInt();

           if(op == 1){
               plusOne(l-1,r-1,A);
           }else if(op == 2){
               factorialSum(l-1,r-1,A);
           }else{
               set(l-1,r,A);
           }
        }
        in.close();
    }
}
