package com.company;

import java.util.Random;

class Main{

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        Random rand = new Random();
        int largeNum = 10000000;
        int nodes = 0;

        float startTime = System.nanoTime();
        for (int i = 0; i< largeNum; i++){
            if (rand.nextInt(2)==1){
                tree.root = tree.insert(tree.root, rand.nextInt(300));
                nodes += 1;
            } else {
                tree.root = tree.deleteNode(tree.root, rand.nextInt(300));
                nodes -= 1;
            }
            while (nodes > 50){
                tree.root = tree.deleteNode(tree.root, rand.nextInt(300));
                nodes -=1;
            }
        }
        float endTime = System.nanoTime();
        System.out.println(" Completed in "+(endTime-startTime)/1000000000+" seconds");
    }
}
// This code has been contributed by Mayank Jaiswal