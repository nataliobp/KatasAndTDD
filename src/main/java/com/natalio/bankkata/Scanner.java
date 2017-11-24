package main.java.com.natalio.bankkata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//You work for a bank, which has recently purchased an ingenious machine to assist in reading letters and faxes
// sent in by branch offices. The machine scans the paper documents, and produces a file with a number of
// entries which each look like this:
//      _  _     _  _  _  _  _
//    | _| _||_||_ |_   ||_||_|
//    ||_  _|  | _||_|  ||_| _|
//
// Each entry is 4 lines long, and each line has 27 characters. The first 3 lines of each entry contain an
// account number written using pipes and underscores, and the fourth line is blank. Each account number should
// have 9 digits, all of which should be in the range 0-9. A normal file contains around 500 entries.
// Your first task is to write a program that can take this file and parse it into actual account numbers.

public class Scanner {
    public static String scanNumber(String inputText) {

        String[][] scannedDigits = scanDigits(inputText);

        return parseNumbers(scannedDigits);
    }

    private static String[][] scanDigits(String toScan) {

        String[] lines = toScan.split("\n");
        int numDigits = lines[0].length()/3;
        String[][] scannedDigits = new String[numDigits][3];

        for(int currentLine = 0; currentLine < 3; currentLine++){
            for(int charPos = 0, scannedDigit = 0; scannedDigit < numDigits; charPos+=3, scannedDigit++){
                scannedDigits[scannedDigit][currentLine] = lines[currentLine].substring(charPos, charPos+3);
            }
        }

        return scannedDigits;
    }

    private static String parseNumbers(String[][] scannedDigits) {

        Map<String, String> map = new HashMap<>();
        map.put("     |  |", "1");
        map.put(" _  _||_ ", "2");
        map.put(" _  _| _|", "3");
        map.put("   |_|  |", "4");
        map.put(" _ |_  _|", "5");
        map.put(" _ |_ |_|", "6");
        map.put(" _   |  |", "7");
        map.put(" _ |_||_|", "8");
        map.put(" _ |_| _|", "9");
        map.put(" _ | ||_|", "0");

       return Arrays.stream(scannedDigits)
            .map(aDigit -> String.join("", aDigit))
            .map(map::get)
            .reduce("", (a, b) -> a+b);
    }
}
