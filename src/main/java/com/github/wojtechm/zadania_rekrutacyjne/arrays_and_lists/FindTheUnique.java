package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of some elements
 * write a method that will find unique element.
 * For edge case handing see provided tests.
 *
 * [1, 1, 2, 1, 1]  => 2
 * ['a', 'b', 'b']  => 'a'
 *
 * There always will be just one unique element
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.MEDIUM)
class FindTheUnique {

    private FindTheUnique(){}

    static <T extends Comparable<T>> T findUnique(List<T> list) {
        if (list == null) throw new IllegalArgumentException();
        if (list.size() == 2) throw new IllegalArgumentException();
        Comparator<T> comparator = Comparator.nullsFirst(T::compareTo);
        list.sort(comparator);
        for (var i = 0; i < list.size() - 2; i++) {
            if (equalsWithNull(list.get(i), list.get(i + 1)) &&
                    !equalsWithNull(list.get(i), list.get(i + 2))) return list.get(i + 2);
            if (equalsWithNull(list.get(i + 1), list.get(i + 2)) &&
                    !equalsWithNull(list.get(i + 1), list.get(i))) return list.get(i);
            if (equalsWithNull(list.get(i + 2), list.get(i)) &&
                    !equalsWithNull(list.get(i + 2), list.get(i + 1))) return list.get(i + 1);
        }
        return null;
    }

    private static boolean equalsWithNull(Object t1, Object t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null) return false;
        return t1.equals(t2);
    }
}
