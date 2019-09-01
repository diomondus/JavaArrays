package com.butilov.example.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static java.util.stream.IntStream.range;

public class ArrayVsLinked {

    private static final int ELEM_COUNT = 100000;
    private static final int REPEATS = 1;

    public static void main(String[] args) {

        executeWRepeatsAndPrint(REPEATS, () -> createArrayListAndInsertItems(ELEM_COUNT));

        executeWRepeatsAndPrint(REPEATS, () -> createLinkedListAndInsertItems(ELEM_COUNT));

        executeWRepeatsAndPrint(REPEATS, () -> createLinkedListAndInsertItemsByListIterator(ELEM_COUNT));
    }

    private static Long createArrayListAndInsertItems(int count) {
        ArrayList<Integer> arrayList = new ArrayList<>(count * 2);
        range(0, count).forEach(arrayList::add);

        return executeWBenchmark(() -> {
            range(0, count).forEach(elem -> arrayList.add(elem, arrayList.size() / 2));
        });
    }

    private static long createLinkedListAndInsertItems(int count) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        range(0, count).forEach(linkedList::add);

        return executeWBenchmark(() -> {
            range(0, count).forEach(elem -> linkedList.add(elem, linkedList.size() / 2));
        });
    }

    private static long createLinkedListAndInsertItemsByListIterator(int count) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        range(0, count).forEach(linkedList::add);

        return executeWBenchmark(() -> {
            ListIterator<Integer> listIterator = linkedList.listIterator();
            range(0, linkedList.size() / 2).forEach(e -> listIterator.next());
            range(0, count).forEach(listIterator::add);
        });
    }

    private static void executeWRepeatsAndPrint(int repeats, Supplier<Long> timeSupplier) {
        long time = executeWRepeats(repeats, timeSupplier);
        System.out.println(TimeUnit.NANOSECONDS.toMillis(time / repeats));
    }

    private static long executeWRepeats(int repeats, Supplier<Long> timeSupplier) {
        return range(0, repeats).boxed()
                                .map(i -> timeSupplier.get())
                                .reduce(Long::sum)
                                .orElse((long) -1);
    }

    private static long executeWBenchmark(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        return end - start;
    }
}
