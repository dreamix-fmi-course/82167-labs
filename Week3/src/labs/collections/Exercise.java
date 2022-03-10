package labs.collections;

import labs.collections.entity.Leg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise {

    // T0) Write a method to insert an element into the array list at the first position
    public <T> void insertFront(List<T> list, T element) {
        list.add(0, element);
    }

    // T1) Write a method to retrieve an element (at a specified index) from a given list.
    public <T> T getAt(List<T> list, int pos) {
        return list.get(pos);
    }

    // T2) Write a method to remove the third element from an array list.
    public <T> void removeThird(List<T> list) {
        list.remove(3);
    }

    // T3) Write a method to search an element in a list.
    public <T> boolean contains(List<T> list, T element) {
        return list.contains(element);
    }

    // T4) Write a method to sort a given array list. (list of String/Integer/Dog).
    // Implement Dog class with attribute breed and weight, sort the array by weight property.
    // Tip: implement the task with Comparator and Comparable
    public <T extends Comparable<T>> List<T> sort(List<T> list) {
        return list.stream()
            .sorted()
            .toList();
    }

    // T5) Write a method to replace the second element of a ArrayList with the specified element.
    public <T> void changeSecond(List<T> list, T newElement) {
        list.set(1, newElement);
    }

    // T6)?? Write a Java program to count the number of key-value (size) mappings in a map.
    public int getMapSize(Map<?, ?> map) {
        return map.size();
    }

    // T7) Write the following structure against aircraft tail number associate
    // list of leg information (fromAirport, toAirport, date).
    // Fill test information
    // Extract legs inside list/set that have from/to airport for a specific airport
    // (Example: All legs for airport LBSF)
    public Collection<Leg> getFrom(Collection<Leg> legs, String from) {
        return legs.stream()
            .filter(leg -> leg.getFromAirport().equals(from))
            .collect(Collectors.toSet());
    }

    public Collection<Leg> getTo(Collection<Leg> legs, String to) {
        return legs.stream()
            .filter(leg -> leg.getFromAirport().equals(to))
            .collect(Collectors.toSet());
    }
}