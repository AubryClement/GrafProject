
import java.util.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;


/**
 * Graf est la classe qui représente les objets de type Graf
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */

public class Graf {

    HashMap<Node, List<Node>> adjList;
    List<Edge> edgeList;

    /**
     * Constructeur d'un Graf
     *
     *@return une instance de Graf
     */
    public Graf() {
        this.adjList = new HashMap<Node, List<Node>>();
        this.edgeList = new ArrayList<Edge>();
    }

    /**
     * Constructeur d'un Graf
     *
     * @param adjList
     *      La liste des nodes
     * @param edgeList
     *      Le liste des edges
     *      le poids de l'edge
     *
     * @return une instance de Graf
     */
    public Graf(HashMap<Node, List<Node>> adjList, List<Edge> edgeList) {
        this.adjList = adjList;
        this.edgeList = edgeList;
    }

    /**
     * Constructeur d'un Graf
     *
     * @param succesorArray
     *      Le tableau des successeurs
     *
     * @return une instance de Graf
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
     * Ajoute un noeud dans le graf courant
     *
     * @param n
     *      Le noeud à ajouter
     *
     */
    public void addNode(Node n) {
        if (!this.adjList.containsKey(n)) {
            this.adjList.put(n, new ArrayList<Node>());
        }
    }

    /**
     * Ajoute un noeud dans le graf courant
     *
     * @param n
     *      Le noeud à ajouter
     *
     */
    public void addNode(int n) {
        Node node = new Node(n);
        this.addNode(node);
    }

    /**
     * Supprime un noeud dans le graf courant
     *
     * @param n
     *      Le noeud à supprimer
     *
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
     * Supprime un noeud dans le graf courant
     *
     * @param n
     *      Le noeud à supprimer
     *
     */
    public void removeNode(int n) {
        Node node = new Node(n);
        this.removeNode(node);
    }


    /**
     * Ajoute un edge dans le graf courant
     *
     * @param from
     *      Le noeud de départ de l'edge à ajouter
     * @param to
     *      Le noeud d'arrivée de l'edge à ajouter
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
            if (!adjList.get(from).contains(from)) {
                adjList.get(from).add(to);
            }
        }
    }

    /**
     * Ajoute un edge dans le graf courant
     *
     * @param from
     *      Le noeud de départ de l'edge à ajouter
     * @param to
     *      Le noeud d'arrivée de l'edge à ajouter
     *
     */
    public void addEdge(int from, int to) {
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        addEdge(currFrom, currTo);
    }

    /**
     * Supprime un edge dans le graf courant
     *
     * @param from
     *      Le noeud de départ de l'edge à supprimer
     * @param to
     *      Le noeud d'arrivée de l'edge à supprimer
     *
     */
    public void removeEdge(Node from, Node to) {
        Edge currEdge = new Edge(from, to);
        edgeList.remove(currEdge);
    }

    /**
     * Ajoute un edge dans le graf courant
     *
     * @param e
     *      L'edge à supprimer
     *
     */
    public void removeEdge(Edge e) {
        edgeList.remove(e);
    }

    /**
     * Ajoute un edge dans le graf courant
     *
     * @param from
     *      Le noeud de départ de l'edge à ajouter
     * @param to
     *      Le noeud d'arrivée de l'edge à ajouter
     *
     */
    public void removeEdge(int from, int to) {
        Node currFrom = new Node(from);
        Node currTo = new Node(to);
        removeEdge(currFrom, currTo);
    }

    /**
     * Donne la liste des successeurs d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les successeurs
     *
     * @return La liste des successeur du noeud n
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
     * Donne la liste des successeurs d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les successeurs
     *
     * @return La liste des successeur du noeud n
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
     * Donne la liste des edges sortants d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les noeuds sortants
     *
     * @return La liste des edges sortants du noeud n
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
     * Donne la liste des edges sortants d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les noeuds sortants
     *
     * @return La liste des edges sortants du noeud n
     */
    public List<Edge> getOutEdges(int n) {
        return getOutEdges(new Node(n));
    }

    /**
     * Donne la liste des edges entrants d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les noeuds entrants
     *
     * @return La liste des edges entrants du noeud n
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
     * Donne la liste des edges entrants d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les noeuds entrants
     *
     * @return La liste des edges entrants du noeud n
     */
    public List<Edge> getInEdges(int n) {
        return getInEdges(new Node(n));
    }

    /**
     * Donne la liste des edges entrants ou sortants d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les noeuds entrants ou sortants
     *
     * @return La liste des edges entrants ou sortants du noeud n
     */
    public List<Edge> getIncidentEdges(Node n) {
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    /**
     * Donne la liste des edges entrants ou sortants d'un noeud
     *
     * @param n
     *      Le noeud dont on souhaite les noeuds entrants ou sortants
     *
     * @return La liste des edges entrants ou sortants du noeud n
     */
    public List<Edge> getIncidentEdges(int n) {
        List<Edge> res = new ArrayList<Edge>();
        res.addAll(getInEdges(n));
        res.addAll(getOutEdges(n));
        return res;
    }

    /**
     * Donne la liste des noeuds du graf courant
     *
     *
     * @return La liste des noeuds du graf courant
     */
    public List<Node> getAllNodes() {
        List<Node> nodeList = new ArrayList<Node>();
        for (Map.Entry<Node, List<Node>> key : adjList.entrySet()) {
            nodeList.add(key.getKey());
        }
        return nodeList;
    }

    /**
     * Donne la liste des edges du graf courant
     *
     *
     * @return La liste des edges du graf courant
     */
  public List<Edge> getAllEdges() {
        return this.edgeList;
    }

    /**
     * Donne le tableau des successeurs du graf courant
     *
     *
     * @return Le tableau des successeurs
     */
    public int[] getSuccessorArray() {
        List<Integer> res = new ArrayList<Integer>();
        int prev = 0;
        for (Edge edge : edgeList) {
            prev = edge.getFrom().getIndex();
            res.add(edge.getTo().getIndex());
            break;
        }

        System.out.println("test");
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

    /**
     * Donne la matrice adjacente du graf courant
     *
     *
     * @return La matrice adjacente
     */
    public int[][] getAdjMatrix() {
        List<Node> listNode = getAllNodes();
        int nodeSize = listNode.size();
        int[][] res = new int[nodeSize][nodeSize];
        for (int i = 0; i < nodeSize; ++i) {
            for (int j = 0; j < nodeSize; ++j) {
                System.out.println(listNode.get(i));
                System.out.println(listNode.get(j));
                if (edgeList.contains(new Edge(listNode.get(i), listNode.get(j)))) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    /**
     * Donne la version inversée du graf courant
     *
     *
     * @return Le graf inversé du graf courant
     */
    public Graf getReverseGraph() {

        Graf reverseGraf = new Graf();
        for (Edge edge : edgeList) {
            reverseGraf.addEdge(edge.getTo(), edge.getFrom());
        }

        return reverseGraf;
    }

    /**
     * Donne la fermeture transitive du graf courant
     *
     *
     * @return La fermeture transitive du graf courant
     */
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

    /**
     * Ajoute l'inverse d'un edge à une liste d'edges donnée
     *
     * @param from
     *      Le noeud de départ de l'edge à inverser
     *
     * @param curr
     *      Le noeud d'arrivée de l'edge à inverser
     *
     * @param transGraf
     *      La liste à laquelle il faut ajouter l'edge inversé
     *
     * @return La liste des edges modifiée
     */
    public Graf addTransitiveClosure(Node from, Node curr, Graf transGraf) {
        if (curr == from) {
            return transGraf;
        }

        if (getOutEdges(curr) == null) {
            return transGraf;
        }
        List<Edge> currOutEdges = transGraf.getOutEdges(curr);
        for (Edge edge : currOutEdges) {
            transGraf.addEdge(from, edge.getTo());
            transGraf = addTransitiveClosure(curr, edge.getTo(), transGraf);
        }

        return transGraf;
    }

    /**
     * Donne la DFS du graf courant
     *
     *
     * @return La DFS du graf courant
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
     * Donne une partie de la DFS du graf courant (version réccursive)
     *
     *@param currList
     *      Liste des noeuds à completer durant la DFS
     *
     *@param currNode
     *      Noeud de départ pour la DFS
     *
     *
     * @return La liste completée de la DFS du graf courant
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
     * Donne la BFS du graf courant
     *
     *
     * @return La BFS du graf courant
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
     * Donne une partie de la BFS du graf courant (version réccursive)
     *
     *@param currList
     *      Liste des noeuds à completer durant la BFS
     *
     *@param currNode
     *      Noeud de départ pour la BFS
     *
     *
     * @return La liste completée de la BFS du graf courant
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
     * Renvoie le graf sous format textuel
     *
     *
     * @return Le graf sous format textuel
     */
    public String toDotString() {
        String res = "";
        for (Edge e : this.getAllEdges()) {
            res += e.getFrom() + " -> " + e.getTo() + ";\n";
        }
        return res;
    }

    /**
     * Enregistre le graf sous format DOT
     *
     *
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
     * Enregistre le graf sous format DOT
     *
     * @param path
     *      Le chemin de l'emplacement pour la sauvegarde du fichier DOT généré
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
     * Affiche le graf sous format DOT en textuel
     *
     *
     */
    public void printDotFormat(){
        String format="digraph Graf{" + this.toDotString() + "}";
        System.out.println(format);
    }

    /**
     * Convertit un fichier en format DOT en objet Graf
     *
     *@param path
     *      Chemin du fichier DOT à convertir
     *
     *
     * @return Le graf généré à partir du fichier
     */
    public static Graf fromDotFile(String path) {
        List<String> listDot = new  ArrayList<>();
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
            if (i != 0 && i != nbLineDotFile-1) {
                if (arrOfStr.length < 3) {
                    String [] arrOfStrNode = arrOfStr[1].split(";");
                    Node n1 = new Node(Integer.parseInt(arrOfStrNode[0]));
                    g.addNode(n1);
                }
                if (arrOfStr.length >= 3) {
                    String [] arrOfStrEdge = arrOfStr[3].split(";");
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


}

