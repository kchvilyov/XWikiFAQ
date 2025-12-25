package ru.kchvilyov.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CompositeIteratorSimpleTest {

    @Test
    void hasNext() {
        Iterator<Integer> it1 = Arrays.asList(5, 1, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5).iterator();
        Iterator<Integer> it3 = Arrays.asList(6, 7, 8).iterator();

        CompositeIteratorSimple<Integer> all =
                new CompositeIteratorSimple<>(Arrays.asList(it1, it2, it3));

        StringBuffer sb = new StringBuffer();
        while (all.hasNext()) {
            sb.append(all.next()).append(" ");
        }
        assertEquals("5 1 3 4 5 6 7 8 ", sb.toString());
        System.out.println(sb);
    }
}