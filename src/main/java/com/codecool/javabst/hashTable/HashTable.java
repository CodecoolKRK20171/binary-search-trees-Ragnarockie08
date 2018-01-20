package com.codecool.javabst.hashTable;

import java.util.LinkedList;

import static java.lang.Math.abs;

public class HashTable<K, V> {

    private static final int INITIAL_SIZE = 16;
    private LinkedList<HashNode<K, V>>[] array;
    private int size;

    public HashTable() {
        this.array = new LinkedList[INITIAL_SIZE];
        this.size = 0;
    }

    private int hashFunction(K key){

       return abs(key.hashCode()) % INITIAL_SIZE;

    }

    public void add(K key, V value){

        int hashCode = hashFunction(key);
        HashNode<K, V> hashNode = new HashNode<>(key, value);

        if (array[hashCode] == null){
            array[hashCode] = new LinkedList<>();
            array[hashCode].add(hashNode);
        } else {
            for (HashNode node : array[hashCode]){
                if (node.getKey().equals(key)) {
                    throw new IllegalArgumentException();
                }
            }
            array[hashCode].add(hashNode);
        }
        size++;
    }

    public V getValue(K key){

        int hashCode = hashFunction(key);

        if (array[hashCode] != null){
            LinkedList<HashNode<K, V>> list = array[hashCode];
            for (HashNode node : list){
                if (node.getKey().equals(key)){
                    return (V) node.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key){

        int index = hashFunction(key);

        if (array[index] != null) {
            LinkedList<HashNode<K, V>> list = array[index];
            for (HashNode node : list){
                if (node.getKey().equals(key)){
                    list.remove(node);
                }
            }
            size--;
        }
    }

    public void clearAll(){

        array = new LinkedList[INITIAL_SIZE];
    }

    @Override
    public String toString(){

        String output = "{";
        int index = 0;

        for (LinkedList<HashNode<K, V>> list : array){
            if (list == null){
                continue;
            }
            for (HashNode node : list ){
                if (index > 0){
                    output += ", ";
                }
                output += node.toString();
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
