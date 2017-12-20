package main.java.com.natalio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimeNumbers {
    private static boolean isPrime(int n){
        if(n == 1){
            return false;
        }

        for(int i = 2, max = n; i < max; i++){
            if(n % i == 0){
                return false;
            }
            max = n / i;
        }

        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/natman/Desktop/prime.txt"));
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            if(isPrime(n)){
                System.out.println("Prime");
            } else{
                System.out.println("Not prime");
            }
        }
    }
}
