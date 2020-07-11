package com.github.wojtechm.zadania_rekrutacyjne.arrays_and_lists;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;

import java.util.*;

/**
 * Given a list of some elements
 * write a method that will find unique element ---> between others the same <---.
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
        Object notUnique = null;
        for (var i = 0; i < list.size(); i++) {
            if (equalsWithNull(list.get(i), list.get(i + 1)) ||
                    equalsWithNull(list.get(i), list.get(i + 2)) ) {
                notUnique = list.get(i);
                break;
            }
        }
        for (T t : list) {
            if (!equalsWithNull(t, notUnique)) {
                return t;
            }
        }
        return null;
    }

    private static boolean equalsWithNull(Object t1, Object t2) {
        if (t1 == t2) return true;
        if (t1 == null || t2 == null) return false;
        return t1.equals(t2);
    }
}
