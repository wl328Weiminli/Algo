package graph_algo;


import java.util.*;

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;

    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}


