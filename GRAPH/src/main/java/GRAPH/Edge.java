package GRAPH;

public class Edge implements Comparable<Edge> {
    private Node from;
    private Node to;
    private int weight;
    private String labelCouille;

    public Edge(Node from, Node to, int weight, String labelCouille) {
        this.from = from;
        this.to = to;
    }

    public Edge(Node from, Node to){
        new Edge(from, to, 0, "");
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public String getLabelCouille() {
        return labelCouille;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setLabelCouille(String labelCouille) {
        this.labelCouille = labelCouille;
    }

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
}
