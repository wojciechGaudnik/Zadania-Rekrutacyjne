package com.github.wojtechm.zadania_rekrutacyjne.string;

import com.github.wojtechm.zadania_rekrutacyjne.tools.Difficulty;
import com.github.wojtechm.zadania_rekrutacyjne.tools.Level;
import org.yaml.snakeyaml.util.ArrayStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given a String consisting of alphabetic characters only,
 * write a method - reduce that returns the given string with all equal characters
 * next to each other removed. Operation stops when no duplicates are neighboring;
 *
 * "book"   => "bk"
 * "abba"   => ""
 * "abcba"  => "abcba"
 * "aAaAaA" => "aAaAaA"
 * "ooabc"  => "abc"
 *
 * @author Wojciech Makieła
 */
@Difficulty(Level.MEDIUM)
class Reduce {

    private static final String MESSAGE = "Cannot reduce null";

    private Reduce(){}

    static String reduce3(String toReduce) {    //todo tests 19 356 ms
        if(toReduce == null) throw new IllegalArgumentException(MESSAGE);
        Deque<Character> stack = new LinkedList<>();

        for (var c : toReduce.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return new StringBuilder(stack.stream().map(String::valueOf).collect(Collectors.joining())).reverse().toString();
    }

    static String reduce2(String toReduce) {     //todo tests 19 728 ms
        if(toReduce == null) throw new IllegalArgumentException(MESSAGE);
        var stack = new ArrayStack<Character>(toReduce.length());

        for (var c : toReduce.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                var top = stack.pop();
                if (top != c) {
                    stack.push(top);
                    stack.push(c);
                }
            }
        }
        var answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }

    static String reduce(String toReduce) {     //todo tests 28 218 ms
        if(toReduce == null) throw new IllegalArgumentException(MESSAGE);
        var stack = new Stack<Character>();

//        Synchronized classes Vector, Hashtable, Stack and StringBuffer should not be used
//        java:S1149
//        Early classes of the Java API, such as Vector, Hashtable and StringBuffer, were synchronized to make them thread-safe. Unfortunately, synchronization has a big negative impact on performance, even when using these collections from a single thread.
//        It is better to use their new unsynchronized replacements:
//        ArrayList or LinkedList instead of Vector
//        Deque instead of Stack
//        HashMap instead of Hashtable
//        StringBuilder instead of StringBuffer

        for (var c : toReduce.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
