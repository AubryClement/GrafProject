import java.util.*;

public class Graf {

    HashMap<Node, List<Node>> adjList;

    public Graf() {
        this.adjList = new HashMap<>();
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

     


}

