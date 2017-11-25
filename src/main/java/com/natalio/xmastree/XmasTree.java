package main.java.com.natalio.xmastree;

import java.util.stream.IntStream;

//christmasTree(height) that returns a christmas tree of the correct height
//
//    christmasTree(5) should return:
//
//        *
//       ***
//      *****
//     *******
//    *********

public class XmasTree {

    public static final String SPACE = " ";
    public static final String DOT = ".";
    public static final String NEW_LINE = "\n";

    public static void main(String[] args){
        christmasTree(5);
    }

    private static void christmasTree(int n) {
        System.out.println(treeBuilder(n));
    }

    public static String treeBuilder(int n) {
            StringBuilder s = new StringBuilder();

            for (int numSpaces = n - 1, numDots = 1; numSpaces >= 0; numSpaces--, numDots = numDots + 2) {
                s.append(writeCharacter(SPACE, numSpaces));
                s.append(writeCharacter(DOT, numDots));
                s.append(NEW_LINE);
            }

            return s.toString();
    }

    private static String writeCharacter(String character, int repeat) {

        return IntStream.range(0, repeat)
            .mapToObj(i -> character)
            .reduce((result, a) -> result+=a)
            .orElse("");
    }
}
