import java.util.Stack;

public class Node {
    Stack<Integer> stack; //this stack represents the contents of a peg in the game. Disks must be ints
    Node next; //this will be used to more easily move nodes around the cycle
    String name; //this is used to denote the specific node

    /**
     * Initializer for Node
     * @param next the next node in the cycle
     * @param name the name of the node
     */
    Node(Node next, String name){
        this.next = next;
        this.name = name;
        this.stack = new Stack<>();
    }
}
