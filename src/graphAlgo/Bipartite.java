package graphAlgo;

import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!canSeparate(node, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean canSeparate(GraphNode node, Map<GraphNode, Integer> map) {
        if (map.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.poll();
            int group = map.get(temp);
            for (GraphNode nei : temp.neighbors) {
                Integer check = map.get(nei);
                if (check == null) {
                    int anotherGroup = group == 0 ? 1 : 0;
                    map.put(nei, anotherGroup);
                    queue.offer(nei);
                } else if (check == group) {
                    return false;
                }
            }
        }
        return true;
    }

}
