package chapter23;

/*
Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 23.9
File: main.java
Description:
Write the following tw generic methods using heap sort. The First method sorts using the
Comparable interface and the second uses the Comparable interface.

public static <E extends Comparable<E>> void heapSort(E[] list)

public static <E> void heapSort (E[] list, Comparator<? super E> comparator)

 */

import java.util.Comparator;
import java.util.Random;

public class Main {

    public static  void main(String[] args) {
        //create arrays
	    Integer[] comparableList = new Integer[10];
        Integer[] comparatorList = new Integer[10];

        // Create random number generator
        Random RNG = new Random();

        for (int i = 0; i < 10; i++) {
            comparableList[i] = RNG.nextInt(100);
            comparatorList[i] = RNG.nextInt(100);
        }


        System.out.println("Before Heap sort with comparator:");
        showList(comparatorList);

        System.out.println("After Heap sort with comparator:");
        heapSort(comparatorList, new heapComparator<>());
        showList(comparatorList);

        System.out.println("Before Heap sort with comparable:");
        showList(comparableList);

        System.out.println("After Heap sort with comparable:");
        heapSort(comparableList);
        showList(comparableList);
    }

    /**
     * show ints
     * @param list list to be shown
     */
    public static <E> void showList(E[] list) {
        for (E e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static <E extends Comparable<E>> void heapSort(E[] list){
        Heap<E> heap = new Heap<>();

        for (E e : list) {
            heap.add(e);
        }

        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }


    public static <E extends Comparable<E>> void heapSort(E[] list, Comparator<? super E> comparator) {
        comparatorHeap<E> heap =  new comparatorHeap<>(comparator);

        for (E e : list) {
            heap.add(e);
        }

        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }

    private static class heapComparator<E extends Comparable<E>> implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            if (o1.compareTo(o2) > 0){
                return 1;
            }else if (o1.compareTo(o2) < 0) {
                return -1;
            }
            return 0;
        }
    }
}
