package chapter23;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 23.9
File: main.java
Description:
Heap class from the book with comparator implementation

 */

import java.util.ArrayList;
import java.util.Comparator;

public class comparatorHeap<E> {
    private Comparator<? super E> comparator;

    private ArrayList<E> list = new ArrayList<>();

    /**
     * Create a default heap
     */
    public comparatorHeap(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /**
     * Add new object to the heap
     * @param newObject the object to be added
     */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap

        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0){
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }else
                break;

            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove(){
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()){
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()){
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0){
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0){
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }else
                break;
        }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return list.size();
    }


}
