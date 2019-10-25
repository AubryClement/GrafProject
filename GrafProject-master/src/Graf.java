
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class Graf {

    HashMap<Node, List<Node>> adjList;
    List<Edge> edgeList;

    public Graf() {
        this.adjList = new HashMap<Node, List<Node>>();
        this.edgeList = new ArrayList<Edge>();
    }

    public Graf(HashMap<Node, List<Node>> adjList, List<Edge> edgeList) {
        this.adjList = adjList;
        this.edgeList = edgeList;
    }

    public Graf(int... succesorArray) {
        this();
        if (succesorArray[(succesorArray.length) - 1] == 0) {

            int cpt = 1;
            for (int i : succesorArray) {
                if (i == 0) {
                    cpt++;
                    continue;
                }
                this.addEdge(cpt, i);
            }
        } else {
            System.out.println("Error: the succesor array must finish with a 0");
        }
    }

    public void addNode(Node n) {
        System.out.println(adjList.get(n));
        if (!this.adjList.containsKey(n)) {
            System.out.println(this.adjList.keySet());
            System.out.println(n+" : " +this.adjList.containsKey(n));
            this.adjList.put(n, new ArrayList<Node>());
        }
    }

    public void addNode(int n) {
        Node node = new Node(n);
        this.addNode(node);
    }

    public void removeNode(Node n) {
        adjList.remove(n);
        for (Map.Entry<Node, List<Node>> entry : adjList.entrySet()) {
            List<Node> currList = entry.getValue();
            currList.remove(n);
        }

        for (Edge edge : edgeList) {
            if (edge.getFrom() == n || edge.getTo() == n) {
                edgeList.remove(edge);
            }
        }

    }

    public void removeNode(int n) {
        adjList.remove(n);
        for (Map.Entry<Node, List<Node>> entry : adjList.entrySet()) {
            List<Node> currList = entry.getValue();
            currList.remove(n);
        }
        for (Edge edge : edgeList) {
            if (edge.getFrom().getIndex() == n || edge.getTo().getIndex() == n) {
                edgeList.remove(edge);
            }
        }
    }
    //TO DO TEST MA COUILLE

    //KIKKKKKKKKKKKIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    public void addEdge(Node from, Node to) {
        addNode(from);
        addNode(to);
        Edge currEdge = new Edge(from, to);
        if (!edgeList.contains(currEdge)) {
            this.edgeList.add(currEdge);
            if (!this.adjList.containsKey(from)) {
                this.adjList.put(from, new ArrayList<Node>());
            }
            if (!adjList.get(from).contains(from)) {
                adjList.get(from).add(to);
            }
        }
    }

    public void addEdge(int from, int to) {
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        addEdge(currFrom, currTo);
    }

    public void removeEdge(Node from, Node to) {
        Edge currEdge = new Edge(from, to);
        edgeList.remove(currEdge);
    }

    public void removeEdge(Edge e) {
        edgeList.remove(e);
    }

    public void removeEdge(int from, int to) {
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        removeEdge(currFrom, currTo);
    }


    public List<Node> getSuccessors(Node n) {
        List<Node> res = new ArrayList<Node>();
        for (Edge edge : edgeList) {
            if (edge.getFrom() == n) {
                res.add(edge.getTo());
            }
        }
        return res;
    }

    public List<Node> getSuccessors(int n) {
        List<Node> res = new ArrayList<Node>();
        for (Edge edge : edgeList) {
            if (edge.getFrom().getIndex() == n) {
                res.add(edge.getTo());
            }
        }
        return res;
    }

    public List<Edge> getOutEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getFrom() == n) {
                res.add(edge);
            }
        }
        return res;
    }

    public List<Edge> getOutEdges(int n) {
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getFrom().getIndex() == n) {
                res.add(edge);
            }
        }
        return res;
    }

    public List<Edge> getInEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getTo() == n) {
                res.add(edge);
            }
        }
        return res;
    }

    public List<Edge> getInEdges(int n) {
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getFrom().getIndex() == n) {
                res.add(edge);
            }
        }
        return res;
    }

    public List<Edge> getIncidentEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    public List<Edge> getIncidentEdges(int n) {
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    public List<Node> getAllNodes() {
        List<Node> nodeList = new ArrayList<Node>();
        for (Map.Entry<Node, List<Node>> key : adjList.entrySet()) {
            nodeList.add(key.getKey());
        }
        return nodeList;
    }

    public List<Edge> getAllEdges() {
        return this.edgeList;
    }

    public int[] getSuccessorArray() {
        List<Integer> res = null;
        int prev = 0;
        for (Edge edge : edgeList) {
            prev = edge.getFrom().getIndex();
            res.add(edge.getTo().getIndex());
            break;
        }

        for (Edge edge : edgeList) {
            if (prev == edge.getFrom().getIndex()) {
                res.add(edge.getTo().getIndex());
            } else {
                prev = edge.getFrom().getIndex();
                res.add(0);
                res.add(edge.getTo().getIndex());
            }
        }

        res.add(0);
        int resSize = res.size();
        int[] finalRes = new int[resSize];
        for (int i = 0; i < resSize; ++i) {
            finalRes[i] = res.get(i);
        }

        return finalRes;
    }

    public int[][] getAdjMatrix() {
        List<Node> listNode = getAllNodes();
        int nodeSize = listNode.size();
        int[][] res = new int[nodeSize][nodeSize];
        for (int i = 0; i < nodeSize; ++i) {
            for (int j = 0; j < nodeSize; ++j) {
                if (edgeList.contains(new Edge(listNode.get(i), listNode.get(j)))) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    public Graf getReverseGraph() {

        Graf reverseGraf = new Graf();
        for (Edge edge : edgeList) {
            reverseGraf.addEdge(edge.getTo(), edge.getFrom());
        }

        return reverseGraf;
    }

    public Graf getTransitiveClosure() {

        Graf transGraf = new Graf(this.adjList, this.edgeList);
        List<Node> listNode = transGraf.getAllNodes();
        for (Node node : listNode) {
            List<Edge> currOutEdges = getOutEdges(node);
            for (Edge edge : currOutEdges) {
                transGraf = addTransitiveClosure(node, edge.getTo(), transGraf);
            }
        }
        return transGraf;
    }

    public Graf addTransitiveClosure(Node from, Node curr, Graf transGraf) {
        if (curr == from) {
            return transGraf;
        }

        if (getOutEdges(curr) == null) {
            return transGraf;
        }
        System.out.println("teub");
        List<Edge> currOutEdges = transGraf.getOutEdges(curr);
        System.out.println("lol"+transGraf.adjList);
        for (Edge edge : currOutEdges) {
            System.out.println("bite");
            transGraf.addEdge(from, edge.getTo());
            transGraf = addTransitiveClosure(curr, edge.getTo(), transGraf);
        }

        return transGraf;
    }

    public List<Node> getDFS() {
        Node firstNode = this.getAllNodes().get(0);
        List<Node> res = new ArrayList<Node>();
        res.add(firstNode);
        List<Edge> currEdge = new ArrayList<Edge>();
        currEdge = this.getOutEdges(firstNode);
        for (Edge e : currEdge) {
            if (res.contains(e.getTo())) {
                continue;
            }
            res = getDFSRec(res, e.getTo());
        }
        return res;
    }

    public List<Node> getDFSRec(List<Node> currList, Node currNode) {
        currList.add(currNode);
        List<Edge> currEdge = new ArrayList<Edge>();
        currEdge = this.getOutEdges(currNode);
        for (Edge e : currEdge) {
            if (currList.contains(e.getTo())) {
                continue;
            }
            currList = getDFSRec(currList, e.getTo());
        }
        return currList;
    }

    public List<Node> getBFS() {
        Node firstNode = this.getAllNodes().get(0);
        List<Node> res = new ArrayList<Node>();
        res.add(firstNode);
        List<Edge> currEdge = new ArrayList<Edge>();
        currEdge = this.getOutEdges(firstNode);
        for (Edge e : currEdge) {
            if (res.contains(e.getTo())) {
                continue;
            }
            res.add(e.getTo());
        }
        for (Edge e : currEdge) {
            if (res.contains(e.getTo())) {
                continue;
            }
            res = getBFSRec(res, e.getTo());
        }
        return res;
    }

    public List<Node> getBFSRec(List<Node> currList, Node currNode) {
        List<Edge> currEdge = new ArrayList<Edge>();
        currEdge = this.getOutEdges(currNode);
        for (Edge e : currEdge) {
            if (currList.contains(e.getTo())) {
                continue;
            }
            currList.add(e.getTo());
        }
        for (Edge e : currEdge) {
            if (currList.contains(e.getTo())) {
                continue;
            }
            currList = getDFSRec(currList, e.getTo());
        }
        return currList;
    }

    public String toDotString() {
        String res = "";
        for (Edge e : this.getAllEdges()) {
            res += e.getFrom() + " -> " + e.getTo() + ";\n";
        }
        return res;
    }

    public void toDotFile() {
        PrintWriter writer1 = null;
        try {
            writer1 = new PrintWriter(new File("/home/AD/caubry12/DossierPartage/graf.dot"));
            writer1.write("digraph Graf{" + this.toDotString() + "}");
            writer1.flush();
            writer1.close();
        } catch (FileNotFoundException ex) {
            return;
        }
    }

    public void toDotFile(String path) {
        PrintWriter writer1 = null;
        try {
            writer1 = new PrintWriter(new File(path + "/graf.dot"));
            writer1.write("digraph Graf{" + this.toDotString() + "}");
            writer1.flush();
            writer1.close();
        } catch (FileNotFoundException ex) {
            return;
        }
    }


}

