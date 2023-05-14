package chapter25;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 25.9
File: Tree.java
Description:
Tree class from page 958-960

 */

import java.util.Collection;

public interface Tree<T> extends Collection<T> {
    /**
     * Return true if the element is in the tree
     */
    boolean search(T element);

    /**
     * Insert element e into the binary tree
     * Returns true if the element is inserted successfully
     */
    boolean insert(T element);

    /**
     * Delete the specified element from the tree
     * Return true if the element is deleted successfully
     */
    boolean delete(T element);

    /**
     * get the number of elements in the tree
     */
    int getSize();

    /**
     * Inorder traversal from the root
     */
    void inorder();

    /**
     * Postorder traversal from the root
     */
    void postorder();

    /**
     * preorder traversal from the root
     */
    void preorder();

    /**
     * returns true if the tree is empty
     */
    @Override
    default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    default boolean contains(Object element) {
        return search((T) element);
    }

    @Override
    default boolean add(T element) {
        return insert(element);
    }

    @Override
    default boolean remove(Object element) {
        return delete((T) element);
    }

    @Override
    default int size() {
        return getSize();
    }


}
