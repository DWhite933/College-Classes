package chapter24;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 24.15
File: MyArrayList.java
Description:
MyArrayList class


 */

import java.util.Iterator;


public class MyArrayList<T> extends AbstractList<T> {
    public static final int INITIAL_CAPACITY = 16;
    private T[] data = (T[]) new Object[INITIAL_CAPACITY];


    /**
     * Create an empty list
     */
    public MyArrayList() {

    }

    /**
     * Create a list from an array of objects
     */
    public MyArrayList(T[] objects) {
        for (T object : objects) {
            add(object);
        }
    }

    /**
     * add a new element at the specified index
     */
    @Override
    public void add(int index, T element) {
        // Ensure the index is in the right range
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        ensureCapacity();

        // move the elements to the right after the specified index
        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);

        // insert new element to data[index]
        data[index] = element;

        // increment size
        size++;
    }

    /**
     * create a new larger array
     * double the current size + 1
     */
    private void ensureCapacity() {
        if (size >= data.length) {
            T[] newData = (T[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    /**
     * clear the list
     */
    @Override
    public void clear() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Returns true if this list contains the element
     */
    @Override
    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the element at the specified index
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);

    }

    /**
     * Return the index of the first matching element in this list
     * else return -1
     */
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) return i;
        }
        return -1;
    }

    /**
     * Return the index of the last matching element in this list
     * else return -1
     */
    public int lastIndexOf(Object element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(data[i])) return i;
        }
        return -1;
    }

    /**
     * Remove the element at the specified position in thi list
     * Shift any subsequent elements to the left
     * Return the element that was removed from the list
     */
    @Override
    public T remove(int index) {
        checkIndex(index);

        T element = data[index];

        // Shift data to the left
        if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[size - 1] = null; // This element is now null

        // decrement size
        size--;

        return element;
    }

    /**
     * replace the element at the specified position in this list with the specified element
     */
    public T set(int index, T element) {
        checkIndex(index);
        T old = data[index];
        data[index] = element;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");

        }
        return result + "]";
    }

    /**
     * Trims the capacity to current size
     */
    public void trimToSize() {
        if (size != data.length) {
            T[] newData = (T[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    /**
     * Override iterator() defined in iterable
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Returns the number of elements in this list
     */
    public int size() {
        return size;
    }

    private class ArrayListIterator implements Iterator<T> {
        private int current = 0; // Current index;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            return data[current++];
        }

        /**
         * Remove the element returned by the last next()
         */
        @Override
        public void remove() {
            if (current == 0)
                throw new IllegalStateException("next() has not been called yet");
            MyArrayList.this.remove(--current);
        }
    }

}

