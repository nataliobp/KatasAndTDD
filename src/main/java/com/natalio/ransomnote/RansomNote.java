package main.java.com.natalio.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean evaluate(String[] text, String[] note) {
        Map<String,Integer> textMap = new HashMap<>();

        for(String word : text){
            textMap.merge(word, 1, Integer::sum);
        }

        for(String word : note){
            if(textMap.getOrDefault(word, 0) == 0){
                return false;
            }

            textMap.put(word, textMap.get(word)-1);
        }

        return true;
    }
}
