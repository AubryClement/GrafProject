package GRAPH;

import java.util.*;

public class Graf {

    HashMap<Node, List<Node>> adjList;
    List<Edge> edgeList;

    public Graf() {
        this.adjList = new HashMap<Node, List<Node>>();
        this.edgeList = new ArrayList<Edge>();
    }

    public Graf(HashMap<Node, List<Node>> adjList, List<Edge> edgeList){
        this.adjList = adjList;
        this.edgeList = edgeList;
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

        for (Edge edge: edgeList) {
            if(edge.getFrom() == n || edge.getTo() == n){
                edgeList.remove(edge);
            }
        }

    }

    void removeNode(int n){
        adjList.remove(n);
        for (Map.Entry<Node, List<Node>> entry: adjList.entrySet()){
            List<Node> currList = entry.getValue();
            currList.remove(n);
        }
        for (Edge edge: edgeList) {
            if(edge.getFrom().getIndex() == n || edge.getTo().getIndex() == n){
                edgeList.remove(edge);
            }
        }
    }
    //TO DO TEST MA COUILLE

    //KIKKKKKKKKKKKIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    void addEdge(Node from, Node to){
        addNode(from);
        addNode(to);
        Edge currEdge = new Edge(from, to);
        if(!edgeList.contains(currEdge)) {
            this.edgeList.add(currEdge);
            List<Node> listNode = adjList.get(from);
            if(!listNode.contains(to)){
                listNode.add(to);
            }
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


    List<Node> getSuccessors(Node n){
        List<Node> res = new ArrayList<Node>();
        for (Edge edge: edgeList) {
            if(edge.getFrom() == n){
                res.add(edge.getTo());
            }
        }
        return res;
    }

    List<Node> getSuccessors(int n){
        List<Node> res = new ArrayList<Node>();
        for (Edge edge: edgeList) {
            if(edge.getFrom().getIndex() == n){
                res.add(edge.getTo());
            }
        }
        return res;
    }

    List<Edge> getOutEdges(Node n){
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge: edgeList) {
            if(edge.getFrom() == n){
                res.add(edge);
            }
        }
        return res;
    }

    List<Edge> getOutEdges(int n){
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge: edgeList) {
            if(edge.getFrom().getIndex() == n){
                res.add(edge);
            }
        }
        return res;
    }

    List<Edge> getInEdges(Node n){
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge: edgeList) {
            if(edge.getTo() == n){
                res.add(edge);
            }
        }
        return res;
    }

    List<Edge> getInEdges(int n){
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge: edgeList) {
            if(edge.getFrom().getIndex() == n){
                res.add(edge);
            }
        }
        return res;
    }

    List<Edge> getIncidentEdges(Node n){
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    List<Edge> getIncidentEdges(int n){
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    List<Node> getAllNodes(){
        List<Node> nodeList = null;
        for ( Map.Entry<Node, List<Node>> key: adjList.entrySet()) {
            nodeList.add(key.getKey());
        }
        return nodeList;
    }

    List<Edge> getAllEdges(){
        return this.edgeList;
    }

    int[] getSuccessorArray(){
        List<Integer> res = null;
        int prev = 0;
        for (Edge edge: edgeList) {
            prev = edge.getFrom().getIndex();
            res.add(edge.getTo().getIndex());
            break;
        }

        for (Edge edge: edgeList) {
            if(prev == edge.getFrom().getIndex()){
                res.add(edge.getTo().getIndex());
            }else{
                prev = edge.getFrom().getIndex();
                res.add(0);
                res.add(edge.getTo().getIndex());
            }
        }

        res.add(0);
        int resSize = res.size();
        int[] finalRes = new int[resSize];
        for(int i = 0 ; i < resSize ; ++i){
            finalRes[i] = res.get(i);
        }

        return finalRes;
    }

    int[][] getAdjMatrix(){
        List<Node> listNode = getAllNodes();
        int nodeSize = listNode.size();
        int[][] res = new int[nodeSize][nodeSize];
        for(int i=0 ; i < nodeSize ; ++i) {
            for (int j = 0; j < nodeSize; ++j) {
                if(edgeList.contains(new Edge(listNode.get(i), listNode.get(j)))){
                    res[i][j] = 1;
                }else{
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    Graf getReverseGraph(){

        Graf reverseGraf = new Graf();
        for (Edge edge: edgeList) {
            reverseGraf.addEdge(edge.getTo(), edge.getFrom());
        }

        return reverseGraf;
    }

    Graf getTransitiveClosure(){

        //OMO lol
        Graf transGraf = new Graf(this.adjList, this.edgeList);
        List<Node> listNode = transGraf.getAllNodes();
        for (Node node: listNode) {
            List<Edge> currOutEdges = getOutEdges(node);
            for (Edge edge: currOutEdges) {
                transGraf = addTransitiveClosure(node, edge.getTo(), transGraf);
            }
        }
        return transGraf;
    }

    Graf addTransitiveClosure(Node from, Node curr, Graf transGraf){
        if(curr == from){
            return transGraf;
        }

        if(getOutEdges(curr) == null){
            return transGraf;
        }

        List<Edge> currOutEdges = getOutEdges(curr);
        for (Edge edge : currOutEdges) {
            transGraf.addEdge(from, edge.getTo());
            transGraf = addTransitiveClosure(curr, edge.getTo(), transGraf);
        }

        return transGraf;
    }







}

