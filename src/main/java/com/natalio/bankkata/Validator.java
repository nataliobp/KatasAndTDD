package main.java.com.natalio.bankkata;


//Having done that, you quickly realize that the ingenious machine is not in fact infallible. Sometimes it goes
// wrong in its scanning. The next step therefore is to validate that the numbers you read are in fact valid
// account numbers. A valid account number has a valid checksum. This can be calculated as follows:
//
//    account number:  3  4  5  8  8  2  8  6  5
//    position names:  d9 d8 d7 d6 d5 d4 d3 d2 d1
//
//    checksum calculation:
//    (1*d1+2*d2+3*d3 +..+9*d9) mod 11 = 0
//
// So now you should also write some code that calculates the checksum for a given number, and identifies if
// it is a valid account number.

import java.util.stream.IntStream;

public class Validator {
    public static int calculateSum(String number) {

        return IntStream.iterate(9, x -> x-1)
            .limit(9)
            .reduce(0, (acc, multiplier) -> Character.getNumericValue(number.charAt(9 - multiplier)) * multiplier);
    }

    public static boolean validate(String number) {
        return calculateSum(number) % 11 == 0;
    }
}
