package graphAlgo;

import java.util.*;

public class KthSmallestInMatrix {
    static class Node {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Node)) return false;

            Node temp = (Node) o;
            return temp.x == x && temp.y == y && temp.value == value;
        }

        @Override
        public int hashCode() {
            return 101 * 101 * value + 101 * y + x;
        }

    }

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if (a.value == b.value) {
                    return 0;
                }
                return a.value < b.value ? -1 : 1;
            }
        });
        Set<Node> visited = new HashSet<>();
        Node newNode = new Node(0, 0, matrix[0][0]);
        pq.offer(newNode);
        visited.add(newNode);
        for (int i = 0; i < k - 1; i++) {
            Node temp = pq.poll();
            if (temp.x + 1 < matrix.length) {
                Node nei = new Node(temp.x + 1, temp.y, matrix[temp.x + 1][temp.y]);
                if (!visited.contains(nei)) {
                    pq.offer(nei);
                    visited.add(nei);
                }
            }
            if (temp.y + 1 < matrix[0].length) {
                Node nei = new Node(temp.x, temp.y + 1, matrix[temp.x][temp.y + 1]);
                if (!visited.contains(nei)) {
                    pq.offer(nei);
                    visited.add(nei);
                }
            }
        }
        return pq.poll().value;
    }

    public static void main(String[] args) {
        KthSmallestInMatrix test = new KthSmallestInMatrix();
        int[][] matrix = {{1, 2, 3, 4}, {11, 12, 13, 14}, {15, 16, 17, 18}, {19, 20, 21, 22}};
        System.out.println(test.kthSmallest(matrix, 4));
    }

}
