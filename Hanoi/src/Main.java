import org.jetbrains.annotations.NotNull;

/**
 * <h1>Modified Towers of Hanoi</h1>
 * The assignment is as follows:
 * Solve the towers of Hanoi game for the following graph = (V ,E)
 * V = {Start, Aux1, Aux2, Aux3, Aux4, Dest}
 * E = {(Start, Aux1), (Aux1, Aux2), (Aux2, Aux3), (Aux3, Aux4), (Aux4, Aux1), (Aux1, Dest)}
 * (a) Design an algorithm and determine the time and space complexities of moving n disks from Start to Dest.
 * (b) Implement this algorithm whereby your program prints out each of the moves of every disk.
 * Show the output for n = 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 *
 * @author Timothy Chandler
 * @since 29/01/2020
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        //make the nodes of the graph
        Node start = new Node(null, "Start");
        Node node1 = new Node(null, "Node 1");
        Node node2 = new Node(null, "Node 2");
        Node node3 = new Node(null, "Node 3");
        Node node4 = new Node(null, "Node 4");
        Node dest = new Node(null, "destination");

        //next nodes are used to move disks more easily
        start.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        //placing the nodes in an array makes passing them as a parameter of the game functions easier
        Node[] node = {start, node1, node2, node3, node4, dest};

        //play the first 10 games
        for (int i = 1; i <  11; i++){
            playGame(i, node);
            node[5].stack.clear();
        }
    }

    /**
     * Moves the disk on top of home's stack to the top of destination's stack
     * @param home the place the disk is before the function call
     * @param destination the place the disk is after the function call
     */
    public static void move(@NotNull Node home, @NotNull Node destination){
        int disk = home.stack.pop();
        destination.stack.push(disk);
        System.out.println("Move disk #" + disk + " from " + home.name + " to " + destination.name);
    }

    /**
     * Moves a stack of disks from one side of a cycle to the other. From node 2 to node 4, for example.
     * @param disks: the number of disks in the stack to be moved
     * @param home: the node which the stack of disks is found
     */
    public static void moveAcross(int disks, Node home){
        if (disks == 1){
            move(home,home.next);
            move(home.next,home.next.next);
        }
        else if (disks > 1) {
            moveAcross(disks - 1, home);
            move(home, home.next);
            moveAcross(disks - 1, home.next.next);
            move(home.next, home.next.next);
            moveAcross(disks - 1, home);
        }
    }

    /**
     * Plays a game for any amount of disks by calling the load and unload functions
     * @param disks the amount of disks in this game
     * @param node the nodes on which the game shall be played
     */
    public static void playGame(int disks, @NotNull Node[] node){
        System.out.println("Playing game for " + disks + " disks:");
        for (int i = 0; i < disks; i++){
            node[0].stack.push(disks-i);
        }
        load(node);
        unload(node);
    }

    /**
     * This function moves the stack from Start to Node 4.
     * @param node the set of nodes on which the game is being played.
     */
    private static void load(@NotNull Node[] node){
        while (!node[0].stack.isEmpty()){
            if(node[0].stack.size()==1){
                move(node[0],node[1]);
                move(node[1],node[5]);
            }
            else {
                move(node[0],node[1]);
                move(node[1],node[2]);
                move(node[2],node[3]);
                moveAcross(node[4].stack.size(), node[4]);
                move(node[3],node[4]);
                moveAcross(node[2].stack.size(), node[2]);
            }
        }
    }

    /**
     * This function moves the entire stack from Node 4 to Destination.
     * @param node The set of nodes on which the game was played.
     */
    private static void unload(@NotNull Node[] node) {
        while (node[4].stack.size() != 0) {
            moveAcross(node[4].stack.size() - 1, node[4]);
            move(node[4], node[1]);
            move(node[1], node[5]);
            moveAcross(node[2].stack.size(), node[2]);
        }
        System.out.println("Completed game " + node[5].stack.size());
    }
}
/*
move across(n):
    if n=1: move it twice along the cycle
    otherwise:
        move across(n-1)
        tick the nth disk
        move across(n-1)
        tick the nth disk
        move across(n-1)

game is played in two stages:
    loading
    unloading

Loading stage:
    while disks on start:
        load top disk into 3
        move across (size of 4)
        unload 3 into 4
        move across (size of 2)

Unloading stage:
    while disks in cycle:
        move across ((size of 4)-1)
        move bottom disk from 4 to 1 to dest
        move across (size of 2)

 */