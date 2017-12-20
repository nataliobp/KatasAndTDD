package main.java.com.natalio;

import java.util.stream.IntStream;

// Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing
// letter in the array. You will always get an valid array. And it will be always exactly one letter be missing.
// The length of the array will always be at least 2. The array will always contain letters in only one case.
//    Example:
//    ['a','b','c','d','f'] -> 'e'
//    ['O','Q','R','S'] -> 'P'

public class MissingLetter {
    public static char findMissingLetter(char[] array)
    {
        int findFirst = IntStream.range(0, array.length)
            .filter(i -> array[i]+1 != array[i+1])
            .findFirst()
            .orElse(0);

        return (char) (array[findFirst]+1);
    }
}
