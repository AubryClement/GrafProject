

/**
 * Node is the class which represents the nodes of a graf
 *
 * @author AUBRY Clément - THIEBAUD Jérémy
 * @version 1.0
 */

public class Node implements Comparable<Node> {

    private int index;

    /**
     * Node constructor
     *
     * @param index Index of the node to create
     * @return An instancy of Node
     */
    public Node(int index) {
        this.index = index;
    }

    /**
     * Give the index of the current node
     *
     * @return The index of the node
     */
    public int getIndex() {
        return index;
    }

    /**
     * Give the index of the current node in printable format
     *
     * @return The index of the node in printable format
     */
    public String toString() {
        return String.valueOf(index);
    }


    /**
     * Test if two nodes are equal
     *
     * @param object The node to test with the current one
     * @return True if equals, False on the other way
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Node) {
            Node otherNode = (Node) object;
            return this.index == otherNode.getIndex();
        }

        return false;
    }


    /**
     * Compare the current node with another node
     *
     * @param otherNode The node to compare with the current one
     * @return True if equals, False on the other way
     */
    public int compareTo(Node otherNode) {
        return this.index - otherNode.getIndex();
    }

    /**
     * Give the index of the current node
     *
     * @return The index of the current node
     */
    @Override
    public int hashCode() {
        return this.index;
    }
}
