package dataStructure.linkedList;

import dataStructure.linkedList.interfaces.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomLinkedListTest {

    LinkedList<String> linkedList;

    @BeforeEach
    void init() {
        linkedList = new CustomLinkedList<>();
        linkedList.add("test string");
        linkedList.add("test string 2");
        linkedList.add("test string 3");
    }

    @Test
    void add() {
        assertEquals("test string", linkedList.getFirst());
        assertEquals("test string 3", linkedList.getLast());
        assertEquals("test string 2", linkedList.get(1));
    }

    @Test
    void remove() {
        linkedList.remove();
        assertEquals(2, linkedList.length());
        assertEquals("test string 2", linkedList.getLast());
        assertEquals("test string", linkedList.getFirst());
    }

    @Test
    void remove1() {
        linkedList.remove(1);
        assertEquals(2, linkedList.length());
        assertEquals("test string 3", linkedList.getLast());
        assertEquals("test string", linkedList.getFirst());

    }

    @Test
    void remove2() {
        linkedList.remove("test string 2");
        assertEquals(2, linkedList.length());
        assertEquals("test string 3", linkedList.getLast());
        assertEquals("test string", linkedList.getFirst());
    }

    @Test
    void getFirst() {
        assertEquals("test string", linkedList.getFirst());
    }

    @Test
    void getLast() {
        assertEquals("test string 3", linkedList.getLast());
    }

    @Test
    void get() {
        assertEquals("test string 2", linkedList.get(1));
    }

    @Test
    void length() {
        assertEquals(3, linkedList.length());
    }
}