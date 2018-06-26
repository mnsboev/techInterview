package dataStructure.linkedList;

import dataStructure.linkedList.interfaces.LinkedList;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.NoSuchElementException;

import static lombok.AccessLevel.*;

@FieldDefaults(level = PRIVATE)
public class CustomLinkedList<E> implements LinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;

    @AllArgsConstructor
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
    }

    public CustomLinkedList() {
    }

    @Override
    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(e, null, l);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public E remove() {
        Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return removeLast(l);
    }

    @Override
    public E remove(int index) {
        return remove(getNodeByIndex(index));
    }
//
    @Override
    public boolean remove(E e) {
        try {
            remove(getNodeByItem(e));
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E getLast() {
        return last.item;
    }

    @Override
    public E get(int index) {
        return getNodeByIndex(index).item;
    }

    @Override
    public int length() {
        return size;
    }

    private E removeLast(Node<E> last) {
        E element = last.item;
        Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        this.last = prev;
        if (prev == null)
            first = null;
        else
            prev.next =null;
        size--;
        return element;
    }



    private Node<E> getNodeByIndex(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
        Node<E> f = first;
        if (index == 0)
            return first;
        for (int i = 1; i <= size; i++) {
            f = f.next;
            if (i == index) break;
        }
        return f;
    }

    private Node<E> getNodeByItem(E value) {
        Node<E> f = first;
        if (first.item.equals(value))
            return f;
        for (int i = 1; i <= size; i++) {
            f = f.next;
            if (f.item.equals(value)) break;
        }
        if (f == first) {
            throw new NoSuchElementException();
        }
        return f;
    }

    private E remove(Node<E> x) {
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

}
