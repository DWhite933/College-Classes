package generics;

public class Main {

    //example of max
    public static void main(String[] args) {
        // create list
        Integer[] integersList = {1, 3, 7, 9};

        System.out.println("The highest number in integerList is: " + max(integersList));


    }

    public static <E extends Comparable<E>> E max(E[] list) {
	E max = list[0]; // set max to fist item in list
        for (E e : list) {
            if (e.compareTo(max) > 0)
                max = e;
        }
        return max;
    }
}
