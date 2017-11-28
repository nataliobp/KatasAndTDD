package main.java.com.natalio.balancedbrackets;

import java.util.*;

public class BalancedBrackets {
    private static Map<Character, Character> bracketsMap = new HashMap<>();

    static {
        bracketsMap.put('(', ')');
        bracketsMap.put('{', '}');
        bracketsMap.put('[', ']');
    }

    public static boolean isBalanced(String expression) {
        return checkBalance(expression, 0, new ArrayDeque<>());
    }

    private static boolean checkBalance(String expression, int pos, Deque<Character> openBrackets) {
        if (pos == expression.length()) {
            return openBrackets.isEmpty();
        }

        char aBracket = expression.charAt(pos);

        if (bracketsMap.containsKey(aBracket)) {
            openBrackets.push(aBracket);

            return checkBalance(expression, pos + 1, openBrackets);
        }

        return !openBrackets.isEmpty() &&
            bracketsMap.get(openBrackets.pop()).equals(aBracket) &&
            checkBalance(expression, pos + 1, openBrackets);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
