package main.java.com.natalio;

import java.util.Scanner;

public class BreakingSticks {

    private static boolean isPrime(int n){

        for(int i = 2, max = n; i < max; i++){
            if(n % i == 0){
                return false;
            }
            max = n / i;
        }

        return true;
    }

    private static int nextPrime(int current){
        int next = current+1;

        while (!isPrime(next)){
            next++;
        }

        return next;
    }

    static long longestSequence(long[] a) {
        long result = 0;
        for(long number : a){
            result+= longestOf(number);
        }

        return result;
    }

    static long longestOf(long n){
        long result = n;
        long current = n;

        while (current != 1){
            int prime = 2;

            while (current % prime != 0){
                prime = nextPrime(prime);
            }

            long division = current/prime;
            result+= division;
            current = division;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long result = longestSequence(a);
        System.out.println(result);
        in.close();
    }
}
