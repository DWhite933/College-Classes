package chapter24;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 24.15
File: MyList.java
Description:
MyList interface


 */


public interface MyList<T> extends Iterable<T> {

    void add(T element);

    void add(int index, T element);

    void clear();

    boolean contains(T element);

    T get(int index);

    int indexOf(Object element);

    boolean isEmpty();

    int lastIndexOf(Object element);

    boolean remove(T element);

    T remove(int index);

    Object set(int index, T element);

    int size();


}
