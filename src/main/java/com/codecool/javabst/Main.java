package com.codecool.javabst;

import com.codecool.javabst.hashTable.HashNode;
import com.codecool.javabst.hashTable.HashTable;
import com.codecool.javabst.heap.MinHeap;
import com.codecool.javabst.tree.BinarySearchTree;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {


        HashTable<String, Integer> map = new HashTable<>();

        map.add("dupa", 5);
        map.add("pierogi", 10);
        map.add("salata", 5);
        map.add("auto", 10);
        map.add("samochod", 15);
        map.add("woda", 10);

        System.out.println(map);
        System.out.println(map.getValue("auto"));
//
//        MinHeap heap = new MinHeap();
//
//        for (int i = 10; i > 0; i--){
//            heap.add(i);
//        }
//
//        System.out.println(heap);




    }
}