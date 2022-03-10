package labs.collections.entity;

public class Dog implements Comparable<Dog> {
    private final String name;
    private final short age;
    private final int weight;

    public Dog(String name, short age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog o) {
        return this.weight - o.weight;
    }
}