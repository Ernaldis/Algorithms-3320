package com.company;

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        int m = 0;
        key = d;
        height = 1;
        if (d%3==0){
            m = 2^20;
        }
        if (d%3==1){
            m =2^19-2^18;
        }if (d%3==2){
            m =2^18-2^17;
        }
        int[][] array = new int[m][m];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                array[i][j]=1;
            }
        }
    }
}