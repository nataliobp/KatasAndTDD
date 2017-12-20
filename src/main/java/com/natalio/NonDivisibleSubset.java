package main.java.com.natalio;


import java.util.*;

public class NonDivisibleSubset {

    public static class Entry implements Comparable<Entry>{
        public int value;
        public Integer freq;

        public Entry(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Entry o) {
            return o.freq.compareTo(freq);
        }
    }

    private static Map<Integer, Integer> freq = new HashMap<>();
    private static Set<Set<Integer>> pairs = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        List<Integer> set = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            arr[i] = in.nextInt();
            set.add(arr[i]);
        }

        check(set, k);
    }

    private static void check(List<Integer> subset, int k) {

        for(int i = 0; i < subset.size()-1; i++){
            for(int j = i+1; j < subset.size(); j++){
                if((subset.get(i)+ subset.get(j)) % k == 0){
                    freq.merge(subset.get(i), 1, Integer::sum);
                    freq.merge(subset.get(j), 1, Integer::sum);
                    pairs.add(new HashSet<>(Arrays.asList(subset.get(i),subset.get(j))));
                }
            }
        }
    }

    public static int calculate(List<Integer> l, int i) {
        check(l, i);
        PriorityQueue<Entry> q = new PriorityQueue<>();
        for(Integer k : freq.keySet()){
            q.add(new Entry(k, freq.get(k)));
        }
        List<Integer> toremoveill = new ArrayList<>();

        while (!pairs.isEmpty()){
            Integer current = q.poll().value;
            List<Set<Integer>> toremove = new ArrayList<>();
            for(Set<Integer> s : pairs){
                if(s.contains(current)){
                    toremove.add(s);
                }
            }
            pairs.removeAll(toremove);
            toremoveill.add(current);
        }

        return 2;
    }
}
