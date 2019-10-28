import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SwitchOperatedTextMenu();
        //Graf g = new Graf();
        //g.addEdge(1, 2);
        //g.addEdge(1, 3);
        //g.addEdge(2, 2);
        //g.addEdge(2, 4);
        //g.addEdge(4, 5);
        //g.addEdge(4, 6);
        //g.addEdge(6, 7);
        //System.out.println(g.adjList.get(1));
        //System.out.println(g.getAllNodes());
        //String s = g.toDotString();
        //System.out.println(s);
        //g.toDotFile();
        //Graf f = g.getTransitiveClosure();
        //s = f.toDotString();
        //System.out.println(s);
    }


    public class SwitchOperatedTextMenu {
        public static void main(String[] args) {
            Scanner menuChoiceScan = new Scanner(System.in);
            // print menu
            System.out.println("1. Create an empty graph\n");
            System.out.println("2. Add a node\n");
            System.out.println("3. Remove a node\n");
            System.out.println("4. Add an edge\n");
            System.out.println("5. Remove an edge\n");
            System.out.println("6. Get the list of all nodes \n");
            System.out.println("7. Get successors of a node\n");
            System.out.println("8. Get the list of all edges \n");
            System.out.println("9. Get the list of all edges leaving a node\n");
            System.out.println("10. Get the list of all edges entering a node\n");
            System.out.println("11. Get the list of all edges incident to a node\n");
            System.out.println("12. Get a representation of the graph in the SA (successor array) formalism\n");
            System.out.println("13. Get a representation of the graph as an adjacency matrix\n");
            System.out.println("14. Show the graph in the DOT format\n");
            System.out.println("15. Read the graph from a DOT file\n");
            System.out.println("16. Export the graph to a DOT file\n");
            System.out.println("17. Reverse the graph\n");
            System.out.println("18. Compute the transitive closure of the graph\n");
            System.out.println("19. Traverse the graph in DSF\n");
            System.out.println("20. Traverse the graph in BSF\n");
            System.out.println("0. Quit this application\n");

            // handle user commands
            boolean quit = false;
            int menuItem;
            do {
                System.out.print("Choose menu item:\n");
                menuItem = menuChoiceScan.nextInt();
                switch (menuItem) {
                    case 1:
                        System.out.println("You've chosen option #1 : Create an empty graph\n");
                        Graf myGraph = new Graf();
                        System.out.println("Done \n");
                        break;

                    case 2:
                        System.out.println("You've chosen option #2 : Add a node\n");
                        Scanner newNodeScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int newNodeIndex = newNodeScan.nextInt();
                        myGraph.addNode(newNodeIndex);
                        System.out.println("Done \n");
                        break;

                    case 3:
                        System.out.println("You've chosen option #3 : Remove a node\n");
                        Scanner killNodeScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node you want to delete\n");
                        int killNodeIndex = killNodeScan.nextInt();
                        myGraph.removeNode(killNodeIndex);
                        System.out.println("Done \n");
                        break;

                    case 4:
                        System.out.println("You've chosen option #4 : Add an edge\n");
                        Scanner newEdgeScan = new Scanner(System.in);
                        System.out.print("Please enter the first node of the new edge\n");
                        int newEdgeFrom = newEdgeScan.nextInt();
                        System.out.print("Please enter the first node of the new edge\n");
                        int newEdgeTo = newEdgeScan.nextInt();
                        myGraph.addNode(newEdgeFrom, newEdgeTo);
                        System.out.println("Done \n");
                        break;

                    case 5:
                        System.out.println("You've chosen option #5 : Remove an edge\n");
                        Scanner newEdgeScan = new Scanner(System.in);
                        System.out.print("Please enter the first node of the new edge you want to delete\n");
                        int killEdgeFrom = newEdgeScan.nextInt();
                        System.out.print("Please enter the first node of the new edge you want to delete\n");
                        int killEdgeTo = newEdgeScan.nextInt();
                        myGraph.removeNode(killEdgeFrom, killEdgeTo);
                        System.out.println("Done \n");
                        break;

                    case 6:
                        System.out.println("You've chosen option #6 : Get the list of all nodes\n");
                        List<Node> allNodesList = myGraph.getAllNodes();
                        System.out.println("Done \n");
                        break;

                    case 7:
                        System.out.println("You've chosen option #7 : Get successors of a node\n");
                        Scanner nodeSuccessorsScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeSuccIndex = nodeSuccessorsScan.nextInt();
                        int[] successorArray = myGraph.getSuccessorsArray(nodeSuccIndex);
                        System.out.println("Done \n");
                        break;

                    case 8:
                        System.out.println("You've chosen option #8 : Get the list of all edges\n");
                        List<Edge> allEdgesList = myGraph.getAllEdges();
                        System.out.println("Done \n");
                        break;


                    case 9:
                        System.out.println("You've chosen option #9 : Get the list of all edges leaving a node\n");
                        Scanner nodeOutScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeOutIndex = nodeOutScan.nextInt();
                        List<Edge> myOutEdgesList = myGraph.getOutEdges(nodeOutIndex);
                        System.out.println("Done \n");
                        break;

                    case 10:
                        System.out.println("You've chosen option #10 : Get the list of all edges entering a node\n");
                        Scanner nodeInScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeInIndex = nodeInScan.nextInt();
                        List<Edge> myInEdgesList = myGraph.getInEdges(nodeInIndex);
                        System.out.println("Done \n");
                        break;

                    case 11:
                        System.out.println("You've chosen option #11 : Get the list of all edges incident to a node\n");
                        Scanner nodeIncidentScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeIncidentIndex = nodeIncidentScan.nextInt();
                        List<Edge> myIncidentEdgesList = myGraph.getIncidentEdges(nodeIncidentIndex);
                        System.out.println("Done \n");
                        break;

                    case 12:
                        System.out.println("You've chosen option #12 : Get a representation of the graph in the SA (successor array) formalism\n");
                        int[] mySuccessorArray = myGraph.getSuccessorArray();
                        System.out.println("Done \n");
                        break;

                    case 13:
                        System.out.println("You've chosen option #13 : Get a representation of the graph as an adjacency matrix\n");
                        int[][] myAdjMatrix = myGraph.getAdjMatrix();
                        System.out.println("Done \n");
                        break;

                    case 14:
                        System.out.println("You've chosen option #14 : Show the graph in the DOT format\n");
                        System.out.println("Done \n");
                        break;

                    case 15:
                        System.out.println("You've chosen option #15 : Read the graph from a DOT file\n");
                        System.out.println("Done \n"); //TODO
                        break;

                    case 16:
                        System.out.println("You've chosen option #16 : Export the graph to a DOT file\n");
                        System.out.println("Please enter the desired location of the DOT file \n");
                        Scanner locationChoiceScan = new Scanner(System.in);
                        String dotFileLocation = killEdgeScan.nextLine();
                        myGraph.toDotFile(dotFileLocation);
                        System.out.println("Done \n");
                        System.out.println("Done \n");
                        break;

                    case 17:
                        System.out.println("You've chosen option #17 : Reverse the graph");
                        Graf reversedGraf = myGraph.getReverseGraph();
                        System.out.println("Done \n");
                        break;

                    case 18:
                        System.out.println("You've chosen option #18 : Compute the transitive closure of the graph");
                        Graf transitiveClosureGraf = myGraph.getTransitiveClosure();
                        System.out.println("Done \n");
                        break;

                    case 19:
                        System.out.println("You've chosen option #19: Traverse the graph in DSF");
                        List<Node> dsfList = myGraph.getDFS();
                        System.out.println("Done \n");
                        break;

                    case 20:
                        System.out.println("You've chosen option #20 : Traverse the graph in BSF");
                        List<Node> bsfList = myGraph.getBFS();
                        System.out.println("Done \n");
                        break;

                    case 0:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (!quit);
            System.out.println("Bye-bye!");
        }
    }
}
