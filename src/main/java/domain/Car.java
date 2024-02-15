package domain;

public class Car implements Comparable<Car> {

    private final Distance distance; //TODO: final
    private final Name name;

    public Car(Name name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car fromName(String name) {
        return new Car(Name.from(name), Distance.init());
    }

    public static Car fromEmpty() {
        return new Car(Name.empty(), Distance.init());
    }

    public static Car of(String name, int distance) {
        return new Car(Name.from(name), Distance.from(distance));
    }


    public void move() {
        distance.increase();
    }

    public Distance getDistance() {
        return distance;
    }

    public Name getName() {
        return name;
    }

    public boolean isSameDistance(Car maxDistance) {
        return distance.isSameDistance(maxDistance.distance);
    }

    @Override
    public int compareTo(Car other) {
        return this.distance.compareTo(other.distance);
    }
}
