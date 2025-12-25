package ru.kchvilyov.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CompositeIteratorSimple<Integer> implements Iterator<Integer> {
    private final Iterator<Integer> iterator;

    CompositeIteratorSimple(List<Iterator<Integer>> input) {
        List<Integer> all = new LinkedList<>();
        for (Iterator<Integer> i : input) {
            while (i.hasNext()) {
                all.add(i.next());
            }
        }
        iterator = all.iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Integer next() {
        return iterator.next();
    }
}