package main.java.com.natalio.coinchange;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoinChange {

    public static int calculateCombinations(int[] coins, int amount){
        return calculate(new int[coins.length], coins, amount, new HashSet<>());
    }

    public static int calculate(int[] multipliers, int[] elements, int value, Set<String> results){
        int sum = 0;
        String key = Arrays.toString(multipliers);

        if(results.contains(key)){
           return 0;
        }

        results.add(key);

        for(int i = 0; i < elements.length; i++){
            sum += elements[i] * multipliers[i];
        }

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
            result +=  calculate(m, elements, value, results);
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(calculateCombinations(new int[]{5, 10, 20}, 40));
    }
}
