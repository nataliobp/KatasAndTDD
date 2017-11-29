package main.java.com.natalio.coinchange;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {

    public static int calculateCombinations(int[] coins, int amount){
        return calculate(new int[coins.length], coins, amount, new HashSet<>(), 0);
    }

    public static int calculate(int[] multipliers, int[] elements, int value, Set<String> results, int sum){
        String key = Arrays.toString(multipliers);

        if(results.contains(key)){
            return 0;
        }

        results.add(key);

        if(sum == value){
            return 1;
        }

        if (sum > value){
            return 0;
        }

        int result = 0;

        for(int i = 0; i < multipliers.length; i++){
            int[] m = Arrays.copyOf(multipliers, multipliers.length);
            m[i]++;
            result +=  calculate(m, elements, value, results, sum + elements[i]);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(calculateCombinations(new int[]{5, 10, 20}, 40));
    }
}
