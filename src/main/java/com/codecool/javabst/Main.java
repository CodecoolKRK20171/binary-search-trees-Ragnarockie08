package com.codecool.javabst;

import com.codecool.javabst.heap.MinHeap;
import com.codecool.javabst.tree.BinarySearchTree;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {


        MinHeap heap = new MinHeap();

        int[] array = new int[] {12, 13, 3, 24, 5};

        heap.build(array);
        System.out.println(heap.toString());
        heap.remove();
        System.out.println(heap.toString());
    }
}