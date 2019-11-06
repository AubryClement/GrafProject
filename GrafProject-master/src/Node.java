
public class Node implements Comparable<Node>{

    private int index;


    public Node(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return String.valueOf(index);
    }

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

    public int compareTo(Node otherNode){
        return this.index - otherNode.getIndex();
    }

    @Override
    public int hashCode(){
        return this.index;
    }
}
