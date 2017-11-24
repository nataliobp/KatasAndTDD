package main.java.com.natalio.money;

public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        Pair p = (Pair) o;

        return (p.from.equals(from) && p.to.equals(to));
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
