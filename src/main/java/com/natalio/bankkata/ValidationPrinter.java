package main.java.com.natalio.bankkata;

//Your boss is keen to see your results. He asks you to write out a file of your findings, one for each input file, in
//this format:
//
//    457508000
//    664371495 ERR
//    86110??36 ILL

//ie the file has one account number per row. If some characters are illegible, they are replaced by a ?.
//In the case of a wrong checksum, or illegible number, this is noted in a second column indicating status.

public class ValidationPrinter {
    public static String printResultOf(String inputText) {
        String number = Scanner.scanNumber(inputText);

        if(number.contains("?")){
            return number + " ILL";
        }

        if(!Checker.checkSum(inputText)){
            return number + " ERR";
        }

        return number;
    }
}
