package leetcode.editor.ds;

import java.util.HashMap;
import java.util.HashSet;

public class WeightedDigraph implements Graph {
    private HashMap<Integer, HashSet<Edge>> graph;

    public WeightedDigraph() {
        graph = new HashMap<>();
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        graph.putIfAbsent(from, new HashSet<>());
        graph.get(from).add(new Edge(to, weight));
    }

    @Override
    public void removeEdge(int from, int to) {
        HashSet<Edge> edges = graph.get(from);
        edges.remove(to);
    }

    @Override
    public boolean hasEdge(int from, int to) {
        HashSet<Edge> edges = graph.get(from);
        return edges.contains(to);
    }

    @Override
    public int weight(int from, int to) {
        HashSet<Edge> edges = graph.get(from);
        for (Edge edge : edges) {
            if (edge.to == to) {
                return edge.weight;
            }
        }
        return -1;
    }

    @Override
    public HashSet<Edge> neighbors(int v) {
        return graph.get(v);
    }

    @Override
    public int size() {
        return graph.size();
    }

}
