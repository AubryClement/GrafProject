/**
 * UndirectedGraf est la classe qui représente les grafs non orientés
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class UndirectedGraf extends Graf {

    /**
     * Add an undirected edge in the current graf
     *
     * @param from
     *      Start node of the edge to add
     * @param to
     *      End node of the edge to add
     *
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
            List<Node> listNode = adjList.get(from);
            if (!listNode.contains(to)) {
                listNode.add(to);
            }
        }
        currEdge = new Edge(to, from);
        if (!edgeList.contains(currEdge)) {
            this.edgeList.add(currEdge);
            if (!this.adjList.containsKey(to)) {
                this.adjList.put(to, new ArrayList<Node>());
            }
            List<Node> listNode = adjList.get(to);
            if (!listNode.contains(from)) {
                listNode.add(from);
            }
        }
    }


}