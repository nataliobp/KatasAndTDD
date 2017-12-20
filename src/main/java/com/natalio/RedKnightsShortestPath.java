package main.java.com.natalio;

import java.util.*;
import java.util.stream.Collectors;

public class RedKnightsShortestPath {

    private static int size;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public List<Node> moves() {
            Node[] possibles = new Node[]{
                new Node(x-1, y-2),
                new Node(x+1, y-2),
                new Node(x+2, y),
                new Node(x+1, y+2),
                new Node(x-1, y+2),
                new Node(x-2, y),
            };

            return Arrays.stream(possibles)
                .filter(n -> n.x >= 0 && n.y >= 0 && n.x < size && n.y < size)
                .collect(Collectors.toList());
        }
    }

    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        List<String> result = shortest(n, i_start, j_start, i_end, j_end);
        if(result == null){
            System.out.println("Impossible");
        }else{
            System.out.println(result.size());
            System.out.println(result.stream().collect(Collectors.joining(" ")));
        }
    }

    public static List<String> shortest(int n, int i_start, int j_start, int i_end, int j_end){
        size = n;
        return dfs(new Node(j_start, i_start), new Node (j_end, i_end));
    }

    private static List<String> dfs(Node start, Node end){
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> parent = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()){
            Node current = q.poll();

            if(current.equals(end)){
                return calculatePath(current, parent, start);
            }

            for(Node nextMove : current.moves()){
                if(visited.contains(nextMove)){
                    continue;
                }

                visited.add(nextMove);
                parent.put(nextMove, current);
                q.add(nextMove);
            }
        }

        return null;
    }

    private static List<String> calculatePath(Node current, Map<Node, Node> parent, Node start) {
        Deque<String> result = new ArrayDeque<>();

        while (current != start){
            result.push(movementOf(parent.get(current), current));
            current = parent.get(current);
        }

        return new ArrayList<>(result);
    }

    private static String movementOf(Node parent, Node current) {
        if(current.x == parent.x-1 && current.y == parent.y-2){
            return "UL";
        }
        if(current.x == parent.x+1 && current.y == parent.y-2){
            return "UR";
        }
        if(current.x == parent.x+2 && current.y == parent.y){
            return "R";
        }
        if(current.x == parent.x+1 && current.y == parent.y+2){
            return "LR";
        }
        if(current.x == parent.x-1 && current.y == parent.y+2){
            return "LL";
        }
        if(current.x == parent.x-2 && current.y == parent.y){
            return "L";
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}
