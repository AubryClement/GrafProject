
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Graf is the class which represents the Graf
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */

public class Graf {

    HashMap<Node, List<Node>> adjList;
    List<Edge> edgeList;

    /**
     * Graf constructor
     *
     * @return An instancy of Graf
     */
    public Graf() {
        this.adjList = new HashMap<Node, List<Node>>();
        this.edgeList = new ArrayList<Edge>();
    }

    /**
     * Graf constructor
     *
     * @param adjList  The list of the nodes
     * @param edgeList The list of the edges
     * @return An instancy of Graf
     */
    public Graf(HashMap<Node, List<Node>> adjList, List<Edge> edgeList) {
        this.adjList = adjList;
        this.edgeList = edgeList;
    }

    /**
     * Graf constructor
     *
     * @param succesorArray The array of the successors
     * @return An instancy of Graf
     */
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

    /**
     * Add a node in the current graf
     *
     * @param n The node to add
     */
    public void addNode(Node n) {
        if (!this.adjList.containsKey(n)) {
            this.adjList.put(n, new ArrayList<Node>());
        }
    }

    /**
     * Add a node in the current graf
     *
     * @param n The node to add
     */
    public void addNode(int n) {
        Node node = new Node(n);
        this.addNode(node);
    }

    /**
     * Delete a node in the current graf
     *
     * @param n The node to delete
     */
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

    /**
     * Delete a node in the current graf
     *
     * @param n The node to delete
     */
    public void removeNode(int n) {
        Node node = new Node(n);
        this.removeNode(node);
    }


    /**
     * Add an edge in the current graf
     *
     * @param from The start node of the edge to add
     * @param to   The end node of the edge to add
     */
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

    /**
     * Add an edge in the current graf
     *
     * @param from The start node of the edge to add
     * @param to   The end node of the edge to add
     */
    public void addEdge(int from, int to) {
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        addEdge(currFrom, currTo);
    }

    /**
     * Delete an edge in the current graf
     *
     * @param from The start node of the edge to add
     * @param to   The end node of the edge to add
     */
    public void removeEdge(Node from, Node to) {
        Edge currEdge = new Edge(from, to);
        edgeList.remove(currEdge);
    }

    /**
     * Delete an edge in the current graf
     *
     * @param e The edge to delete
     */
    public void removeEdge(Edge e) {
        edgeList.remove(e);
    }

    /**
     * Delete an edge in the current graf
     *
     * @param from The start node of the edge to delete
     * @param to   The end node of the edge to delete
     */
    public void removeEdge(int from, int to) {
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        removeEdge(currFrom, currTo);
    }

    /**
     * Give the list of the successors of a node
     *
     * @param n The source node of the list
     * @return The list of the successors of the node n
     */
    public List<Node> getSuccessors(Node n) {
        List<Node> res = new ArrayList<Node>();
        for (Edge edge : edgeList) {
            if (edge.getFrom() == n) {
                res.add(edge.getTo());
            }
        }
        return res;
    }

    /**
     * Give the list of the successors of a node
     *
     * @param n The source node of the list
     * @return The list of the successors of the node n
     */
    public List<Node> getSuccessors(int n) {
        List<Node> res = new ArrayList<Node>();
        for (Edge edge : edgeList) {
            if (edge.getFrom().getIndex() == n) {
                res.add(edge.getTo());
            }
        }
        return res;
    }

    /**
     * Give the list of the outgoing edges of a node
     *
     * @param n The source node of the list
     * @return The list of the outgoing edges of the node n
     */
    public List<Edge> getOutEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getFrom().equals(n)) {
                res.add(edge);
            }
        }
        return res;
    }

    /**
     * Give the list of the outgoing edges of a node
     *
     * @param n The source node of the list
     * @return The list of the outgoing edges of the node n
     */
    public List<Edge> getOutEdges(int n) {
        return getOutEdges(new Node(n));
    }

    /**
     * Give the list of the ingoing edges of a node
     *
     * @param n The source node of the list
     * @return The list of the ingoing edges of the node n
     */
    public List<Edge> getInEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        for (Edge edge : edgeList) {
            if (edge.getTo().equals(n)) {
                res.add(edge);
            }
        }
        return res;
    }

    /**
     * Give the list of the ingoing edges of a node
     *
     * @param n The source node of the list
     * @return The list of the ingoing edges of the node n
     */
    public List<Edge> getInEdges(int n) {
        return getInEdges(new Node(n));
    }

    /**
     * Give the list of the ingoing edges of a node
     *
     * @param n The source node of the list
     * @return The list of the ingoing edges of the node n
     */
    public List<Edge> getIncidentEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    /**
     * The list of the ingoing or outgoing edges of the node n
     *
     * @param n The source node of the list
     * @return The list of the ingoing or outgoing edges of the node n
     */
    public List<Edge> getIncidentEdges(int n) {
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    /**
     * Give the list of the nodes of the current graf
     *
     * @return The list of the nodes of the current graf
     */
    public List<Node> getAllNodes() {
        List<Node> nodeList = new ArrayList<Node>();
        for (Map.Entry<Node, List<Node>> key : adjList.entrySet()) {
            nodeList.add(key.getKey());
        }
        return nodeList;
    }

    /**
     * Give the list of the edges of the current graf
     *
     * @return The list of the edges of the current graf
     */
    public List<Edge> getAllEdges() {
        return this.edgeList;
    }

    /**
     * Give the successors array of the graf
     *
     * @return The successors array
     */
    public int[] getSuccessorArray() {
        List<Integer> res = new ArrayList<Integer>();
        List<Node> listOfNodes = this.getAllNodes();
        for (Node node : listOfNodes) {
            List<Edge> listOfOutGoingEdges = this.getOutEdges(node);
            Collections.sort(listOfOutGoingEdges);
            for (Edge e : listOfOutGoingEdges) {
                res.add(e.getTo().getIndex());
            }
            res.add(0);
        }
        int[] finalRes = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    /**
     * Give the adjency matrix of the current graf
     *
     * @return The adjency matrix
     */
    public int[][] getAdjMatrix() {
        List<Node> listNode = getAllNodes();
        int nodeSize = listNode.size();
        int[][] res = new int[nodeSize][nodeSize];
        for (int i = 0; i < nodeSize; i++) {
            for (int j = 0; j < nodeSize; j++) {
                res[i][j] = 0;

            }
        }
        for (Edge e : this.edgeList) {
            int from = listNode.indexOf(e.getFrom());
            int to = listNode.indexOf(e.getTo());
            res[from][to] = 1;
        }
        return res;


    }

    /**
     * Give the reverse graf
     *
     * @return The reverse graf
     */
    public Graf getReverseGraph() {

        Graf reverseGraf = new Graf();
        for (Edge edge : edgeList) {
            reverseGraf.addEdge(edge.getTo(), edge.getFrom());
        }

        return reverseGraf;
    }

    /**
     * Give the transitive closure
     *
     * @return The transitive closure
     */
    public Graf getTransitiveClosure() {
        Graf transGraf = new Graf(this.adjList, this.edgeList);
        List<Node> listNode = transGraf.getAllNodes();
        for (Node node : listNode) {
            List<Edge> currOutEdges = getOutEdges(node);
            List<Node> visitedNodes = new ArrayList<Node>();
            for (Edge edge : currOutEdges) {

                transGraf = addTransitiveClosure(node, edge.getTo(), transGraf, visitedNodes);
            }
        }
        for (Edge e : transGraf.getAllEdges()) {
            System.out.println(e.toString());
        }
        return transGraf;
    }

    /**
     * Reccursive call to compute the transitive closure of a graf
     *
     * @param from      The previous source node
     * @param curr      The new strat point for the transitive closure
     * @param transGraf The source list to complete
     * @return The completed list
     */
    public Graf addTransitiveClosure(Node from, Node curr, Graf transGraf, List<Node> visitedNodes) {
        if (curr == from || visitedNodes.contains(curr)) {
            return transGraf;
        }
        visitedNodes.add(curr);
        if (getOutEdges(curr) == null) {
            return transGraf;
        }
        List<Edge> currOutEdges = transGraf.getOutEdges(curr);
        for (Edge edge : currOutEdges) {
            if (from.getIndex() != edge.getTo().getIndex()) {
                transGraf.addEdge(from, edge.getTo());
            }
            transGraf = addTransitiveClosure(curr, edge.getTo(), transGraf, visitedNodes);
        }

        return transGraf;
    }

    /**
     * Give the DFS of the current graf
     *
     * @return The DFS of the graf
     */
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

    /**
     * Give a part of the DFS of the current graf (reccursive version)
     *
     * @param currList The list to complete
     * @param currNode Start point of the DFS
     * @return The completed list of the DFS
     */
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

    /**
     * Give the BFS of the current graf
     *
     * @return The BFS of the graf
     */
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

    /**
     * Give a part of the BFS of the current graf (reccursive version)
     *
     * @param currList The list to complete
     * @param currNode Start point of the BFS
     * @return The completed list of the BFS
     */
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

    /**
     * Give the printable format of the current graf
     *
     * @return The printable format of the graf
     */
    public String toDotString() {
        String res = "";
        for (Edge e : this.getAllEdges()) {
            res += e.getFrom() + " -> " + e.getTo() + ";\n";
        }
        return res;
    }

    /**
     * Register the current graf in DOT Format
     */
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

    /**
     * Register the current graf in DOT Format
     *
     * @param path The path where to save the DOT file
     */
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

    /**
     * Print the DOT format of the current graf
     */
    public void printDotFormat() {
        String format = "digraph Graf{" + this.toDotString() + "}";
        System.out.println(format);
    }

    /**
     * Import a graf from a DOT file
     *
     * @param path Path of the DOT file
     * @return The computed graf
     */
    public static Graf fromDotFile(String path) {
        List<String> listDot = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                listDot.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error. Could not open the dot file.");
        }

        int nbLineDotFile = listDot.size();
        Graf g = null;


        for (int i = 0; i < nbLineDotFile; i++) {
            if (listDot.get(i).equals("\n")) {
                continue;
            }
            if (i == 0) {
                String[] line1 = listDot.get(i).split(" ");
                if (line1[0].equals("digraph")) {
                    g = new Graf();
                }
                if (line1[0].equals("graph")) {
                    g = new UndirectedGraf();
                }
            }
            String[] arrOfStr = listDot.get(i).split(" ");
            if (i != 0 && i != nbLineDotFile - 1) {
                if (arrOfStr.length < 3) {
                    String[] arrOfStrNode = arrOfStr[1].split(";");
                    Node n1 = new Node(Integer.parseInt(arrOfStrNode[0]));
                    g.addNode(n1);
                }
                if (arrOfStr.length >= 3) {
                    String[] arrOfStrEdge = arrOfStr[3].split(";");
                    Node n1 = new Node(Integer.parseInt(arrOfStr[1]));
                    Node n2 = new Node(Integer.parseInt(arrOfStrEdge[0]));
                    g.addNode(n1);
                    g.addNode(n2);
                    g.addEdge(n1, n2);
                }
            }
        }

        return g;
    }


    /**
     * Compute a random graf
     *
     * @param minOfNodes Minimal wanted amount of nodes
     * @param maxOfNodes Maximal wanted amount of nodes
     * @param minOfEdges Minimal wanted amount of edges
     * @param maxOfEdges Maximal wanted amount of edges
     * @return The randomly computed graf
     */
    public static Graf generateRandomGraf(int minOfNodes, int maxOfNodes, int minOfEdges, int maxOfEdges) {
        Graf randomGraf = new Graf();

        if (minOfNodes == 0 && maxOfNodes == 0) {
            return randomGraf;
        }
        //GENERATE AMOUNT OF NODES OF THE GRAF
        Random r = new Random();
        int amountOfNodes;
        if (minOfNodes >= maxOfNodes) {
            amountOfNodes = r.nextInt((minOfNodes - maxOfNodes) + 1) + maxOfNodes;
        } else {
            amountOfNodes = r.nextInt((maxOfNodes - minOfNodes) + 1) + minOfNodes;
        }
        if (amountOfNodes == 0) {
            return randomGraf;
        }
        //ADD THE NODES TO THE GRAF
        for (int i = 1; i < amountOfNodes + 1; ++i) {
            randomGraf.addNode(i);
        }

        if (minOfEdges == 0 && maxOfEdges == 0) {
            return randomGraf;
        }
        //GENERATE AMOUNT OF EDGES OF THE GRAF
        int amountOfEdges;
        if (minOfEdges >= maxOfEdges) {
            amountOfEdges = r.nextInt((minOfEdges - maxOfEdges) + 1) + maxOfEdges;
        } else {
            amountOfEdges = r.nextInt((maxOfEdges - minOfEdges) + 1) + minOfEdges;
        }
        if (amountOfEdges == 0) {
            return randomGraf;
        }
        //ADD THE EDGES TO THE GRAF
        int randomFrom;
        int randomTo;

        for (int i = 0; i < amountOfEdges; ++i) {


            randomFrom = r.nextInt((amountOfNodes - 1) + 1) + 1;
            randomTo = r.nextInt((amountOfNodes - 1) + 1) + 1;
            randomGraf.addEdge(randomFrom, randomTo);
        }

        return randomGraf;

    }


    /**
     * Test if two grafs are equal
     *
     * @param object The graf to test with the current one
     * @return True if equals, False on the other way
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Graf) {
            Graf otherGraf = (Graf) object;
            return Arrays.equals(this.getSuccessorArray(), otherGraf.getSuccessorArray());
        }

        return false;
    }


}

