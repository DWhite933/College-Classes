package chapter24;
/*

Name: David White
Class: CIS2572
Instructor:  Mohammad Morovati
Assignment: Programming exercise 24.15
File: AbstractList.java
Description:
AbstractList class


 */

public abstract class AbstractList<T> implements MyList<T> {
    protected int size = 0;
    protected AbstractList(){

    }

    protected AbstractList(T[] objects) {
        for (T object : objects) {
            add(object);
        }
    }

    @Override
    public void add(T object) {
        add(size, object);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean remove(T element) {
        if (indexOf(element) >= 0){
            remove(indexOf(element));
            return true;
        }return false;
    }

}
