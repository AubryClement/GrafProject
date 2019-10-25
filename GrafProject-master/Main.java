public class Main {

    public static void main(String[] args) {

        Graf g = new Graf();
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,2);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(6,7);
        System.out.println(g.adjList.get(1));
        //System.out.println(g.getAllNodes());
        String s = g.toDotString();
        System.out.println(s);
        //g.toDotFile();
        //Graf f = g.getTransitiveClosure();
        //s = f.toDotString();
        //System.out.println(s);
    }
}
