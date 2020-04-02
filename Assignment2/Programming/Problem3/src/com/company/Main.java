package com.company;

import java.util.Random;

class Main{

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        Random rand = new Random();
        int largeNum = 10000000;
        int nodes = 0;
        float insertTime = 0;
        float deleteTime = 0;
        int insertions = 0;
        int deletions = 0;

        for (int i = 0; i < 25; i++) {
            float startTime = System.nanoTime();
            tree.root = tree.insert(tree.root, rand.nextInt(300));
            insertTime += System.nanoTime() - startTime;
            nodes++;
            insertions++;
        }
        for (int i = 0; i< largeNum; i++){
            if (rand.nextInt(2)==1){
                float startTime = System.nanoTime();
                tree.root = tree.insert(tree.root, rand.nextInt(300));
                insertTime += System.nanoTime()-startTime;
                nodes++;
                insertions++;
            } else {
                float startTime = System.nanoTime();
                tree.root = tree.deleteNode(tree.root, rand.nextInt(300));
                deleteTime += System.nanoTime()-startTime;
                nodes--;
                deletions++;
            }
            if (nodes > 50){
                float startTime = System.nanoTime();
                tree.root = tree.deleteNode(tree.root, rand.nextInt(300));
                deleteTime += System.nanoTime()-startTime;
                nodes--;
                deletions++;
            }
        }
        System.out.println(insertions+" insertions took "+insertTime+", averaging "+(insertTime/insertions)+" each");
        System.out.println(deletions+" deletions took "+deleteTime+", averaging "+(deleteTime/deletions)+" each");
    }
}
// This code has been contributed by Mayank Jaiswal