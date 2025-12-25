package ru.kchvilyov.utils;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompositeIterator<Integer> implements Iterator<Integer> {
    List<Iterator<Integer>> all;
    int currentIterator = 0;

    CompositeIterator(List<Iterator<Integer>> input) {
        all = input;
    }

    public boolean hasNext() {
        while (currentIterator < all.size()) {
            if (all.get(currentIterator).hasNext()) return true;
            else currentIterator++;
        }
        return false;
    }

    public Integer next() {
        if (hasNext()) {
            return all.get(currentIterator).next();
        }
        throw new NoSuchElementException();
    }
}