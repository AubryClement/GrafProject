
/**
 * Edge is the class which represents the edges of a graf
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */
public class Edge implements Comparable<Edge> {
    private Node from;
    private Node to;
    private int weight;
    private String label;


    /**
     * Edge constructor
     *
     * @param from   Start node of the edge
     * @param to     End node of the edge
     * @param weight Weight of the edge
     * @param label  label of the edge
     * @return An instancy of Edge
     */
    public Edge(Node from, Node to, int weight, String label) {
        this.from = from;
        this.to = to;
    }

    /**
     * Edge constructor
     *
     * @param from Start node of the edge
     * @param to   End node of the edge
     * @return An instancy of Edge
     */
    public Edge(Node from, Node to) {
        this(from, to, 0, "");
    }

    /**
     * Give the start node of the current edge
     *
     * @return The wanted node
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Give the end node of the current edge
     *
     * @return The wanted node
     */
    public Node getTo() {
        return to;
    }

    /**
     * Give the weight of the current edge
     *
     * @return The weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Give the label of the current edge
     *
     * @return The label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set the start node of the current edge
     *
     * @param from The wanted start node for the current edge
     */
    public void setFrom(Node from) {
        this.from = from;
    }

    /**
     * Set the end node of the current edge
     *
     * @param to The wanted end node for the current edge
     */
    public void setTo(Node to) {
        this.to = to;
    }

    /**
     * Set the weight of the current edge
     *
     * @param weight The wanted weight for the current edge
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }


    /**
     * Set the label of the current edge
     *
     * @param label The wanted label for the current edge
     */
    public void setLabel(String label) {
        this.label = label;
    }


    /**
     * Compare the current edge with another edge
     *
     * @param otherEdge The edge to compare with the current one
     * @return 0 if equals, -1 if the current edge is inferior, 1 if the current edge is superior
     */
    public int compareTo(Edge otherEdge) {  //A TESTER et a COMPILER et a VOTER vive Chirac
        int otherFrom = otherEdge.getFrom().getIndex();
        int otherTo = otherEdge.getTo().getIndex();
        int thisFrom = this.from.getIndex();
        int thisTo = this.to.getIndex();
        if (thisFrom < otherFrom) {
            return -1;
        } else {
            if (thisFrom > otherFrom) {
                return 1;
            } else {
                if (thisTo < otherTo) {
                    return -1;
                } else {
                    if (thisTo > otherTo) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    /**
     * Test if two edges are equal
     *
     * @param object The edge to test with the current one
     * @return True if equals, False on the other way
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Edge) {
            Edge otherEdge = (Edge) object;
            return this.getFrom() == otherEdge.getFrom() && this.getTo() == otherEdge.getTo();
        }

        return false;
    }

    /**
     * Give the printable format of an edge
     *
     * @return The string of the edge
     */
    public String toString() {
        return from + " -> " + to;
    }
}

