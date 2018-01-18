package com.codecool.javabst.hashTable;


import org.junit.Test;
import static org.junit.Assert.*;


public class HashTableTest {


    @Test
    public void addTest() {

        HashTable<String, Integer> table = new HashTable<>();

        table.add("test1", 5);
        table.add("test2", 10);

        String expected = "{test2=10, test1=5}";

        assertEquals(expected, table.toString());
    }

    @Test
    public void getValue() {

        HashTable<String, Integer> table = new HashTable<>();

        table.add("test1", 5);
        table.add("test2", 10);

        assertEquals(Integer.valueOf(10), table.getValue("test2"));
    }

    @Test
    public void remove() {

        HashTable<String, Integer> table = new HashTable<>();

        table.add("test1", 5);
        table.add("test2", 10);

        table.remove("test1");

        assertEquals("{test2=10}", table.toString());
    }

    @Test
    public void clearAll() {

        HashTable<String, Integer> table = new HashTable<>();

        table.add("test1", 5);
        table.add("test2", 10);

        table.clearAll();

        assertEquals("{}", table.toString());
    }

    @Test
    public void isEmpty() {

        HashTable<String, Integer> table = new HashTable<>();

        assertTrue(table.isEmpty());

    }
}
