package chapter25;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 25.9
File: main.java
Description:
Implement the clone and equals methods in the BST class. Two BST trees are equal if
they contain the same elements. The clone method returns an identical copy of a BST.

 */

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
	    Integer[] nums = {9, 67, 72, 32, 53, 4, 5, 6, 85, 1};
        Integer[] nums2 = {9, 67, 72, 32, 53, 4, 5, 6, 85, 1};

        // Create 2 Integer BST
        BST<Integer> integerTree = new BST<>(nums);
        BST<Integer> integerTree2 = new BST<>(nums2);

        // Display preorder BST
        System.out.print("integerTree: ");
        integerTree.preorder();
        System.out.print("\nintegerTree2: ");
        integerTree2.preorder();

        // Clone integerTree
        BST<Integer> treeClone = integerTree.clone();

        // Equality test
        System.out.println("\nIs integerTree equal to integerTree2? " + integerTree.equals(integerTree2));
        System.out.println("Is integerTree equal to treeClone? " + integerTree.equals(treeClone));

        // Display preorder BST
        System.out.println("treeClone: ");
        treeClone.preorder();
        System.out.println();

    }
}
