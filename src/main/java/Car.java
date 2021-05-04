import utils.ProgramUtils;

import java.util.Random;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getRandomNum() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());
        return random.nextInt(10);
    }

    public void move() {
        int getNum = getRandomNum();
        if (getNum >= 4) {
            setDistance(getDistance() + 1);
        }
    }

}
