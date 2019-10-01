package GRAPH;

public class Node {

    private int index;
    private String name;


    public Node(int index) {
        this.index = index;
        this.name = String.valueOf(index);
    }

    public Node(int index, String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName(){
        return name;
    }
}
