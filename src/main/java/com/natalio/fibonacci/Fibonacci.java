package main.java.com.natalio.fibonacci;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0 || n == 1){
            return n;
        }

        return fibonacciLoop(0,1,1,n);
    }

    private static int fibonacciLoop(int first, int second, int i, int n) {
        if(n == i){
            return second;
        }

        return fibonacciLoop(second, first+second, i+1, n);
    }
}
