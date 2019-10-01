package GRAPH;

import java.util.*;

public class Graf {

    HashMap<Node, List<Node>> adjList;
    List<Edge> edgeList;

    public Graf() {
        this.adjList = new HashMap<Node, List<Node>>();
        this.edgeList = new ArrayList<Edge>();
    }

    void addNode(Node n) {

        if (adjList.get(n) != null) {
            adjList.put(n, new ArrayList<Node>());
        }
    }

    void addNode(int n){
        Node node = new Node(n);
        this.addNode(node);
    }


    void removeNode(Node n){
        adjList.remove(n);
        for (Map.Entry<Node, List<Node>> entry: adjList.entrySet()){
            List<Node> currList = entry.getValue();
            currList.remove(n);
        }
    }

    void removeNode(int n){
        Node node = new Node(n);
        this.removeNode(node);
    }

    void addEdge(Node from, Node to){
        addNode(from);
        addNode(to);
        Edge currEdge = new Edge(from, to);
        if(edgeList.contains(currEdge)) {
            this.edgeList.add(currEdge);
        }
    }

    void addEdge(int from, int to){
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        addEdge(currFrom, currTo);
    }

    void removeEdge(Node from, Node to){
        Edge currEdge = new Edge(from, to);
        edgeList.remove(currEdge);
    }

    void removeEdge(Edge e){
        edgeList.remove(e);
    }

    void removeEdge(int from, int to){
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        removeEdge(currFrom, currTo);
    }



     


}

