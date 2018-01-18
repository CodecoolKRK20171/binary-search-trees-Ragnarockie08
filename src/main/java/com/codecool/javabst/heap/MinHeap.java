package com.codecool.javabst.heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class MinHeap {


    private int[] data;
    private int size;

    public MinHeap() {
        this.data = new int[0];
        size = 0;
    }

    public void build(int[] array){

        for (int i = 0; i < array.length; i++){
            add(array[i]);
        }
    }

    public void add(int value){

        data = increaseSize();

        data[size++] = value;
        handleSwipUp();
    }

    public int remove(){

        if (size == 0){
            throw new NoSuchElementException();
        }

        int root = data[0];

        data[0] = data[size - 1];
        data = Arrays.copyOf(data, --size);
        handleSwipDown();

        return root;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        return data[0];
    }

    private void handleSwipUp(){

        int index = size-1;
        while (hasParent(index) && parent(index) > data[index]){
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    private void handleSwipDown(){

        int index = 0;

        while(hasLeftChild(index)) {
            int smallerChild = getleftChild(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChild = getRightChild(index);
            }

            if (data[index] < data[smallerChild]){
                break;
            } else {
                swap(index, smallerChild);
            }

            index = smallerChild;
        }

    }

    private void swap(int index1, int index2){

        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private int[] increaseSize(){
        return Arrays.copyOf(data, size+1);

    }

    private int getParent(int i){
        return (i - 1) / 2;
    }

    private int getleftChild(int i){
        return i * 2 + 1;
    }

    private int getRightChild(int i){
        return i * 2 + 2;
    }

    private boolean hasLeftChild(int index){
        return getleftChild(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChild(index) < size;
    }

    private boolean hasParent(int index){
        return getParent(index) >= 0;
    }

    private int leftChild(int index) {
        return data[getleftChild(index)];
    }

    private int parent(int index){
        return data[getParent(index)];
    }

    private int rightChild(int index){
        return data[getRightChild(index)];
    }

    public String toString() {
        return Arrays.toString(data);
    }

}
