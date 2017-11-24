package main.java.com.natalio.money;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Pair, Integer> m = new HashMap<>();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        m.put(new Pair(from, to), rate);
    }

    int rate(String from, String to){
        if(from.equals(to)){
            return 1;
        }

        return m.getOrDefault(new Pair(from, to), null);
    }
}
