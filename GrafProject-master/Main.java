import java.util.*;

/**
 * Main est la classe qui représente la classe principale
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */
public class Main {


    /**
     * Gère et affiche le menu utilisateur
     */
    public static void main(String[] args) {
        Graf myGraph = new Graf();
        Scanner menuChoiceScan = new Scanner(System.in);
        // print menu
        System.out.println("1. Create an empty graph");
        System.out.println("2. Add a node");
        System.out.println("3. Remove a node");
        System.out.println("4. Add an edge");
        System.out.println("5. Remove an edge");
        System.out.println("6. Get the list of all nodes");
        System.out.println("7. Get successors of a node");
        System.out.println("8. Get the list of all edges");
        System.out.println("9. Get the list of all edges leaving a node");
        System.out.println("10. Get the list of all edges entering a node");
        System.out.println("11. Get the list of all edges incident to a node");
        System.out.println("12. Get a representation of the graph in the SA (successor array) formalism");
        System.out.println("13. Get a representation of the graph as an adjacency matrix");
        System.out.println("14. Show the graph in the DOT format");
        System.out.println("15. Read the graph from a DOT file");
        System.out.println("16. Export the graph to a DOT file");
        System.out.println("17. Reverse the graph");
        System.out.println("18. Compute the transitive closure of the graph");
        System.out.println("19. Traverse the graph in DSF");
        System.out.println("20. Traverse the graph in BSF");
        System.out.println("21. Compute a random graf");
        System.out.println("22. Print the Menu");
        System.out.println("0. Quit this application");
        System.out.println("----------------------------------");

        // handle user commands
        boolean quit = false;
        boolean init = false;
        int menuItem;
        do {
            System.out.print("Choose menu item:\n");
            menuItem = menuChoiceScan.nextInt();
            switch (menuItem) {
                case 1:

                    System.out.println("You've chosen option #1 : Create an empty graph");
                    init = true;
                    myGraph = new Graf();
                    System.out.println("Done \n ----------------------------------\n");
                    break;

                case 2:
                    if (init) {
                        System.out.println("You've chosen option #2 : Add a node");
                        Scanner newNodeScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int newNodeIndex = newNodeScan.nextInt();
                        myGraph.addNode(newNodeIndex);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 3:
                    if (init) {
                        System.out.println("You've chosen option #3 : Remove a node");
                        Scanner killNodeScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node you want to delete\n");
                        int killNodeIndex = killNodeScan.nextInt();
                        myGraph.removeNode(killNodeIndex);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 4:
                    if (init) {
                        System.out.println("You've chosen option #4 : Add an edge");
                        Scanner newEdgeScan = new Scanner(System.in);
                        System.out.print("Please enter the first node of the new edge\n");
                        int newEdgeFrom = newEdgeScan.nextInt();
                        System.out.print("Please enter the second node of the new edge\n");
                        int newEdgeTo = newEdgeScan.nextInt();
                        myGraph.addEdge(newEdgeFrom, newEdgeTo);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 5:
                    if (init) {
                        System.out.println("You've chosen option #5 : Remove an edge");
                        Scanner killEdgeScan = new Scanner(System.in);
                        System.out.print("Please enter the first node of the new edge you want to delete\n");
                        int killEdgeFrom = killEdgeScan.nextInt();
                        System.out.print("Please enter the second node of the new edge you want to delete\n");
                        int killEdgeTo = killEdgeScan.nextInt();
                        myGraph.removeEdge(killEdgeFrom, killEdgeTo);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 6:
                    if (init) {
                        System.out.println("You've chosen option #6 : Get the list of all nodes");
                        List<Node> allNodesList = myGraph.getAllNodes();
                        printNodeList(allNodesList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 7:
                    if (init) {
                        System.out.println("You've chosen option #7 : Get successors of a node");
                        Scanner nodeSuccessorsScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeSuccIndex = nodeSuccessorsScan.nextInt();
                        List<Node> successorArray = myGraph.getSuccessors(nodeSuccIndex);
                        printNodeList(successorArray);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 8:
                    if (init) {
                        System.out.println("You've chosen option #8 : Get the list of all edges");
                        List<Edge> allEdgesList = myGraph.getAllEdges();
                        printEdgeList(allEdgesList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }


                case 9:
                    if (init) {
                        System.out.println("You've chosen option #9 : Get the list of all edges leaving a node");
                        Scanner nodeOutScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeOutIndex = nodeOutScan.nextInt();
                        List<Edge> myOutEdgesList = myGraph.getOutEdges(nodeOutIndex);
                        printEdgeList(myOutEdgesList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 10:
                    if (init) {
                        System.out.println("You've chosen option #10 : Get the list of all edges entering a node");
                        Scanner nodeInScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeInIndex = nodeInScan.nextInt();
                        List<Edge> myInEdgesList = myGraph.getInEdges(nodeInIndex);
                        printEdgeList(myInEdgesList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 11:
                    if (init) {
                        System.out.println("You've chosen option #11 : Get the list of all edges incident to a node");
                        Scanner nodeIncidentScan = new Scanner(System.in);
                        System.out.print("Please enter the index of the node\n");
                        int nodeIncidentIndex = nodeIncidentScan.nextInt();
                        List<Edge> myIncidentEdgesList = myGraph.getIncidentEdges(nodeIncidentIndex);
                        printEdgeList(myIncidentEdgesList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 12:
                    if (init) {
                        System.out.println("You've chosen option #12 : Get a representation of the graph in the SA (successor array) formalism");
                        int[] mySuccessorArray = myGraph.getSuccessorArray();
                        printIntArray(mySuccessorArray);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 13:
                    if (init) {
                        System.out.println("You've chosen option #13 : Get a representation of the graph as an adjacency matrix");
                        int[][] myAdjMatrix = myGraph.getAdjMatrix();
                        printIntMatrix(myAdjMatrix);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 14:
                    if (init) {
                        System.out.println("You've chosen option #14 : Show the graph in the DOT format");
                        myGraph.printDotFormat();
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 15:

                    System.out.println("You've chosen option #15 : Read the graph from a DOT file");
                    Scanner locationChoiceScan = new Scanner(System.in);
                    String dotFileLocation = locationChoiceScan.nextLine();
                    myGraph = myGraph.fromDotFile(dotFileLocation);
                    System.out.println("Done \n ----------------------------------\n");
                    break;


                case 16:
                    if (init) {
                        System.out.println("You've chosen option #16 : Export the graph to a DOT file");
                        System.out.println("Please enter the desired location of the DOT file \n");
                        Scanner locationChoiceScan2 = new Scanner(System.in);
                        String dotFileLocation2 = locationChoiceScan2.nextLine();
                        myGraph.toDotFile(dotFileLocation2);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 17:
                    if (init) {
                        System.out.println("You've chosen option #17 : Reverse the graph");
                        Graf reversedGraf = myGraph.getReverseGraph();
                        myGraph = reversedGraf;
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 18:
                    if (init) {
                        System.out.println("You've chosen option #18 : Compute the transitive closure of the graph");
                        Graf transitiveClosureGraf = myGraph.getTransitiveClosure();
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 19:
                    if (init) {
                        System.out.println("You've chosen option #19: Traverse the graph in DSF");
                        List<Node> dsfList = myGraph.getDFS();
                        printNodeList(dsfList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 20:
                    if (init) {
                        System.out.println("You've chosen option #20 : Traverse the graph in BSF");
                        List<Node> bsfList = myGraph.getBFS();
                        printNodeList(bsfList);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }


                case 21:
                    if (init) {
                        System.out.println("You've chosen option #21: Compute a random graf");

                        Scanner minNodeScan = new Scanner(System.in);
                        System.out.print("Please enter the min amount of nodes you want\n");
                        int minOfNodes = minNodeScan.nextInt();

                        Scanner maxNodeScan = new Scanner(System.in);
                        System.out.print("Please enter the max amount of nodes you want\n");
                        int maxOfNodes = maxNodeScan.nextInt();

                        Scanner minEdgeScan = new Scanner(System.in);
                        System.out.print("Please enter the min amount of edges you want\n");
                        int minOfEdges = minEdgeScan.nextInt();

                        Scanner maxEdgeScan = new Scanner(System.in);
                        System.out.print("Please enter the max amount of edges you want\n");
                        int maxOfEdges = maxEdgeScan.nextInt();


                        myGraph = myGraph.generateRandomGraf(minOfNodes, maxOfNodes, minOfEdges, maxOfEdges);
                        System.out.println("Done \n ----------------------------------\n");
                        break;
                    } else {
                        System.out.println("Error: Please ask for the creation of an empty graph first");
                        break;

                    }

                case 22:
                    System.out.println("1. Create an empty graph");
                    System.out.println("2. Add a node");
                    System.out.println("3. Remove a node");
                    System.out.println("4. Add an edge");
                    System.out.println("5. Remove an edge");
                    System.out.println("6. Get the list of all nodes");
                    System.out.println("7. Get successors of a node");
                    System.out.println("8. Get the list of all edges");
                    System.out.println("9. Get the list of all edges leaving a node");
                    System.out.println("10. Get the list of all edges entering a node");
                    System.out.println("11. Get the list of all edges incident to a node");
                    System.out.println("12. Get a representation of the graph in the SA (successor array) formalism");
                    System.out.println("13. Get a representation of the graph as an adjacency matrix");
                    System.out.println("14. Show the graph in the DOT format");
                    System.out.println("15. Read the graph from a DOT file");
                    System.out.println("16. Export the graph to a DOT file");
                    System.out.println("17. Reverse the graph");
                    System.out.println("18. Compute the transitive closure of the graph");
                    System.out.println("19. Traverse the graph in DSF");
                    System.out.println("20. Traverse the graph in BSF");
                    System.out.println("21. Print the Menu");
                    System.out.println("0. Quit this application");
                    System.out.println("----------------------------------");
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

    public static Graf initialisation(Graf myGraph) {
        return myGraph = new Graf();

    }


    /**
     * Affiche une liste de noeuds
     *
     * @param myList liste de noeuds à afficher
     */
    private static void printNodeList(List<Node> myList) {
        System.out.print("[ ");
        for (int i = 0; i < myList.size(); ++i) {
            if (i == myList.size() - 1) {
                System.out.print(myList.get(i));
                break;
            }
            System.out.print(myList.get(i) + " ; ");
        }
        System.out.println(" ]");
    }


    /**
     * Affiche une liste d'edges
     *
     * @param myList liste d'edges à afficher
     */
    private static void printEdgeList(List<Edge> myList) {
        System.out.print("[ ");
        for (int i = 0; i < myList.size(); ++i) {
            if (i == myList.size() - 1) {
                System.out.print(myList.get(i).getFrom() + "->" + myList.get(i).getTo());
                break;
            }
            System.out.print(myList.get(i).getFrom() + "->" + myList.get(i).getTo() + " ; ");
        }
        System.out.println(" ]");
    }

    /**
     * Affiche un tableau d'entiers
     *
     * @param myArray tableau d'entiers à afficher
     */
    private static void printIntArray(int[] myArray) {
        int size = myArray.length;
        if (size > 0) {
            System.out.print("[" + myArray[0] + "; ");
            for (int i = 1; i < size - 2; ++i) {
                System.out.print(myArray[i] + "; ");
            }
            System.out.println(myArray[size - 1] + "]");

        } else {
            System.out.println("[]");
        }
    }

    /**
     * Affiche une matrice d'entiers
     *
     * @param myArray matrice d'entiers à afficher
     */
    private static void printIntMatrix(int[][] myMatrix) {
        int columns = myMatrix[0].length;
        int rows = myMatrix.length;
        if (columns > 0 && rows > 0 && columns == rows) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(myMatrix[i][j] + " ");
                }
                System.out.println(" ");
            }

        } else {
            System.out.println("[]");
        }
    }
}
