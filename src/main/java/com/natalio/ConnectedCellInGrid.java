package main.java.com.natalio;

import java.util.*;

public class ConnectedCellInGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        int numCells = new Grid(n, m, grid).numCellsInLargestRegion();

        System.out.println(numCells);
    }

    public static class Grid {
        private final int rows;
        private final int cols;
        private final int[][] data;

        public Grid(int rows, int cols, int[][] input) {
            this.rows = rows;
            this.cols = cols;
            data = input;
        }

        public int numCellsInLargestRegion() {
            int maxNumCells = 0;
            int numCellsInARegion;
            Set<Node> visited = new HashSet<>();

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    Node current = new Node(row, col);
                    if (current.isFilled() && !visited.contains(current)) {
                        numCellsInARegion = dfs(current, visited);
                        maxNumCells = Math.max(maxNumCells, numCellsInARegion);
                    }
                }
            }

            return maxNumCells;
        }

        private int dfs(Node first, Set<Node> visited) {
            Deque<Node> q = new ArrayDeque<>();
            q.add(first);
            visited.add(first);
            int numCellsInRegion = 1;

            while (!q.isEmpty()) {
                Node current = q.pop();

                for (Node neighbor : getNeighborsOf(current)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }

                    visited.add(neighbor);
                    q.add(neighbor);
                    numCellsInRegion++;
                }
            }

            return numCellsInRegion;
        }

        private List<Node> getNeighborsOf(Node current) {
            List<Node> neighbors = new ArrayList<>();

            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    Node node = new Node(current.row + r, current.col + c);

                    if (node.isValid() && !node.equals(current) && node.isFilled()) {
                        neighbors.add(node);
                    }
                }
            }

            return neighbors;
        }

        private class Node {
            int row;
            int col;

            public Node(int row, int col) {
                this.row = row;
                this.col = col;
            }

            @Override
            public boolean equals(Object o) {
                Node node = (Node) o;

                return row == node.row && col == node.col;
            }

            @Override
            public int hashCode() {
                int result = row;
                result = 31 * result + col;

                return result;
            }

            public boolean isValid() {
                return (row >= 0) && (col >= 0) && (row < rows) && (col < cols);
            }

            public boolean isFilled() {
                return isValid() && data[row][col] == 1;
            }
        }
    }
}
