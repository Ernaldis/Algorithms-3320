import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) {
        //make the nodes of the graph
        Node start = new Node(null, "Start");
        Node node1 = new Node(null, "Node 1");
        Node node2 = new Node(null, "Node 2");
        Node node3 = new Node(null, "Node 3");
        Node node4 = new Node(null, "Node 4");
        Node dest = new Node(null, "destination");

        start.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        Node[] node = {start, node1, node2, node3, node4, dest};

        //play the first 10 games
        /*for (int i = 1; i <  11; i++){
            playGame(i, node);
            for (int j = 0; j < 6; j++) {
                node[j].stack.clear();
            }
        }*/
        playGame(10, node);

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
    move across(n-1)
    tick the nth disk
    move across(n-1)
    tick the nth disk
    move across(n-1)

Loading stage:
    while disk on start:
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