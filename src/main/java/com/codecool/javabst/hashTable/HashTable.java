package com.codecool.javabst.hashTable;

import static java.lang.Math.abs;

public class HashTable<K, V> {

    private static final int INITIAL_SIZE = 16;
    private HashNode<K, V>[] array;
    private int size;

    public HashTable() {
        this.array = new HashNode[INITIAL_SIZE];
        this.size = size;
    }

    private int hashFunction(K key){

       return abs(key.hashCode()) % INITIAL_SIZE;

    }

    public void add(K key, V value){

        int hashCode = hashFunction(key);
        HashNode<K, V> hashNode = new HashNode<>(key, value);

        if (array[hashCode] == null){
            array[hashCode] = hashNode;
        } else {
            HashNode<K, V> temp = array[hashCode];
            while (temp.getNextNode() != null){
                temp = temp.getNextNode();
            }
            temp.setNextNode(hashNode);
        }
        size++;
    }

    public V getValue(K key){

        int hashCode = hashFunction(key);

        if (array[hashCode] != null){
            HashNode<K, V> temp = array[hashCode];

            while (!temp.getKey().equals(key) && temp.getNextNode() != null){
                temp = temp.getNextNode();
            }
            return temp.getValue();
        }
        return null;
    }

    public void remove(K key){

        int index = hashFunction(key);

        if (array[index] != null) {
            HashNode<K, V> root = array[index];
            HashNode<K, V> prev = null;

            while (!root.getKey().equals(key)) {
                    prev = root;
                    root = root.getNextNode();
            }
            if (prev != null){
                prev.setNextNode(root.getNextNode());
            } else {
                array[index] = root.getNextNode();
            }
            size--;
        }
    }

    public void clearAll(){

        array = new HashNode[INITIAL_SIZE];
    }

    @Override
    public String toString(){

        String output = "{";
        int index = 0;

        for (HashNode node : array){
            if (node == null){
                continue;
            }
            if (index > 0){
                output += ", ";
            }
            output += node.toString();
            HashNode temp = node.getNextNode();
            while (temp != null){
                output += " => " + temp.toString();
                temp = temp.getNextNode();
            }
            index++;
        }
        output += "}";

        return output;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }


}
