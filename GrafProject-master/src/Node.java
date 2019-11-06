/**
 * Node est la classe qui représente les noeuds d'un graf
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */

public class Node implements Comparable<Node>{

    private int index;

    /**
     * Constructeur d'un noeud
     *
     * @param index
     *      L'index du noeud à créér
     *
     *@return Une instance de Node
     */
    public Node(int index) {
        this.index = index;
    }

    /**
     * Donne l'index du noeud courant
     *
     * @return L'index du noeud courant
     */
    public int getIndex() {
        return index;
    }

    /**
     * Donne l'index du noeud courant sous forme d'une String
     *
     * @return L'index du noeud courant sous forme d'une String
     */
    public String toString() {
        return String.valueOf(index);
    }


    /**
     * Teste l'égualité entre deux noeuds
     *
     * @param object
     *      Le noeud à comparer avec le noeud courant
     *
     * @return 0 si égaux, -1 si le noeud courant est supérieur, -1 si le noeud courant est inférieur
     */
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object instanceof Node) {
            Node otherNode = (Node) object;
            return this.index == otherNode.getIndex();
        }

        return false;
    }


    /**
     * Compare le noeud courant avec un autre noeud
     * @param otherNode
     *      Le noeud à comparer avec le noeud courant
     *
     * @return True si égaux, False sinon
     */
    public int compareTo(Node otherNode){
        return this.index - otherNode.getIndex();
    }

    /**
     * Donne l'index du noeud courant
     *
     * @return L'index du noeud courant
     */
    @Override
    public int hashCode(){
        return this.index;
    }
}
