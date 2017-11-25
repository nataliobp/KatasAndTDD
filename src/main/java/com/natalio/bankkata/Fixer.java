package main.java.com.natalio.bankkata;

//It turns out that often when a number comes back as ERR or ILL it is because the scanner has failed to pick up
//on one pipe or underscore for one of the figures. For example
//        _  _  _  _  _  _     _
//    |_||_|| || ||_   |  |  ||_
//      | _||_||_||_|  |  |  | _|
//
//The 9 could be an 8 if the scanner had missed one |. Or the 0 could be an 8. Or the 1 could be a 7.
//The 5 could be a 9 or 6. So your next task is to look at numbers that have come back as ERR or ILL, and try
//to guess what they should be, by adding or removing just one pipe or underscore. If there is only one possible
//number with a valid checksum, then use that. If there are several options, the status should be AMB. If you
//still can’t work out what it should be, the status should be reported ILL.

import test.java.com.natalio.bankkata.Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Fixer {
    private static final Character[] symbols = new Character[]{'|', ' ', '_'};

    public static String fix(String inputText) {
        Solution solution = new Solution(Scanner.scanNumber(inputText));

        IntStream.range(0, inputText.length())
            .filter(i -> inputText.charAt(i) != '\n')
            .forEach(i ->
                Arrays.stream(symbols)
                    .filter(symbol -> !symbol.equals(inputText.charAt(i)))
                    .map(symbol -> replaceSymbol(inputText, i, symbol))
                    .filter(Fixer::isAValidNumber)
                    .map(Scanner::scanNumber)
                    .forEach(solution::addSolution)
            );

        return solution.toString();
    }

    private static String replaceSymbol(String inputText, int i, Character symbol) {
        StringBuilder sb = new StringBuilder(inputText);
        sb.setCharAt(i, symbol);

        return sb.toString();
    }

    private static boolean isAValidNumber(String newInputText) {
        return Scanner.scanNumber(newInputText).equals(ValidationPrinter.printResultOf(newInputText));
    }
}
