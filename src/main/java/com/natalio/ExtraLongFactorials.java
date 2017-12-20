package main.java.com.natalio;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(factorial(n, BigInteger.valueOf(n)));
    }

    public static BigInteger factorial(int n, BigInteger acum){
        if(n == 1){
            return acum;
        }

        return factorial(n-1, acum.multiply(BigInteger.valueOf(n-1)));
    }
}
