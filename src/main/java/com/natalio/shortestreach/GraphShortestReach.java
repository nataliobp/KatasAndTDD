package main.java.com.natalio.shortestreach;

import java.util.*;
import java.util.stream.IntStream;

public class GraphShortestReach {
    public static class Graph {

        private final Map<Integer, List<Integer>> nodes = new HashMap<>();
        private final int size;

        public Graph(int size) {
            this.size = size;
        }

        public void addEdge(int first, int second) {
            List<Integer> edges = nodes.getOrDefault(first, new ArrayList<>());

            if(!edges.contains(second)){
                edges.add(second);
                nodes.put(first, edges);
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Map<Integer, Integer> distances = bfs(startId);

            return IntStream.range(0, size)
                .map(i -> distances.getOrDefault(i, -1))
                .toArray();
        }

        public Map<Integer, Integer> bfs(int first){
            Set<Integer> visited = new HashSet<>();
            Deque<Integer> q = new ArrayDeque<>();
            q.add(first);
            visited.add(first);
            final Map<Integer, Integer> distances = new HashMap<>();
            distances.put(first, 0);

            while (!q.isEmpty()){
                Integer current = q.pop();
                for(Integer neighbor : nodes.getOrDefault(current, Collections.emptyList())){
                    if(visited.contains(neighbor)){
                       continue;
                    }
                    distances.put(neighbor, 6 + distances.get(current));
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            int size = scanner.nextInt();
            Graph graph = new Graph(size);
            int m = scanner.nextInt();

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                graph.addEdge(u, v);
                graph.addEdge(v, u);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
