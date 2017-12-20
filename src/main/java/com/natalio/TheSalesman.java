package main.java.com.natalio;

import java.util.*;
import java.util.stream.Collectors;

public class TheSalesman{
    static class Tree{
        int root;
        List<Tree> children = new ArrayList<>();
        Tree parent = null;

        public Tree(int root) {
            this.root = root;
        }


        public void add(Tree t) {
            t.parent = this;
            children.add(t);
        }
    }

    public static int minimumTime(int[] values){

        return Arrays.stream(values)
            .boxed()
            .map(v -> generatePaths(
                    v,
                    Arrays.stream(values)
                        .boxed()
                        .filter(i -> !i.equals(v))
                        .collect(Collectors.toList())
                )
            )
            .map(TheSalesman::calculate)
            .min(Integer::compareTo)
            .get();
    }

    public static Tree generatePaths(int root, List<Integer> sublist){

        Tree t = new Tree(root);

        sublist.stream()
            .map(aValue -> generatePaths(
                aValue,
                sublist.stream()
                    .filter(aVal -> !aVal.equals(aValue))
                    .collect(Collectors.toList())
                )
            )
            .forEach(t::add);

        return t;
    }

    public static int calculate(Tree t){
        if(t.children.isEmpty()){
            return 0;
        }

        Tree min = t.children.get(0);

        for(Tree subt : t.children){
            if(Math.abs(t.root-subt.root) < Math.abs(t.root-min.root)){
                min = subt;
            }
        }

        return Math.abs(t.root-min.root) + calculate(min);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] x = new int[n];
            for(int x_i = 0; x_i < n; x_i++){
                x[x_i] = in.nextInt();
            }
            int result = minimumTime(x);
            System.out.println(result);
        }
        in.close();
    }

}
