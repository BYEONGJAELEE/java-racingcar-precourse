import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RacingcarGame {

    private Set<Car> cars;
    private final int carNameLength = 5;
    private final String carNameDeleimeter = ",";

    public RacingcarGame() {
        this.cars = new HashSet<Car>();
    }

    public void startGame() {
        int carSize = readCarNames();
        if(carSize == 0) {
            System.out.println("자동차 이름은 최대 5자까지 가능합니다. 5자까지 가능한 이름을 최소 1개 이상 넣어주세요.");
        }
        readGameMatchNumber();
    }

    public int readCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), carNameDeleimeter);

            while(stringTokenizer.hasMoreTokens()) {
                addCar(stringTokenizer.nextToken().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cars.size();
    }

    public void addCar(String car) {
        if(car.length() <= carNameLength) {
            System.out.println(car);
            Car myCar = new Car(car);
            cars.add(myCar);
        }
    }

    private void readGameMatchNumber() {

    }

    public Set<Car> getCars() {
        return cars;
    }
}
