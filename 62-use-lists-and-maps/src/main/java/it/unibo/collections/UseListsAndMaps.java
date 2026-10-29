package it.unibo.collections;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int FIRST_NUMBER = 1000;
    private static final int LAST_NUMBER = 2000;
    private static final int FIRST_ELEM = 0;
    private static final int ELEMS = 100000;
    private static final int READS = 1000;

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arrayList = new ArrayList<Integer>();

        for (int i = FIRST_NUMBER; i < LAST_NUMBER; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkedList = new LinkedList<Integer>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = arrayList.getFirst();
        arrayList.set(FIRST_ELEM, arrayList.getLast());
        arrayList.set(arrayList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer elem : arrayList) {
            IO.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for (int i = FIRST_ELEM; i<=ELEMS; i++ ){
            arrayList.addFirst(i);
        }

        time = System.nanoTime() - time;

        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time);
        
        IO.println("The time needed to add" + ELEMS + "ints to an ArrayList is " + time + "ns (or " + millis1 + "ms).");

        time = System.nanoTime();

        for (int i = FIRST_ELEM; i<=ELEMS; i++ ){
            linkedList.addFirst(i);
        }

        time = System.nanoTime() - time;

        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time);
        
        IO.println("The time needed to add" + ELEMS + "ints to an ArrayList is " + time + "ns (or " + millis2 + "ms).");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();

        for (int i = FIRST_ELEM; i<=READS; i++) {
            arrayList.get(arrayList.size()/2);
        }

        time = System.nanoTime() - time;

        IO.println("The time needed to add" + ELEMS + "ints to an ArrayList is " + time + "ns");

        time = System.nanoTime();

        for (int i = FIRST_ELEM; i<=READS; i++) {
            linkedList.get(linkedList.size()/2);
        }

        time = System.nanoTime() - time;

        IO.println("The time needed to add" + ELEMS + "ints to an ArrayList is " + time + "ns");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        
        /*
         * 8) Compute the population of the world
         */
    }
}
