public class Car {
    private final String name;
    private final int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }


    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
