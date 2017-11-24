package main.java.com.natalio.xmastree;

//christmasTree(height) that returns a christmas tree of the correct height
//
//    christmasTree(5) should return:
//
//        *
//       ***
//      *****
//     *******
//    *********
public class XmasTree {
    public static void main(String[] args){
        christmasTree(5);
    }


    private static void christmasTree(int n) {
        System.out.println(treeWritter(n));
    }

    public static String treeWritter(int n) {
            StringBuilder s = new StringBuilder();

            for (int spaces = n - 1, dots = 1; spaces >= 0; spaces--, dots = dots + 2) {
                s.append(space(spaces));
                s.append(dot(dots));
                s.append("\n");
            }

            return s.toString();
    }

    private static String dot(int repeat) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < repeat; i++){
            builder.append(".");
        }

        return builder.toString();
    }

    private static String space(int repeat) {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < repeat; i++){
            builder.append(" ");
        }

        return builder.toString();
    }

}
