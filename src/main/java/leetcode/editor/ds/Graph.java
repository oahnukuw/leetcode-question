package leetcode.editor.ds;

import java.util.HashSet;

public interface Graph {
    void addEdge(int from, int to, int weight);

    void removeEdge(int from, int to);

    boolean hasEdge(int from, int to);

    int weight(int from, int to);

    HashSet<Edge> neighbors(int v);

    int size();
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
