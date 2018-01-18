package com.codecool.javabst.heap;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinHeapTest {


    @Test
    public void build() {

        MinHeap heap = new MinHeap();

        int[] array = new int[] {17, 25, 10, 5, 1, 34};
        heap.build(array);

        String expected = "[1, 5, 17, 25, 10, 34]";

        assertEquals(expected, heap.toString());

    }

    @Test
    public void add() {

        MinHeap heap = new MinHeap();

        int[] array = new int[] {17, 25, 10, 5, 1, 34};
        heap.build(array);
        heap.add(7);

        String expected = "[1, 5, 7, 25, 10, 34, 17]";

        assertEquals(expected, heap.toString());
    }

    @Test
    public void remove() {

        MinHeap heap = new MinHeap();

        int[] array = new int[] {12, 13, 3, 24, 5};
        heap.build(array);
        heap.remove();

        String expected = "[5, 13, 12, 24]";

        assertEquals(expected, heap.toString());
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void peek() {
        MinHeap heap = new MinHeap();

        int[] array = new int[] {17, 25, 10, 5, 1, 34};
        heap.build(array);

        assertEquals(1, heap.peek());

    }
}
