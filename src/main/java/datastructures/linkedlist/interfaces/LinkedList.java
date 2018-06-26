package dataStructure.linkedList.interfaces;

public interface LinkedList<E> {

    void add(E e);

    E remove();

    E remove(int index);

    boolean remove(E e);

    E getFirst();

    E getLast();

    E get(int index);

    int length();

}
