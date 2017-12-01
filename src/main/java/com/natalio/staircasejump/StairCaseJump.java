package main.java.com.natalio.staircasejump;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StairCaseJump {
    private static Map<Integer, Integer> cache = new HashMap<>();
    private static final int[] typesOfJump = new int[]{1,2,3};


    public static int calculateJumps(int steps) {

        return calculate(steps);
    }

    private static int calculate(int stepNumber) {
        if(stepNumber == 0){
            return 1;
        }

        if(stepNumber < 0){
            return 0;
        }

        if(!cache.containsKey(stepNumber)){
            int result = 0;

            for(int aJump : typesOfJump){
                result += calculate(stepNumber-aJump);
            }

            cache.put(stepNumber, result);
        }

        return cache.get(stepNumber);
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(calculateJumps(n));
        }
    }

}
