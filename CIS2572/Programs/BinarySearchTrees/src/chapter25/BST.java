package chapter25;

/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 25.9
File: BST.java
Description:
BST class from page 961-965 with clone and equals i

 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BST<T extends Comparable<T>> implements Tree<T>, Cloneable {
    protected TreeNode<T> root;
    protected int size = 0;

    /**
     * Create an empty binary tree
     */
    public BST() {
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(T[] objects) {
        for (T object : objects) {
            add(object);
        }
    }

    /**
     *
     * @return true if the element is in the tree
     */
    @Override
    public boolean search(T element) {
        TreeNode<T> current = root; // Start from the root

        while (current != null){
            if (element.compareTo(current.element) < 0){
                current = current.left;
            }else if (element.compareTo(current.element) > 0){
                current = current.right;
            }else
                return true;

        }
        return false;
    }

    /**
     * insert element e into the binary tree
     * @return true if the element is inserted successfully
     */
    public boolean insert(T element){
        if (root == null)
            root = createNewNode(element); // Create a new root
        else{
            // Locate the parent node
            TreeNode<T> parent = null;
            TreeNode<T> current = root;
            while (current != null){
                if (element.compareTo(current.element) < 0){
                    parent = current;
                    current = current.left;
                }else if (element.compareTo(current.element) > 0){
                    parent = current;
                    current = current.right;
                }
                else
                    return false; // Duplicate node not inserted


            }
            // Create the new node and attach it to the parent
            if (element.compareTo(parent.element) < 0)
                parent.left = createNewNode(element);
            else
                parent.right = createNewNode(element);
        }
        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<T> createNewNode(T element){
        return new TreeNode<>(element);
    }

    /**
     * Inorder traversal fromm the root
     */
    @Override
    public void inorder(){
        inorder(root);
    }

    /**
     * inorder traversal from a subtree
     */
    protected void inorder(TreeNode<T> root){
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    /**
     * postorder traversal from the root
     */
    @Override
    public void postorder(){
        postorder(root);
    }

    /**
     * postorder traversal from a subtree
     */
    protected void postorder(TreeNode<T> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    /**
     * Preorder traversal from the root
     */
    @Override
    public void preorder(){
        preorder(root);
    }

    /**
     * preorder traversal from a subtree
     */
    protected void preorder(TreeNode<T> root){
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * This inner class is static, because it does not access any
     * instance members defined in its outer class
     */
    public static class TreeNode<T>{
        protected T element;
        protected TreeNode<T> left;
        protected TreeNode<T> right;

        public TreeNode(T e){
            element = e;
        }
    }

    /**
     * Get the number of nodes in the tree
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * returns the root of the tree
     */
    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Return a path from the root leading to the specified element
     */
    public ArrayList<TreeNode<T>> path(T element) {
        ArrayList<TreeNode<T>> list = new ArrayList<>();
        TreeNode<T> current = root;

        while (current != null) {
            list.add(current); // add the node to the list
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            }else if (element.compareTo(current.element) > 0){
                current = current.right;
            }
            else break;

        }

        return list;
    }

    /**
     * Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree
     */
    public boolean delete(T element) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<T> parent = null;
        TreeNode<T> current = root;

        while (current != null) {
            if (element.compareTo(current.element) < 0){
                parent = current;
                current = current.left;
            }
            else if (element.compareTo(current.element) > 0){
                parent = current;
                current = current.right;
            }
            else break; // element is in the tree pointed at by current
        }

        if (current == null){
            return false; // element is not in the tree
        }

        // Case 1: Current has no left child
        if (current.left == null){
            // Connect th parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            }
            else{
                if (element.compareTo(current.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else{
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<T> parentOfRightMost = current;
            TreeNode<T> rightMost = current.left;

            while (rightMost.right != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // keep going to the right
            }

            // replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true; // element deleted successfully
    }

    /**
     * obtain an iterator. use inorder
     */
    @Override
    public Iterator<T> iterator(){
        return new inOrderIterator();
    }

    // these are here so I don't have to create an abstract class
    // they aren't going to be used so I think it should be ok
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * inner class inOrderIterator
     */
    private class inOrderIterator implements Iterator<T>{
        // Store the elements in a list
        private ArrayList<T> list = new ArrayList<>();
        private int current = 0; // Point to the  current element in list

        public inOrderIterator(){
            inorder(); // Traverse binary tree and store elements in list
        }

        /**
         * inorder traversal from the root
         */
        private void inorder(){
            inorder(root);
        }

        /**
         * inorder traversal from a subtree
         */
        private void inorder(TreeNode<T> root){
            if (root == null)return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }


        /**
         * More elements for traversing?
         */
        @Override
        public boolean hasNext(){
            if (current < list.size()){
                return true;
            }else return false;
        }

        /**
         * @Return the current element and move to the next
         */
        @Override
        public T next(){
            return list.get(current++);
        }

        /**
         * remove the current element
         */
        public void remove(){
            if (current == 0) // next() ahs not been called yet
                throw new IllegalStateException("Next() has not been called yet.");

            delete(list.get(--current));
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    /**
     * Remove all elements from the tree
     */
    @Override
    public void clear(){
        root = null;
        size = 0;
    }

    /**
     * @Return true if two trees are equal
     * Otherwise @Return false
     * 2 BST are equal if they contain the same elements
     */
    public boolean equals(BST<T> tree){
        if (tree.size != size) return false;
        return equals(root, tree.root);
    }

    /**
     * Equals recursive helper
     */
    protected boolean equals(TreeNode<T> root1, TreeNode<T> root2){
        if (root1 == root2) return true;
        if (root1 == null || root2 == null) return false;
        return root1.element.equals(root2.element) && equals(root1.left, root2.left) && equals(root1.right, root2.right);
    }

    /**
     * Overrides the protected clone method
     * defined in the Object class, and deep copy BST
     */
    @Override
    public BST<T> clone() throws CloneNotSupportedException {
        BST<T> cloneBST = new BST<T>();
        clone(cloneBST, root);
        return cloneBST;
    }

    /**
     * Clone recursive helper
     */
    protected void clone(BST<T> clone,TreeNode<T> root){
        if (root == null) return;
        clone.insert(root.element);
        clone(clone, root.left);
        clone(clone, root.right);
    }




}
