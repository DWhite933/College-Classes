package chapter24;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 24.15
File: main.java
Description:
Design and write a complete test program to test if the MyArrayList class in listing 24.2 meets all requirements.

 */


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Test no arg constructor
        MyArrayList<Integer> blankList = new MyArrayList<>();
        System.out.println("no-arg constructor: " + blankList);

        // Test array-arg constructor
        Integer[] numbers = {24, -21, 5, 22, 37, 777};

        MyArrayList<Integer> list = new MyArrayList<>(numbers);
        System.out.println("Array-arg Constructor: " + list);

        // test list function
        list.add(0, 10);
        System.out.println("list.add(0, 10): " + list);
        list.add(2, -7);
        System.out.println("list.add(2, -7): " + list);

        // this would test the out-of-bounds exception for the add function
        // list.add(15, 15);
        // System.out.println("list.add(15, 15): " + list);

        // test clear function
        list.clear();
        System.out.println("list.clear(): " + list);

        // Recreate list
        list = new MyArrayList<>(numbers);
        System.out.println("Recreate list: " + list);

        // test contains function
        System.out.println("list.contains(20): " + list.contains(20));
        System.out.println("list.contains(-2): " + list.contains(-2));

        // test get function
        System.out.println("list.get(0): " + list.get(0));
        System.out.println("list.get(3): " + list.get(3));
        System.out.println("list.get(5): " + list.get(5));

        // this would test the out-of-Bounds exception for the get function
        // System.out.println("list.get(6): " + list.get(6));

        // test indexOf function
        System.out.println("list.indexOf(5): " + list.indexOf(5));
        System.out.println("list.indexOf(777): " + list.indexOf(777));
        System.out.println("list.indexOf(69): " + list.indexOf(69)); // heh nice

        // test add and lastIndexOf functions
        list.add(5);
        System.out.println("list.add(5): " + list);
        System.out.println("list.lastIndexOf(5): " + list.lastIndexOf(5));
        list.add(5, 0);
        System.out.println("list.add(5, 0): " + list);
        System.out.println("list.lastIndexOf(0): " + list.lastIndexOf(0));

        // test remove function
        System.out.println("list.remove(0): " + list.remove(0));
        System.out.println("After list.remove(0): " + list);
        System.out.println("list.remove(3): " + list.remove(3));
        System.out.println("After list.remove(3): " + list);
        System.out.println("list.remove(5): " + list.remove(5));
        System.out.println("After list.remove(5): " + list);
        // this would test the out-of-bounds exception for the remove function
        // System.out.println("list.remove(7): " + list.remove(7));

        // test set function
        System.out.println("list.set(0, 30): " + list.set(0, 30));
        System.out.println("After list.set(0, 30): " + list);
        System.out.println("list.set(3, -2): " + list.set(3, -2));
        System.out.println("After list.set(0, 30): " + list);
        // this would test the out-of-bounds exception for the set function
        // System.out.println("list.set(7, 27): " + list.set(7, 27));

        // test trimToSize function
        System.out.println("trimTOSize()");
        list.trimToSize();
        System.out.println(list);

        // test isEmpty and size functions
        System.out.println("isEmpty? " + list.isEmpty());
        System.out.println("size? " + list.size);

        // test object removal
        System.out.println("list.remove(Integer.valueOf(30)): " + list.remove(Integer.valueOf(30)));
        System.out.println("After list.remove(Integer.valueOf(30): " + list);

        // test iterator
        Iterator<Integer> iterate = list.iterator();
        System.out.println("Testing iterator:");
        while (iterate.hasNext()) {
            System.out.print(iterate.next() + ", ");
        }
        System.out.println();
    }
}
