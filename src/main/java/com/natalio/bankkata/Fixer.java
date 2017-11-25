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

public class Fixer {
    public static String fix(String inputText) {
        String number = Scanner.scanNumber(inputText);

        if(ValidationPrinter.checkStatus(number, inputText).equals("")){
            return number;
        }

        return findMatchesByReplacingACharacter(inputText);
    }

    private static String findMatchesByReplacingACharacter(String inputText) {
        char[] symbols = new char[]{'|', ' ', '_'};
        char[] inputTextChars = inputText.toCharArray();
        Solution solution = new Solution(Scanner.scanNumber(inputText));

        for(int i = 0; i < inputTextChars.length; i++)  {
            if(inputTextChars[i] == '\n'){
               continue;
            }

            for(char symbol : symbols){

               StringBuilder sb = new StringBuilder(inputText);
               sb.setCharAt(i, symbol);
               String number = Scanner.scanNumber(sb.toString());

               if("".equals(ValidationPrinter.checkStatus(number, sb.toString()))){
                   solution.addSolution(number);
               }
            }
        }

        return solution.toString();
    }
}
