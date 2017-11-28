package main.java.com.natalio.makinganagrams;


public class Anagrams {
    public static int numberNeeded(String first, String second) {

        return getDeletions(first, second) + getDeletions(second, first);
    }

    private static int getDeletions(String first, String second) {
        int deletions = 0;
        char[] subject = second.toCharArray();

        for(int i = 0; i < first.length(); i++){
            if(!contains(subject, first.charAt(i))){
                deletions++;
            }
        }

        return deletions;
    }

    private static boolean contains(char[] subject, char letter) {
        for(int i = 0; i < subject.length; i++){
            if(subject[i] == letter){
                subject[i] = 0;
                return true;
            }
        }

        return false;
    }
}
