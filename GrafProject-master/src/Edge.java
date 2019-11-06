
/**
 * Edge est la classe qui représente les edges d'un graph
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
     * Constructeur d'un Edge
     *
     * @param from
     *      Le node de départ de l'edge
     * @param to
     *      Le node d'arrivée de l'edge
     * @param  weight
     *      le poids de l'edge
     * @param label
     *      le label de l'edge
     * @return une instance de Edge
     */
    public Edge(Node from, Node to, int weight, String label) {
        this.from = from;
        this.to = to;
    }

    /**
     * Constructeur d'un Edge
     *
     * @param from
     *      Le node de départ de l'edge
     * @param to
     *      Le node d'arrivée de l'edge
     * @return une instance de Edge
     */
    public Edge(Node from, Node to) {
        this(from, to, 0, "");
    }

    /**
     * Donne le noeud de départ d'un edge
     *
     * @return le noeud désiré
     */
    public Node getFrom() {
        return from;
    }

    /**
     * Donne le noeud d'arrivée d'un edge
     *
     * @return le noeud désiré
     */
    public Node getTo() {
        return to;
    }

    /**
     * Donne le poids de départ d'un edge
     *
     * @return le poids
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Donne le label de départ d'un edge
     *
     * @return le label
     *
     */
    public String getLabel() {
        return label;
    }

    /**
     * Définit le point de départ de l'edge courant
     *
     * @param from
     *      Le node de départ voulu pour l'edge courant
     */
    public void setFrom(Node from) {
        this.from = from;
    }

    /**
     * Définit le point d'arrivée de l'edge courant
     *
     * @param to
     *      Le node d'arrivée voulu pour l'edge courant
     */
    public void setTo(Node to) {
        this.to = to;
    }

    /**
     * Définit le poids de l'edge courant
     *
     * @param weight
     *      Le poids voulu pour l'edge courant
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }


    /**
     * Définit le label de l'edge courant
     *
     * @param label
     *      Le label voulu pour l'edge courant
     */
    public void setLabel(String label) {
        this.label = label;
    }


    /**
     * Compare l'edge courant avec un autre edge
     *
     * @param otherEdge
     *      L'edge à comparer avec l'edge courant
     *
     * @return 0 si égaux, -1 si l'edge courant est supérieur, -1 si l'edge courant est inférieur
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
     * Teste l'égualité entre deux edges
     *
     * @param object
     *      L'edge à comparer avec l'edge courant
     *
     * @return True si égaux, False sinon
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
     * Renvoie un format affichable de l'edge courant
     *
     *
     * @return la chaîne de caractères correspondant à l'edge courant
     */
    public String toString() {
        return from + " -> " + to;
    }
}
